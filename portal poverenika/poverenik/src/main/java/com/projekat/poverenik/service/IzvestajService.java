package com.projekat.poverenik.service;

import com.projekat.poverenik.dto.IzvestajDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.obavestenjecir.Obavestenje;
import com.projekat.poverenik.repository.IzvestajRepository;
import com.projekat.poverenik.soap.izvestaj.Izvestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String docId = obavestenje.getBrojPredmeta().toString();
        //obavestenjecirRepository.saveObavestenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/izvestaji");
    }

    public Izvestaj sacuvajIzvestaj(Izvestaj izvestaj) throws Exception {


        String text = jaxbParser.marshallString(Izvestaj.class,izvestaj);

        String docId= izvestaj.getId();
        izvestajRepository.saveIzvestajFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/izvestaji");
        return izvestaj;
    }
    public List<IzvestajDTO> getAllIzvestaji() throws Exception {
        ArrayList<Izvestaj> izvestajs= izvestajRepository.findAll();
        List<IzvestajDTO> ids=new ArrayList<IzvestajDTO>();
        for(Izvestaj z : izvestajs){
            ids.add(new IzvestajDTO(z.getId(),z.getDatum().getValue().toString()));
        }
        return ids;
    }

    public List<IzvestajDTO> getSearchIzvestaji(String content) throws Exception {
        ArrayList<Izvestaj> izvestajs= izvestajRepository.findByContent(content);
        List<IzvestajDTO> ids=new ArrayList<IzvestajDTO>();
        for(Izvestaj z : izvestajs){
            ids.add(new IzvestajDTO(z.getId(),z.getDatum().getValue().toString()));
        }
        return ids;
    }
}
