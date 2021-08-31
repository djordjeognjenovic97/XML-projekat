package com.projekat.poverenik.service;

import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.izvestaji.Izvestaj;
import com.projekat.poverenik.model.obavestenjecir.Obavestenje;
import com.projekat.poverenik.repository.IzvestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public class IzvestajService {
    @Autowired
    private IzvestajRepository izvestajRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    private final String obavestenjeXSLPath = "src/main/resources/xsl/izvestaj.xsl";
    private static String pdfXSLPath = "src/main/resources/xsl/izvestajToPDF.xsl";

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public IzvestajService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addObavestenjeFromText(String text) throws Exception {
        Obavestenje obavestenje = jaxbParser.unmarshall(Obavestenje.class, text);
        String docId = obavestenje.getNaziv();
        //obavestenjecirRepository.saveObavestenjeFromText(text, docId);
//        metadataExtractor.extractMetadata(text);
//        FusekiWriterExample.saveRDF();
    }

    public Izvestaj generateIzvestaj() {
        return new Izvestaj();
    }
}
