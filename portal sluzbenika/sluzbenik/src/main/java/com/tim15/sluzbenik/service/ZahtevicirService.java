package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dto.QueryZahtevDTO;
import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.jenafuseki.FusekiReaderExample;
import com.tim15.sluzbenik.jenafuseki.FusekiWriterExample;
import com.tim15.sluzbenik.jenafuseki.MetadataExtractor;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.repository.ZahtevicirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.soap.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ZahtevicirService {
    @Autowired
    private ZahtevicirRepository zahtevicirRepository;

    private JaxbParser jaxbParser;
    private MetadataExtractor metadataExtractor;

    public ZahtevicirService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
        metadataExtractor = new MetadataExtractor();
    }

    public void addZahtevFromText(String text) throws Exception {
        Zahtev zahtev = jaxbParser.unmarshall(Zahtev.class, text);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        Zahtev.DatumPodnosenjaZahteva datum = zahtev.getDatumPodnosenjaZahteva();
        datum.setValue(now);
        zahtev.setDatumPodnosenjaZahteva(datum);
        long sada=(new Date()).getTime();
        Zahtev.Id idz= zahtev.getId();
        idz.setValue(String.valueOf(sada));
        zahtev.setId(idz);
        zahtev.setStanje("podnet");
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        zahtev.getTrazilacInformacije().setEmail(user.getEmail());
        String docId = zahtev.getId().getValue();

        text = jaxbParser.marshallString(Zahtev.class,zahtev);

        zahtevicirRepository.saveZahtevFromText(text, docId);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/zahtevi");
    }

    public void addZahtevFromFile(String path) throws Exception {
        Zahtev zahtev = jaxbParser.unmarshallFile(Zahtev.class, path);
        String docId = zahtev.getId().getValue();
        zahtevicirRepository.saveZahtevFromFile(path, docId);
        String text = jaxbParser.marshallString(Zahtev.class, zahtev);
        metadataExtractor.extractMetadata(text,new FileOutputStream(new File("src/main/resources/rdf/"+docId)));
        FusekiWriterExample.saveRDF(docId,"/zahtevi");
    }

    public Document getZahtevDocument(String docId) throws Exception {
        Document doc = zahtevicirRepository.findZahtevById(docId);
        return doc;
    }

    public List<ZahtevDTO> getUsersZahtevi() throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        List<ZahtevDTO> ids =new ArrayList<ZahtevDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zahtev z : zahtevs) {
            if (z.getTrazilacInformacije().getEmail() != null && z.getTrazilacInformacije().getEmail().equalsIgnoreCase(user.getEmail())) {
                ids.add(new ZahtevDTO(z.getId().getValue(),z.getOrgan().getNaziv().getValue(),z.getDatumPodnosenjaZahteva().getValue().toString(),z.getMestoPodnosenjaZahteva().getValue(), z.getStanje()));
            }
        }
        return ids;
    }

    public void odbijZahtev(String id) throws Exception {
        Zahtev zahtev=zahtevicirRepository.findRealZahtevById(id);
        zahtev.setStanje("odbijen");

        String text = jaxbParser.marshallString(Zahtev.class,zahtev);
        zahtevicirRepository.saveZahtevFromText(text, id);
        //metadataExtractor.extractMetadata(text);
        //FusekiWriterExample.saveRDF();

        odbijZahtevMailom(id,zahtev.getTrazilacInformacije().getEmail());
    }

    public List<ZahtevDTO> getAllZahtevi() throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        List<ZahtevDTO> ids=new ArrayList<ZahtevDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zahtev z : zahtevs){
            ids.add(new ZahtevDTO(z.getId().getValue(),z.getOrgan().getNaziv().getValue(),z.getDatumPodnosenjaZahteva().getValue().toString(),z.getMestoPodnosenjaZahteva().getValue(),z.getStanje()));
        }
        return ids;
    }

    private void odbijZahtevMailom(String id,String to) throws SOAPException {


        String soapEndpointUrl = "http://localhost:8088/ws/email";
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("es", "http://email");

        SOAPBody soapBody = envelope.getBody();
        envelope.addNamespaceDeclaration("es", "http://email");
        SOAPElement pismoElem = soapBody.addChildElement("email", "es");
        pismoElem.setAttribute("attachmentType", "");
        SOAPElement primalacElem = pismoElem.addChildElement("to", "es");
        primalacElem.addTextNode(to);
        SOAPElement naslovElem = pismoElem.addChildElement("subject", "es");
        naslovElem.addTextNode("Odbijanje zahteva");
        SOAPElement sadrzajElem = pismoElem.addChildElement("content", "es");
        sadrzajElem.addTextNode("Vas zahtev sa ID brojem:"+id+" je odbijen.");
        SOAPElement prilogElem = pismoElem.addChildElement("attachment", "es");
        prilogElem.addTextNode("");

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);
    }

    public List<ZahtevDTO> getSearchZahtevi(String search) throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findByContent(search);
        List<ZahtevDTO> ids=new ArrayList<ZahtevDTO>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Korisnik user=(Korisnik) auth.getPrincipal();
        for(Zahtev z : zahtevs){
            ids.add(new ZahtevDTO(z.getId().getValue(),z.getOrgan().getNaziv().getValue(),z.getDatumPodnosenjaZahteva().getValue().toString(),z.getMestoPodnosenjaZahteva().getValue(),z.getStanje()));
        }
        return ids;
    }

    public List<ZahtevDTO> getSearchMetadataZahtevi(QueryZahtevDTO dto) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", dto.getIdDokumenta());
        params.put("mesto", dto.getMesto());
        params.put("datum", dto.getDatum());
        params.put("nazivOrgana", dto.getNazivOrgana());
        ArrayList<String> ids=FusekiReaderExample.executeQuery(params,"/zahtevi");
        List<ZahtevDTO> zahtevi=new ArrayList<ZahtevDTO>();
        for(String id :ids){
            Zahtev z=zahtevicirRepository.findRealZahtevById(id.split("\\^")[0]);
            zahtevi.add(new ZahtevDTO(z.getId().getValue(),z.getOrgan().getNaziv().getValue(),z.getDatumPodnosenjaZahteva().getValue().toString(),z.getMestoPodnosenjaZahteva().getValue(),z.getStanje()));
        }
        System.out.println(ids+"   "+zahtevi.size());
        return zahtevi;
    }

    public void odbaciZahtev() throws Exception {
        ArrayList<Zahtev> zahtevs= zahtevicirRepository.findAll();
        for(Zahtev z : zahtevs){
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.add(Calendar.MINUTE,-5);
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
            if(now.compare(z.getDatumPodnosenjaZahteva().getValue())>0 && z.getStanje().equalsIgnoreCase("podnet")){
                z.setStanje("odbacen");
                System.out.println(z.getId().getValue()+" zahtev je odbacen.");
                String text = jaxbParser.marshallString(Zahtev.class,z);
                zahtevicirRepository.saveZahtevFromText(text, z.getId().getValue());
            }
        }
    }
}
