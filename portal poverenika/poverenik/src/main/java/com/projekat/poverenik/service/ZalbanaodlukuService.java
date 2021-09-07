package com.projekat.poverenik.service;

import com.projekat.poverenik.dto.QueryZalbanaodlukuDTO;
import com.projekat.poverenik.dto.ZalbanaodlukuDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.jenafuseki.FusekiReaderExample;
import com.projekat.poverenik.jenafuseki.FusekiWriterExample;
import com.projekat.poverenik.jenafuseki.MetadataExtractor;
import com.projekat.poverenik.model.korisnici.Korisnik;
import com.projekat.poverenik.model.zalbanaodlukucir.Zalbaodluka;
import com.projekat.poverenik.repository.ZalbanaodlukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ZalbanaodlukuService {
    @Autowired
    private ZalbanaodlukuRepository zalbanaodlukuRepository;

    @Autowired
    private XSLTransformer xslTransformer;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZalbanaodlukuService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZalbanaodlukuFromText(String text) throws Exception {
        System.out.println(text);
        Zalbaodluka zalba = jaxbParser.unmarshall(Zalbaodluka.class, text);

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

        text = jaxbParser.marshallString(Zalbaodluka.class,zalba);

        zalbanaodlukuRepository.saveZalbanaodlukucirFromText(text, docId);
        metadataExtractor.extractMetadata(text, new FileOutputStream(new File("src/main/resources/rdf/zalbao"+docId)));
        FusekiWriterExample.saveRDF("zalbao" + docId, "/zalbanaodluku");
    }

    public void addZalbanaodlukuFromFile(String path) throws Exception {
        Zalbaodluka zalba = jaxbParser.unmarshallFile(Zalbaodluka.class, path);
        String docId = zalba.getBrojPredmeta().getValue();
        zalbanaodlukuRepository.saveZalbanaodlukucirFromFile(path, docId);
        String text = jaxbParser.marshallString(Zalbaodluka.class, zalba);
        metadataExtractor.extractMetadata(text, new FileOutputStream(new File("src/main/resources/rdf/zalbao"+docId)));
        FusekiWriterExample.saveRDF(docId, "/zalbanaodluku");
    }

    public Document getZalbanaodlukuDocument(String docId) throws Exception {
        Document doc = zalbanaodlukuRepository.findZalbanaodlukucirById(docId);
        return doc;
    }

    public List<ZalbanaodlukuDTO> getUsersZalbenaodluku() throws Exception {
        ArrayList<Zalbaodluka> zos= zalbanaodlukuRepository.findAll();
        List<ZalbanaodlukuDTO> ids =new ArrayList<ZalbanaodlukuDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zalbaodluka z : zos) {
            if (z.getPodnosilacZalbe().getEmail() != null && z.getPodnosilacZalbe().getEmail().equalsIgnoreCase(user.getEmail())) {
                ids.add(new ZalbanaodlukuDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
            }
        }
        return ids;
    }

    public List<ZalbanaodlukuDTO> getAllZalbenaodluku() throws Exception {
        ArrayList<Zalbaodluka> zos= zalbanaodlukuRepository.findAll();
        List<ZalbanaodlukuDTO> ids =new ArrayList<ZalbanaodlukuDTO>();
        for(Zalbaodluka z : zos) {
            ids.add(new ZalbanaodlukuDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        return ids;
    }

    public List<ZalbanaodlukuDTO> getSearchZalbenaodluku(String content) throws Exception {
        ArrayList<Zalbaodluka> zos= zalbanaodlukuRepository.findByContent(content);
        List<ZalbanaodlukuDTO> ids =new ArrayList<ZalbanaodlukuDTO>();
        for(Zalbaodluka z : zos) {
            ids.add(new ZalbanaodlukuDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        return ids;
    }

    public List<ZalbanaodlukuDTO> getSearchMetadataZalbenaodluku(QueryZalbanaodlukuDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mesto", dto.getMesto());
        params.put("broj_predmeta", dto.getBrojPredmeta());
        params.put("datum", dto.getDatum());
        params.put("ime", dto.getImePodnosioca());
        params.put("prezime", dto.getPrezimePodnosioca());
        ArrayList<String> ids= FusekiReaderExample.executeQuery(params,"/zalbanaodluku");
        List<ZalbanaodlukuDTO> zos=new ArrayList<ZalbanaodlukuDTO>();
        for(String id :ids){
            Zalbaodluka z = zalbanaodlukuRepository.findRealZalbaodlukaById(id.split("\\^")[0]);
            zos.add(new ZalbanaodlukuDTO(z.getBrojPredmeta().getValue(),z.getMesto().getValue(),z.getDatum().getValue().toString(),z.getStanje()));
        }
        System.out.println(ids + "   " + zos.size());
        return zos;
    }

    public void downloadJSON(String id) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mesto", "");
        params.put("broj_predmeta", id);
        params.put("datum", "");
        params.put("ime", "");
        params.put("prezime", "");
        FusekiReaderExample.executeQueryforJSON(params,"/zalbanaodluku",id);
    }

    public String downloadHTML(String id) throws Exception {
        Document d=zalbanaodlukuRepository.findZalbanaodlukucirById(id);
        return xslTransformer.convertXMLtoHTML("src/main/resources/xsl/zalbanaodluku.xsl",d,"src/main/resources/html/Zalbanaodluku"+id);
    }

    public void downloadPDF(String id) throws Exception {
        String str=zalbanaodlukuRepository.findZalbanaodlukuByIdAndReturnString(id);
        xslTransformer.generatePDf(str,"src/main/resources/xsl/zalbanaodluku_fo.xsl","src/main/resources/pdf/Zalbanaodluku"+id);

    }
}
