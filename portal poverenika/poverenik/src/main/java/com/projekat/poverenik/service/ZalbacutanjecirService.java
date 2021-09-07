package com.projekat.poverenik.service;

import com.projekat.poverenik.dto.QueryZalbacutanjeDTO;
import com.projekat.poverenik.dto.ZalbacutanjeDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiReaderExample;
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
import org.xmldb.api.base.XMLDBException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ZalbacutanjecirService {
    @Autowired
    private ZalbacutanjecirRepository zalbacutanjecirRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZalbacutanjecirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZalbacutanjeFromText(String text) throws Exception {
        System.out.println(text);
        Zalbacutanje zalba = jaxbParser.unmarshall(Zalbacutanje.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        zalba.getDatum().setValue(now);
        long sada=(new Date()).getTime();
        zalba.getBrojPredmeta().setValue(Long.toString(sada));
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        zalba.getPodnosilacZalbe().setEmail(user.getEmail());
        String docId = zalba.getBrojPredmeta().getValue();

        text = jaxbParser.marshallString(Zalbacutanje.class,zalba);

        zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, docId);
        metadataExtractor.extractMetadata(text, new FileOutputStream(new File("src/main/resources/rdf/zalbac"+docId)));
        FusekiWriterExample.saveRDF("zalbac" + docId, "/zalbacutanje");
    }

    public void addZalbacutanjeFromFile(String path) throws Exception {
        Zalbacutanje zalba = jaxbParser.unmarshallFile(Zalbacutanje.class, path);
        String docId = zalba.getBrojPredmeta().getValue();
        zalbacutanjecirRepository.saveZalbacutanjecirFromFile(path, docId);
        String text = jaxbParser.marshallString(Zalbacutanje.class, zalba);
        metadataExtractor.extractMetadata(text, new FileOutputStream(new File("src/main/resources/rdf/zalbac"+docId)));
        FusekiWriterExample.saveRDF(docId, "/zalbacutanje");
    }

    public Document getZalbacutanjeDocument(String docId) throws Exception {
        Document doc = zalbacutanjecirRepository.findZalbacutanjecirById(docId);
        return doc;
    }


    public List<ZalbacutanjeDTO> getUsersZalbecutanje() throws Exception {
        ArrayList<Zalbacutanje> zcs= zalbacutanjecirRepository.findAll();
        List<ZalbacutanjeDTO> ids =new ArrayList<ZalbacutanjeDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zalbacutanje z : zcs) {
            if (z.getPodnosilacZalbe().getEmail() != null && z.getPodnosilacZalbe().getEmail().equalsIgnoreCase(user.getEmail())) {
                ids.add(new ZalbacutanjeDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
            }
        }
        return ids;
    }

    public List<ZalbacutanjeDTO> getAllZalbecutanje() throws Exception {
        ArrayList<Zalbacutanje> zcs= zalbacutanjecirRepository.findAll();
        List<ZalbacutanjeDTO> ids =new ArrayList<ZalbacutanjeDTO>();
        for(Zalbacutanje z : zcs) {
            ids.add(new ZalbacutanjeDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        return ids;
    }

    public List<ZalbacutanjeDTO> getSearchZalbecutanje(String content) throws Exception {
        ArrayList<Zalbacutanje> zcs= zalbacutanjecirRepository.findByContent(content);
        List<ZalbacutanjeDTO> ids =new ArrayList<ZalbacutanjeDTO>();
        for(Zalbacutanje z : zcs) {
            ids.add(new ZalbacutanjeDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        return ids;
    }

    public List<ZalbacutanjeDTO> getSearchMetadataZalbecutanje(QueryZalbacutanjeDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mesto", dto.getMesto());
        params.put("broj_predmeta", dto.getBrojPredmeta());
        params.put("datum", dto.getDatum());
        params.put("ime", dto.getImePodnosioca());
        params.put("prezime", dto.getPrezimePodnosioca());
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params,"/zalbacutanje");
        List<ZalbacutanjeDTO> zcs=new ArrayList<ZalbacutanjeDTO>();
        for(String id :ids){
            Zalbacutanje z = zalbacutanjecirRepository.findRealZalbacutanjeById(id.split("\\^")[0]);
            zcs.add(new ZalbacutanjeDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        System.out.println(ids + "   " + zcs.size());
        return zcs;
    }

    public void downloadJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mesto", "");
        params.put("broj_predmeta", id);
        params.put("datum", "");
        params.put("ime", "");
        params.put("prezime", "");
        FusekiReaderExample.executeQueryforJSON(params,"/zalbacutanje",id);
    }

    public String downloadHTML(String id) throws Exception {
        Document d=zalbacutanjecirRepository.findZalbacutanjecirById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/zalbacutanje.xsl",d,"src/main/resources/html/Zalbacutanje"+id);
    }

    public void downloadPDF(String id) throws Exception {
        String str=zalbacutanjecirRepository.findZalbacutanjeByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/zalbacutanje_fo.xsl","src/main/resources/pdf/Zalbacutanje"+id);

    }


}
