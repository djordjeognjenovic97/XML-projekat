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
import javax.xml.soap.*;
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
    private void posaljiIzvestaj(Izvestaj izvestaj) throws SOAPException {
        String soapEndpointUrl = "http://localhost:8082/ws/izvestaj";

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("izv", "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj");

        SOAPBody soapBody = envelope.getBody();
        envelope.addNamespaceDeclaration("izv", "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj");
        SOAPElement izvElem = soapBody.addChildElement("izvestaj", "izv");
        izvElem.setAttribute("id", izvestaj.getId());

        SOAPElement zahteviElem = izvElem.addChildElement("zahtevi", "izv");

        SOAPElement podzah=zahteviElem.addChildElement("ukupanBrPodnetihZahteva","izv");
        podzah.addTextNode(Integer.toString(izvestaj.getZahtevi().getUkupanBrPodnetihZahteva()));
        SOAPElement usvzah=zahteviElem.addChildElement("brUsvojenihZahteva","izv");
        usvzah.addTextNode(Integer.toString(izvestaj.getZahtevi().getBrUsvojenihZahteva()));
        SOAPElement odbzah=zahteviElem.addChildElement("brOdbijenihZahteva","izv");
        odbzah.addTextNode(Integer.toString(izvestaj.getZahtevi().getBrOdbijenihZahteva()));
        SOAPElement odczah=zahteviElem.addChildElement("brOdbacenihZahteva","izv");
        odczah.addTextNode(Integer.toString(izvestaj.getZahtevi().getBrOdbacenihZahteva()));

        SOAPElement zalbeElem = izvElem.addChildElement("zalbe", "izv");

        SOAPElement izjzal=zalbeElem.addChildElement("ukupanBrIzjavljenihZalbi","izv");
        izjzal.addTextNode(Integer.toString(izvestaj.getZalbe().getUkupanBrIzjavljenihZalbi()));
        SOAPElement npozal=zalbeElem.addChildElement("brZalbiNijePostupio","izv");
        npozal.addTextNode(Integer.toString(izvestaj.getZalbe().getBrZalbiNijePostupio()));
        SOAPElement npczal=zalbeElem.addChildElement("brZalbiNijePostupioUCelosti","izv");
        npczal.addTextNode(Integer.toString(izvestaj.getZalbe().getBrZalbiNijePostupioUCelosti()));
        SOAPElement nprzal=zalbeElem.addChildElement("brZalbiNijePostupioURoku","izv");
        nprzal.addTextNode(Integer.toString(izvestaj.getZalbe().getBrZalbiNijePostupioURoku()));
        SOAPElement bznzal=zalbeElem.addChildElement("brZalbiNaOdluku","izv");
        bznzal.addTextNode(Integer.toString(izvestaj.getZalbe().getBrZalbiNaOdluku()));

        SOAPElement datumElem = izvElem.addChildElement("datum", "izv");
        datumElem.addTextNode(izvestaj.getDatum().getValue().toString());
        datumElem.setAttribute("property", "pred:datum");

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
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