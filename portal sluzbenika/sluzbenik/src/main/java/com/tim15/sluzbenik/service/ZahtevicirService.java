package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.repository.ZahtevicirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ZahtevicirService {
    @Autowired
    private ZahtevicirRepository zahtevicirRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZahtevicirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZahtevFromText(String text) throws Exception {
        Zahtev zahtev = jaxbParser.unmarshall(Zahtev.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        zahtev.setDatum(now);
        long sada=(new Date()).getTime();
        zahtev.setId(Long.toString(sada));
        zahtev.setStanje("podnet");
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        zahtev.getTrazilacInformacije().setEmail(user.getEmail());
        String docId = zahtev.getId();

        text = jaxbParser.marshallString(Zahtev.class,zahtev);

        zahtevicirRepository.saveZahtevFromText(text, docId);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public void addZahtevFromFile(String path) throws Exception {
        Zahtev zahtev = jaxbParser.unmarshallFile(Zahtev.class, path);
        String docId = zahtev.getId();
        zahtevicirRepository.saveZahtevFromFile(path, docId);
        String text = jaxbParser.marshallString(Zahtev.class, zahtev);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public Document getZahtevDocument(String docId) throws Exception {
        Document doc = zahtevicirRepository.findZahtevById(docId);
        return doc;
    }

    public ArrayList<String> getUsersZahtevi() throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        ArrayList<String> ids=new ArrayList<>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zahtev z : zahtevs) {
            if (z.getTrazilacInformacije().getEmail() != null && z.getTrazilacInformacije().getEmail().equalsIgnoreCase(user.getEmail())) {
                ids.add(z.getId());
            }
        }
        return ids;
    }

    public void odbijZahtev(String id) throws Exception {
        Zahtev zahtev=zahtevicirRepository.findRealZahtevById(id);
        zahtev.setStanje("odbijen");

        String text = jaxbParser.marshallString(Zahtev.class,zahtev);
        zahtevicirRepository.saveZahtevFromText(text, id);
        //metadataExtractor.extractMetadata(text);
        //FusekiWriterExample.saveRDF();

        odbijZahtevMailom(id,zahtev.getTrazilacInformacije().getEmail());
    }

    public ArrayList<String> getAllZahtevi() throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        ArrayList<String> ids=new ArrayList<>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zahtev z : zahtevs){
            ids.add(z.getId());
        }
        System.out.println(ids);
        return ids;
    }

    private void odbijZahtevMailom(String id,String to) throws SOAPException {


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
        naslovElem.addTextNode("Odbijanje zahteva");
        SOAPElement sadrzajElem = pismoElem.addChildElement("content", "es");
        sadrzajElem.addTextNode("Vas zahtev sa ID brojem:"+id+" je odbijen.");
        SOAPElement prilogElem = pismoElem.addChildElement("attachment", "es");
        prilogElem.addTextNode("");

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
    }
}
