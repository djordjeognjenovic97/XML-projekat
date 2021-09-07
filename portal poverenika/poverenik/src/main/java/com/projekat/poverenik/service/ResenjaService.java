package com.projekat.poverenik.service;

import com.projekat.poverenik.dom.DOMParser;
import com.projekat.poverenik.dto.QueryResenjeDTO;
import com.projekat.poverenik.dto.ResenjeDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiReaderExample;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.korisnici.Korisnik;
import com.projekat.poverenik.model.resenje.Resenje;
import com.projekat.poverenik.model.zalbacutanjecir.Zalbacutanje;
import com.projekat.poverenik.model.zalbanaodlukucir.Zalbaodluka;
import com.projekat.poverenik.repository.ResenjaRepository;
import com.projekat.poverenik.repository.ZalbacutanjecirRepository;
import com.projekat.poverenik.repository.ZalbanaodlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    @Autowired
    private ZalbacutanjecirRepository zalbacutanjecirRepository;

    @Autowired
    private ZalbanaodlukuRepository zalbanaodlukuRepository;

    private DOMParser domParser;
    private MetadataExtractor metadataExtractor;
    private JaxbParser jaxbParser;

    public ResenjaService() throws IOException, SAXException {
        metadataExtractor = new MetadataExtractor();
        domParser = new DOMParser();
        jaxbParser = new JaxbParser();
    }

    public void addResenjeFromText(String text) throws Exception {
        System.out.println(text);
        Resenje resenje = jaxbParser.unmarshall(Resenje.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        resenje.getDatum().setValue(now);
        String email = "";
        email = pronadjiEmail(resenje.getId());
        resenje.setEmailGradjanina(email);
        System.out.println(email);
        String docId = resenje.getBrojResenja().getValue();

        text = jaxbParser.marshallString(Resenje.class,resenje);

        resenjaRepository.saveResenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text, new FileOutputStream(new File("src/main/resources/rdf/resenje"+docId)));
        FusekiWriterExample.saveRDF("resenje" + docId, "/resenje");
        posaljiResenje(resenje);
        posaljiMejl(email, resenje);
        promeniStanjeZalbe(resenje.getId());
    }

    private void promeniStanjeZalbe(String id) throws Exception {
        ArrayList<Zalbacutanje> zcs=zalbacutanjecirRepository.findAll();
        for(Zalbacutanje z:zcs){
            if(z.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                z.setStanje("reseno");
                String text = jaxbParser.marshallString(Zalbacutanje.class,z);
                zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, id);
                break;
            }
        }
        ArrayList<Zalbaodluka> zos=zalbanaodlukuRepository.findAll();
        for(Zalbaodluka zo:zos){
            if(zo.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                zo.setStanje("reseno");
                String text = jaxbParser.marshallString(Zalbaodluka.class,zo);
                zalbanaodlukuRepository.saveZalbanaodlukucirFromText(text, id);
                break;
            }
        }
    }

    private void posaljiMejl(String email, Resenje resenje) throws Exception {
        String soapEndpointUrl = "http://localhost:8088/ws/email";
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("es", "http://email");

        SOAPBody soapBody = envelope.getBody();
        envelope.addNamespaceDeclaration("es", "http://email");
        SOAPElement pismoElem = soapBody.addChildElement("email", "es");
        pismoElem.setAttribute("attachmentType", "PDF");
        SOAPElement primalacElem = pismoElem.addChildElement("to", "es");
        primalacElem.addTextNode(email);
        SOAPElement naslovElem = pismoElem.addChildElement("subject", "es");
        naslovElem.addTextNode("Rešenje");
        SOAPElement sadrzajElem = pismoElem.addChildElement("content", "es");
        String sadr= "Vaš odgovor na žalbu je kreiran. Rešenje" +
                "možete pogledati na preko linka: http://localhost:4201/prikaz/resenje/"+resenje.getBrojResenja().getValue();
        sadrzajElem.addTextNode(sadr);
        SOAPElement prilogElem = pismoElem.addChildElement("attachment", "es");
        //OVDE UBACITI NEKAKO
        downloadPDF(resenje.getBrojResenja().getValue());
        String fileName = "src/main/resources/pdf/Resenje"+resenje.getBrojResenja().getValue();
        Path filePath = Paths.get(fileName);
        byte[] data = Files.readAllBytes(filePath);
        prilogElem.addTextNode(Base64.getEncoder().encodeToString(data));

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
    }

    private void posaljiResenje(Resenje resenje) throws SOAPException {
        String soapEndpointUrl = "http://localhost:8080/ws/resenje";

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("res", "https://github.com/djordjeognjenovic97/XML-projekat/resenja");

        SOAPBody soapBody = envelope.getBody();
        envelope.addNamespaceDeclaration("res", "https://github.com/djordjeognjenovic97/XML-projekat/resenja");
        SOAPElement resElem = soapBody.addChildElement("resenje", "res");
        resElem.setAttribute("email_gradjanina", resenje.getEmailGradjanina());
        resElem.setAttribute("id", resenje.getId());

        SOAPElement datumElem = resElem.addChildElement("datum", "res");
        datumElem.addTextNode(resenje.getDatum().getValue().toString());
        datumElem.setAttribute("property", "pred:datum");

        SOAPElement brRElem = resElem.addChildElement("broj_resenja", "res");
        brRElem.addTextNode(resenje.getBrojResenja().getValue());
        brRElem.setAttribute("property", "pred:broj_resenja");

        SOAPElement stat=resElem.addChildElement("status","res");
        stat.addTextNode(resenje.getStatus());

        SOAPElement grElem = resElem.addChildElement("gradjanin", "res");
        grElem.addTextNode(resenje.getGradjanin().getValue());
        grElem.setAttribute("property", "pred:gradjanin");

        SOAPElement datPod=resElem.addChildElement("datum_podnosenja","res");
        datPod.addTextNode(resenje.getDatumPodnosenja().toString());

        SOAPElement opisZElem = resElem.addChildElement("opis_zalbe", "res");
        SOAPElement raz=opisZElem.addChildElement("razlog","res");
        raz.addTextNode(resenje.getOpisZalbe().getRazlog());
        SOAPElement nao=opisZElem.addChildElement("na_osnovu","res");
        nao.addTextNode(resenje.getOpisZalbe().getNaOsnovu());

        SOAPElement zakonElem1 = opisZElem.addChildElement("zakon", "res");
        SOAPElement cl=zakonElem1.addChildElement("clan","res");
        cl.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getClan().get(0));
        SOAPElement stav=zakonElem1.addChildElement("stav","res");
        stav.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getStav().get(0));
        SOAPElement tacka=zakonElem1.addChildElement("tacka","res");
        tacka.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getTacka().get(0));
        SOAPElement nazz=zakonElem1.addChildElement("naziv_zakona","res");
        nazz.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getNazivZakona().get(0));
        SOAPElement nazs=zakonElem1.addChildElement("naziv_sluzbenog_glasnika","res");
        nazs.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getNazivSluzbenogGlasnika());
        SOAPElement brsl=zakonElem1.addChildElement("broj_slg","res");
        brsl.addTextNode(resenje.getOpisZalbe().getZakon().get(0).getBrojSlg().get(0));

        SOAPElement resZElem = resElem.addChildElement("resenje_zalbe", "res");
        SOAPElement rok=resZElem.addChildElement("rok_trajanja_mora_izvrsi_resenje","res");
        rok.addTextNode(resenje.getResenjeZalbe().getRokTrajanjaMoraIzvrsiResenje());
        SOAPElement dokt=resZElem.addChildElement("dokument_koji_se_trazi","res");
        dokt.addTextNode(resenje.getResenjeZalbe().getDokumentKojiSeTrazi());
        SOAPElement rtp=resZElem.addChildElement("rok_trajanja_provera","res");
        rtp.addTextNode(resenje.getResenjeZalbe().getRokTrajanjaProvera());

        SOAPElement obrZElem = resElem.addChildElement("obrazlozenja_zalbe", "res");
        SOAPElement di=obrZElem.addChildElement("datum_izjasnjenja","res");
        di.addTextNode(resenje.getObrazlozenjaZalbe().getDatumIzjasnjenja().toString());
        SOAPElement dti=obrZElem.addChildElement("datum_trazenja_informacija","res");
        dti.addTextNode(resenje.getObrazlozenjaZalbe().getDatumTrazenjaInformacija().toString());
        SOAPElement doo=obrZElem.addChildElement("datum_odgovora","res");
        doo.addTextNode(resenje.getObrazlozenjaZalbe().getDatumOdgovora().toString());
        SOAPElement rodl=obrZElem.addChildElement("razlozi_odluke","res");
        SOAPElement pas1=rodl.addChildElement("pasus","res");
        pas1.addTextNode(resenje.getObrazlozenjaZalbe().getRazloziOdluke().getPasus().get(0));

        SOAPElement povElem = resElem.addChildElement("poverenik", "res");
        SOAPElement poviElem = povElem.addChildElement("ime", "res");
        poviElem.addTextNode(resenje.getPoverenik().getPrezime().getValue());
        poviElem.setAttribute("property", "pred:ime");
        SOAPElement povpElem = povElem.addChildElement("prezime", "res");
        povpElem.addTextNode(resenje.getPoverenik().getPrezime().getValue());
        povpElem.setAttribute("property", "pred:prezime");

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
    }

    private String pronadjiEmail(String id) throws Exception {
        ArrayList<Zalbacutanje> zcs=zalbacutanjecirRepository.findAll();
        for(Zalbacutanje z:zcs){
            if(z.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                return z.getPodnosilacZalbe().getEmail();
            }
        }
        ArrayList<Zalbaodluka> zos=zalbanaodlukuRepository.findAll();
        for(Zalbaodluka zo:zos){
            if(zo.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                return zo.getPodnosilacZalbe().getEmail();
            }
        }
        return "";
    }

    public void addResenjeFromFile(String path) throws Exception {
        Document document = domParser.buildDocumentFromFile(path);
        NodeList ndBroj = document.getElementsByTagName("broj_zalbe");
        String docId = ndBroj.item(0).getTextContent();
        resenjaRepository.saveResenjeFromFile(path, docId);
        String text = domParser.getDocumentAsString(document);
//        metadataExtractor.extractMetadata(text);
//        FusekiWriterExample.saveRDF();
    }

    public Document getResenjeDocument(String docId) throws Exception {
        Document doc = resenjaRepository.findResenjeById(docId);
        return doc;
    }

    public List<ResenjeDTO> getUsersResenje() throws Exception {
        ArrayList<Resenje> rs= resenjaRepository.findAll();
        List<ResenjeDTO> ids =new ArrayList<ResenjeDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Resenje r : rs) {
            if (r.getEmailGradjanina() != null && r.getEmailGradjanina().equalsIgnoreCase(user.getEmail())) {
                ids.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
            }
        }
        return ids;
    }

    public List<ResenjeDTO> getAllResenje() throws Exception {
        ArrayList<Resenje> rs= resenjaRepository.findAll();
        List<ResenjeDTO> ids =new ArrayList<ResenjeDTO>();
        for(Resenje r : rs) {
            ids.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        return ids;
    }

    public List<ResenjeDTO> getSearchResenje(String content) throws Exception {
        ArrayList<Resenje> rs= resenjaRepository.findByContent(content);
        List<ResenjeDTO> ids =new ArrayList<ResenjeDTO>();
        for(Resenje r : rs) {
            ids.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        return ids;
    }

    public List<ResenjeDTO> getSearchMetadataResenje(QueryResenjeDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("broj_resenja", dto.getBrojPredmeta());
        params.put("datum", dto.getDatum());
        params.put("ime", dto.getImePoverenika());
        params.put("prezime", dto.getPrezimePoverenika());
        params.put("gradjanin", dto.getGradjanin());
        params.put("naziv_optuzenog", dto.getNazivOptuzenog());
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params, "/resenje");
        List<ResenjeDTO> rs=new ArrayList<ResenjeDTO>();
        for(String id :ids){
            Resenje r = resenjaRepository.findRealResenjeById(id.split("\\^")[0]);
            rs.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        System.out.println(ids + "   " + rs.size());
        return rs;
    }

    public void downloadJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("broj_resenja", id);
        params.put("datum", "");
        params.put("ime", "");
        params.put("prezime", "");
        params.put("gradjanin", "");
        params.put("naziv_optuzenog", "");
        FusekiReaderExample.executeQueryforJSON(params,"/resenje",id);
    }

    public String downloadHTML(String id) throws Exception {
        Document d=resenjaRepository.findResenjeById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/resenje.xsl",d,"src/main/resources/html/Resenje"+id);
    }

    public void downloadPDF(String id) throws Exception {
        String str=resenjaRepository.findResenjeByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/resenje_fo.xsl","src/main/resources/pdf/Resenje"+id);

    }
}
