package com.projekat.poverenik.service;

import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.korisnici.Korisnik;
import com.projekat.poverenik.model.zalbacutanjecir.Zalbacutanje;
import com.projekat.poverenik.repository.ZalbacutanjecirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class ZalbacutanjecirService {
    @Autowired
    private ZalbacutanjecirRepository zalbacutanjecirRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZalbacutanjecirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZalbacutanjeFromText(String text) throws Exception {
        Zalbacutanje zalba = jaxbParser.unmarshall(Zalbacutanje.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        zalba.setDatum(now);
        long sada=(new Date()).getTime();
        zalba.setId(Long.toString(sada));
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        zalba.getPodnosilacZalbe().setEmail(user.getEmail());
        String docId = zalba.getId();

        text = jaxbParser.marshallString(Zalbacutanje.class,zalba);

        zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, docId);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public void addZalbacutanjeFromFile(String path) throws Exception {
        Zalbacutanje zalba = jaxbParser.unmarshallFile(Zalbacutanje.class, path);
        String docId = zalba.getNaslov();
        zalbacutanjecirRepository.saveZalbacutanjecirFromFile(path, docId);
        String text = jaxbParser.marshallString(Zalbacutanje.class, zalba);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public Document getZalbacutanjeDocument(String docId) throws Exception {
        Document doc = zalbacutanjecirRepository.findZalbacutanjecirById(docId);
        return doc;
    }
}
