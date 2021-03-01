package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.zalbanaodluku.Zalba;
import com.tim15.sluzbenik.repository.ZalbanaodlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public class ZalbanaodlukuService {

    @Autowired
    private ZalbanaodlukuRepository zalbanaodlukuRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZalbanaodlukuService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZalbanaodlukuFromText(String text) throws Exception {
        Zalba zalba = jaxbParser.unmarshall(Zalba.class, text);
        String docId = zalba.getNaslov(); //za sada naslov, dok ne modelujem dokument bolje
        zalbanaodlukuRepository.saveZalbaFromText(text, docId);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public void addZalbanaodlukuFromFile(String path) throws Exception {
        Zalba zalba = jaxbParser.unmarshallFile(Zalba.class, path);
        String docId = zalba.getNaslov();
        zalbanaodlukuRepository.saveZalbaFromFile(path, docId);
        String text = jaxbParser.marshallString(Zalba.class, zalba);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public Document getDocument(String docId) throws Exception {
        Document doc = zalbanaodlukuRepository.findZalbaById(docId);
        return doc;
    }

}
