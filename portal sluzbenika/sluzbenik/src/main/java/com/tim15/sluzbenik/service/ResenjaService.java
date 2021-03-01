package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dom.DOMParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.repository.ResenjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    private DOMParser domParser;
    private MetadataExtractor metadataExtractor;

    public ResenjaService() throws IOException, SAXException {
        metadataExtractor = new MetadataExtractor();
        domParser = new DOMParser();
    }

    public void addResenjeFromText(String text) throws Exception {
        Document document = domParser.buildDocumentFromText(text);
        NodeList ndBroj = document.getElementsByTagName("broj_zalbe");
        String docId = ndBroj.item(0).getTextContent();
        resenjaRepository.saveResenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public void addResenjeFromFile(String path) throws Exception {
        Document document = domParser.buildDocumentFromFile(path);
        NodeList ndBroj = document.getElementsByTagName("broj_zalbe");
        String docId = ndBroj.item(0).getTextContent();
        resenjaRepository.saveResenjeFromFile(path, docId);
        String text = domParser.getDocumentAsString(document);
        metadataExtractor.extractMetadata(text);
        FusekiWriterExample.saveRDF();
    }

    public Document getResenjeDocument(String docId) throws Exception {
        Document doc = resenjaRepository.findResenjeById(docId);
        return doc;
    }
}
