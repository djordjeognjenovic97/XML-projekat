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
import java.util.*;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

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
        long sada=(new Date()).getTime();
        resenje.getBrojResenja().setValue(Long.toString(sada));
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
}
