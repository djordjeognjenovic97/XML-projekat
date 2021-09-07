package com.projekat.poverenik.service;

import com.projekat.poverenik.dto.IzvestajDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiReaderExample;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.obavestenjecir.Obavestenje;
import com.projekat.poverenik.repository.IzvestajRepository;
import com.projekat.poverenik.soap.izvestaj.Izvestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String docId= izvestaj.getId().getValue();
        izvestajRepository.saveIzvestajFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/izvestaji");
        return izvestaj;
    }
    public List<IzvestajDTO> getAllIzvestaji() throws Exception {
        ArrayList<Izvestaj> izvestajs= izvestajRepository.findAll();
        List<IzvestajDTO> ids=new ArrayList<IzvestajDTO>();
        for(Izvestaj z : izvestajs){
            ids.add(new IzvestajDTO(z.getId().getValue(),z.getDatum().getValue().toString()));
        }
        return ids;
    }

    public List<IzvestajDTO> getSearchIzvestaji(String content) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id","");
        params.put("datum", content);
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params,"/izvestaji");
        List<IzvestajDTO> izvestaji=new ArrayList<IzvestajDTO>();
        for(String id :ids){
            Izvestaj z=izvestajRepository.findRealIzvestajById(id.split("\\^")[0]);
            izvestaji.add(new IzvestajDTO(z.getId().getValue(),z.getDatum().getValue().toString()));
        }
        System.out.println(ids+"   "+izvestaji.size());
        return izvestaji;
    }

    public void skiniJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("datum", "");
        params.put("id", id);
        FusekiReaderExample.executeQueryforJSON(params,"/izvestaji",id);
    }

    public String skiniHTML(String id) throws Exception {
        Document d=izvestajRepository.findIzvestajById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/izvestaj.xsl",d,"src/main/resources/html/"+id);
    }

    public void skiniPDF(String id) throws Exception {
        String str=izvestajRepository.findIzvestajByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/izvestaj_fo.xsl","src/main/resources/pdf/"+id);

    }


}
