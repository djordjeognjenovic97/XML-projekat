package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dom.DOMParser;
import com.tim15.sluzbenik.dto.QueryResenjeDTO;
import com.tim15.sluzbenik.dto.ResenjeDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiReaderExample;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.repository.ResenjaRepository;
import com.tim15.sluzbenik.soap.resenje.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResenjaService {
    @Autowired
    private ResenjaRepository resenjaRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ResenjaService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public Document getResenjeDocument(String docId) throws Exception {
        Document doc = resenjaRepository.findResenjeById(docId);
        return doc;
    }
    public void skiniJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("broj_resenja", id);
        params.put("datum", "");
        params.put("ime", "");
        params.put("prezime", "");
        params.put("gradjanin", "");
        params.put("naziv_optuzenog", "");
        FusekiReaderExample.executeQueryforJSON(params,"/resenje",id);
    }

    public String skiniHTML(String id) throws Exception {
        Document d=resenjaRepository.findResenjeById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/resenje.xsl",d,"src/main/resources/html/Resenje"+id);
    }

    public void skiniPDF(String id) throws Exception {
        String str=resenjaRepository.findResenjeByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/resenje_fo.xsl","src/main/resources/pdf/Resenje"+id);

    }

    public List<ResenjeDTO> getAllResenje() throws Exception {
        ArrayList<Resenje> rs= resenjaRepository.findAll();
        List<ResenjeDTO> ids =new ArrayList<ResenjeDTO>();
        for(Resenje r : rs) {
            ids.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        return ids;
    }

    public List<ResenjeDTO> getSearchResenje(String content) throws Exception {
        ArrayList<Resenje> rs= resenjaRepository.findByContent(content);
        List<ResenjeDTO> ids =new ArrayList<ResenjeDTO>();
        for(Resenje r : rs) {
            ids.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        return ids;
    }

    public List<ResenjeDTO> getSearchMetadataResenje(QueryResenjeDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("broj_resenja", dto.getBrojPredmeta());
        params.put("datum", dto.getDatum());
        params.put("ime", dto.getImePoverenika());
        params.put("prezime", dto.getPrezimePoverenika());
        params.put("gradjanin", dto.getGradjanin());
        params.put("naziv_optuzenog", dto.getNazivOptuzenog());
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params, "/resenje");
        List<ResenjeDTO> rs=new ArrayList<ResenjeDTO>();
        for(String id :ids){
            Resenje r = resenjaRepository.findRealResenjeById(id.split("\\^")[0]);
            rs.add(new ResenjeDTO(r.getBrojResenja().getValue(),r.getDatum().getValue().toString(), r.getEmailGradjanina(), r.getId()));
        }
        System.out.println(ids + "   " + rs.size());
        return rs;
    }

    public void sacuvajResenje(Resenje resenje) throws Exception {
        String text = jaxbParser.marshallString(Resenje.class,resenje);
        String docId= resenje.getId();
        resenjaRepository.saveResenjeFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/resenje"+docId)));
        FusekiWriterExample.saveRDF("resenje"+docId,"/resenja");
    }
}
