package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.repository.ObavestenjecirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ObavestenjecirService {
    @Autowired
    private ObavestenjecirRepository obavestenjecirRepository;

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
        String docId = obavestenje.getNaziv();
        obavestenjecirRepository.saveObavestenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/obavestenja");
    }

    public void addObavestenjeFromFile(String path) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshallFile(Obavestenje.class, path);
        String docId = obavestenje.getNaziv();
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


}
