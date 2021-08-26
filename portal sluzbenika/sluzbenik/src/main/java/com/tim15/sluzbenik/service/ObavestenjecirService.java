package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dto.ObavestenjeDTO;
import com.tim15.sluzbenik.dto.QueryObavestenjeDTO;
import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiReaderExample;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.repository.ObavestenjecirRepository;
import com.tim15.sluzbenik.repository.ZahtevicirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ObavestenjecirService {
    @Autowired
    private ObavestenjecirRepository obavestenjecirRepository;

    @Autowired
    private ZahtevicirRepository zahtevicirRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    private final String obavestenjeXSLPath = "src/main/resources/xsl/obavestenjecir.xsl";
    private static String pdfXSLPath = "src/main/resources/xsl/obavestenjecirToPDF.xsl";

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ObavestenjecirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addObavestenjeFromText(String text) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshall(Obavestenje.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        Obavestenje.Datum datum = obavestenje.getDatum();
        datum.setValue(now);
        obavestenje.setDatum(datum);
//        long sada=(new Date()).getTime();
//        Obavestenje.BrojPredmeta idz= obavestenje.getBrojPredmeta();
//        idz.setValue(String.valueOf(sada));
//        obavestenje.setBrojPredmeta(idz);
        Zahtev z=zahtevicirRepository.findRealZahtevById(obavestenje.getBrojPredmeta().getValue());
        z.setStanje("usvojen");
        System.out.println(z.getId().getValue()+" zahtev je usvojen.");
        String ztext = jaxbParser.marshallString(Zahtev.class,z);
        zahtevicirRepository.saveZahtevFromText(ztext, z.getId().getValue());

        obavestenje.getPodnosilacZahteva().setEmail(z.getTrazilacInformacije().getEmail());

        String docId = obavestenje.getBrojPredmeta().getValue();

//        //SLANJE OBAVESTENJA GRADJANINU NA MAIL
//        posaljiObavestenjeMailom(obavestenje,docId,z.getTrazilacInformacije().getEmail());

        text = jaxbParser.marshallString(Obavestenje.class,obavestenje);

        obavestenjecirRepository.saveObavestenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/Obavestenje"+docId)));
        FusekiWriterExample.saveRDF("Obavestenje"+docId,"/obavestenja");
    }

    public void addObavestenjeFromFile(String path) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshallFile(Obavestenje.class, path);
        String docId = obavestenje.getBrojPredmeta().getValue();
        obavestenjecirRepository.saveObavestenjeFromFile(path, docId);
        String text = jaxbParser.marshallString(Obavestenje.class, obavestenje);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/obavestenja");
    }

    public Document getObavestenjeDocument(String docId) throws Exception {
        Document doc = obavestenjecirRepository.findObavestenjeById(docId);
        return doc;
    }

    public String convertXMLtoHTML(String id) throws Exception {
        Document xml = obavestenjecirRepository.findObavestenjeById(id);
        return xslTransformer.convertXMLtoHTML(obavestenjeXSLPath, xml);
    }

    public Resource getPdf(String id) throws Exception {
        Document xml = obavestenjecirRepository.findObavestenjeById(id);

        String xmlString = xslTransformer.XMLToString(xml);
        ByteArrayOutputStream outputStream = xslTransformer.generatePDf(xmlString, pdfXSLPath);

        Path file = Paths.get(id + ".pdf");
        Files.write(file, outputStream.toByteArray());

        return new UrlResource(file.toUri());
    }


    public List<ObavestenjeDTO> getUsersObavestenja() throws Exception {
        ArrayList<Obavestenje> obavestenjas= obavestenjecirRepository.findAll();
        List<ObavestenjeDTO> ids =new ArrayList<ObavestenjeDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Obavestenje z : obavestenjas) {
            if (z.getPodnosilacZahteva().getEmail() != null && z.getPodnosilacZahteva().getEmail().equalsIgnoreCase(user.getEmail())) {
                ids.add(new ObavestenjeDTO(z.getBrojPredmeta().getValue(),z.getOrgan().getNazivOrgana().getValue(),z.getDatum().getValue().toString()));
            }
        }
        return ids;
    }

    public List<ObavestenjeDTO> getAllObavestenja() throws Exception {
        ArrayList<Obavestenje> obavestenjas= obavestenjecirRepository.findAll();
        List<ObavestenjeDTO> ids =new ArrayList<ObavestenjeDTO>();
        for(Obavestenje z : obavestenjas) {
            ids.add(new ObavestenjeDTO(z.getBrojPredmeta().getValue(),z.getOrgan().getNazivOrgana().getValue(),z.getDatum().getValue().toString()));
        }
        return ids;
    }

    public List<ObavestenjeDTO> getSearchObavestenja(String content) throws Exception {
        ArrayList<Obavestenje> obavestenjas= obavestenjecirRepository.findByContent(content);
        List<ObavestenjeDTO> ids =new ArrayList<ObavestenjeDTO>();
        for(Obavestenje z : obavestenjas) {
            ids.add(new ObavestenjeDTO(z.getBrojPredmeta().getValue(),z.getOrgan().getNazivOrgana().getValue(),z.getDatum().getValue().toString()));
        }
        return ids;
    }

    public List<ObavestenjeDTO> getSearchMetadataObavestenja(QueryObavestenjeDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("naziv_organa", dto.getNazivOrgana());
        params.put("broj_predmeta", dto.getBrojPredmeta());
        params.put("datum", dto.getDatum());
        params.put("ime", dto.getImePodnosioca());
        params.put("prezime", dto.getPrezimePodnosioca());
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params,"/obavestenja");
        List<ObavestenjeDTO> obavestenja=new ArrayList<ObavestenjeDTO>();
        for(String id :ids){
            Obavestenje z=obavestenjecirRepository.findRealObavestenjeById(id.split("\\^")[0]);
            obavestenja.add(new ObavestenjeDTO(z.getBrojPredmeta().getValue(),z.getOrgan().getNazivOrgana().getValue(),z.getDatum().getValue().toString()));
        }
        System.out.println(ids+"   "+obavestenja.size());
        return obavestenja;
    }

    private void posaljiObavestenjeMailom(Obavestenje o,String id,String to) throws SOAPException {

        //TREBA UBACITI OBAVESTENJE U MAIL ATTACHMENT KAO PDF I  HTML

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
        pismoElem.setAttribute("attachmentType", "");
        SOAPElement primalacElem = pismoElem.addChildElement("to", "es");
        primalacElem.addTextNode(to);
        SOAPElement naslovElem = pismoElem.addChildElement("subject", "es");
        naslovElem.addTextNode("Usvajanje zahteva");
        SOAPElement sadrzajElem = pismoElem.addChildElement("content", "es");
        sadrzajElem.addTextNode("Vas zahtev sa ID brojem:"+id+" je usvojen.");

        SOAPElement prilogElem = pismoElem.addChildElement("attachment", "es");
        //OVDE UBACITI NEKAKO
        prilogElem.addTextNode("");

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
    }
}
