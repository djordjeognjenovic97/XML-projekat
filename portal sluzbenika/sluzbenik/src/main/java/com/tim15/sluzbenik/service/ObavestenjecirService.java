package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.repository.ObavestenjecirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public class ObavestenjecirService {
    @Autowired
    private ObavestenjecirRepository obavestenjecirRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ObavestenjecirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addObavestenjeFromText(String text) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshall(Obavestenje.class, text);
        String docId = obavestenje.getNaziv();
        obavestenjecirRepository.saveObavestenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public void addObavestenjeFromFile(String path) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshallFile(Obavestenje.class, path);
        String docId = obavestenje.getNaziv();
        obavestenjecirRepository.saveObavestenjeFromFile(path, docId);
        String text = jaxbParser.marshallString(Obavestenje.class, obavestenje);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public Document getObavestenjeDocument(String docId) throws Exception {
        Document doc = obavestenjecirRepository.findObavestenjeById(docId);
        return doc;
    }
}
