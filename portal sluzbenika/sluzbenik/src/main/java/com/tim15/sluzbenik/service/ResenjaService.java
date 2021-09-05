package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dom.DOMParser;
import com.tim15.sluzbenik.jenafuseki.FusekiReaderExample;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.repository.ResenjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    @Autowired
    private XSLTransformer xslTransformer;

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
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/resenja");
    }

    public void addResenjeFromFile(String path) throws Exception {
        Document document = domParser.buildDocumentFromFile(path);
        NodeList ndBroj = document.getElementsByTagName("broj_zalbe");
        String docId = ndBroj.item(0).getTextContent();
        resenjaRepository.saveResenjeFromFile(path, docId);
        String text = domParser.getDocumentAsString(document);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/resenja");
    }

    public Document getResenjeDocument(String docId) throws Exception {
        Document doc = resenjaRepository.findResenjeById(docId);
        return doc;
    }
    public void skiniJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        params.put("mesto", "");
        params.put("datum", "");
        params.put("nazivOrgana", "");
        FusekiReaderExample.executeQueryforJSON(params,"/resenja",id);
    }

    public String skiniHTML(String id) throws Exception {
        Document d=resenjaRepository.findResenjeById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/resenje.xsl",d,"src/main/resources/html/Resenje"+id);
    }

    public void skiniPDF(String id) throws Exception {
        String str=resenjaRepository.findResenjeByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/resenje_fo.xsl","src/main/resources/pdf/Resenje"+id);

    }
}
