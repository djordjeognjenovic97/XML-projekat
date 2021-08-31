package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dto.IzvestajDTO;
import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.izvestaji.Izvestaj;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.repository.IzvestajRepository;
import com.tim15.sluzbenik.repository.ObavestenjecirRepository;
import com.tim15.sluzbenik.repository.ZahtevicirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class IzvestajService {
    @Autowired
    private IzvestajRepository izvestajRepository;

    @Autowired
    private ZahtevicirRepository zahtevicirRepository;

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

    public Izvestaj generateIzvestaj() throws Exception {

        Izvestaj izvestaj = new Izvestaj();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        Izvestaj.Datum datum = new Izvestaj.Datum();
        datum.setValue(now);
        izvestaj.setDatum(datum);
        long sada=(new Date()).getTime();
        izvestaj.setId(String.valueOf(sada));

        izvestaj=izbrojZahteve(izvestaj);
        izvestaj=izbrojZalbe(izvestaj);

        String docId = izvestaj.getId();

        String text = jaxbParser.marshallString(Izvestaj.class,izvestaj);

        posaljiIzvestaj(izvestaj);

        izvestajRepository.saveIzvestajFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/izvestaji");
        return izvestaj;
    }
    private void posaljiIzvestaj(Izvestaj izvestaj) {
        System.out.println("TREBA POSLATI IZVESTAJ POVERENIKU PREKO SOAPA");
    }

    private Izvestaj izbrojZahteve(Izvestaj izvestaj) throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        int a=0,b=0,c=0,d=0;
        for (Zahtev z:zahtevs){
            a=a+1;
            if(z.getStanje().equals("odbijen")){
                c=c+1;
            }else if(z.getStanje().equals("odbacen")){
                b=b+1;
            }else if(z.getStanje().equals("usvojen")){
                d=d+1;
            }
        }
        Izvestaj.Zahtevi z= new Izvestaj.Zahtevi();
        izvestaj.setZahtevi(z);
        izvestaj.getZahtevi().setUkupanBrPodnetihZahteva(a);
        izvestaj.getZahtevi().setBrOdbacenihZahteva(b);
        izvestaj.getZahtevi().setBrOdbijenihZahteva(c);
        izvestaj.getZahtevi().setBrUsvojenihZahteva(d);
        return izvestaj;
    }
    private Izvestaj izbrojZalbe(Izvestaj izvestaj) throws Exception {
        //preko soapa dobavi sve zalbe
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        int a=0,b=0,c=0,d=0,e=0;
        for (Zahtev z:zahtevs){
            a=a+1;
            if(z.getStanje().equals("odbijen")){
                c=c+1;
            }else if(z.getStanje().equals("odbacen")){
                b=b+1;
            }else if(z.getStanje().equals("usvojen")){
                d=d+1;
            }
        }
        Izvestaj.Zalbe z= new Izvestaj.Zalbe();
        izvestaj.setZalbe(z);
        izvestaj.getZalbe().setUkupanBrIzjavljenihZalbi(a);
        izvestaj.getZalbe().setBrZalbiNaOdluku(b);
        izvestaj.getZalbe().setBrZalbiNijePostupio(c);
        izvestaj.getZalbe().setBrZalbiNijePostupioUCelosti(d);
        izvestaj.getZalbe().setBrZalbiNijePostupioURoku(e);
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
