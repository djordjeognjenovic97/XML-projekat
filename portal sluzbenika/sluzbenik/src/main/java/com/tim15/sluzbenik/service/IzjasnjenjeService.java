package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.repository.IzjasnjenjeRepository;
import com.tim15.sluzbenik.soap.izjasnjenje.Izjasnjenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IzjasnjenjeService {

    @Autowired
    private IzjasnjenjeRepository izjasnjenjeRepository;

    private JaxbParser jaxbParser;

    public IzjasnjenjeService() throws IOException, SAXException {
        jaxbParser = new JaxbParser();
    }

    public void sacuvajIzjasnjenje(Izjasnjenje izjasnjenje) throws Exception {
        String text = jaxbParser.marshallString(Izjasnjenje.class,izjasnjenje);
        String docId= izjasnjenje.getId();
        izjasnjenjeRepository.saveIzjasnjenjeFromText(text, docId);
    }

    public List<String> getIzjasnjenja() throws Exception {
        ArrayList<Izjasnjenje> izjasnjenja= izjasnjenjeRepository.findAll();
        List<String> ids=new ArrayList<String>();
        for(Izjasnjenje i :izjasnjenja){
            if(!i.getId().isEmpty()){
                ids.add(i.getId());
            }
        }
        return ids;
    }

    public void izjasniSe(String sadrzaj, String id) throws Exception {
        String soapEndpointUrl = "http://localhost:8082/ws/izjasnjenje";

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("izj", "http://izjasnjenje");

        SOAPBody soapBody = envelope.getBody();
        envelope.addNamespaceDeclaration("izj", "http://izjasnjenje");
        SOAPElement izjElem = soapBody.addChildElement("izjasnjenje", "izj");
        izjElem.setAttribute("id", id);
        izjElem.setAttribute("emailPoverenik", "");
        izjElem.setAttribute("emailSluzbenik", "");

        SOAPElement sadrzajElem = izjElem.addChildElement("sadrzaj", "izj");
        sadrzajElem.addTextNode(sadrzaj);

        soapMessage.saveChanges();
        SOAPMessage soapResponse = soapConnection.call(soapMessage, soapEndpointUrl);

        Izjasnjenje izjasnjenje = new Izjasnjenje();
        izjasnjenje.setId("");
        izjasnjenje.setSadrzaj(sadrzaj);
        String text = jaxbParser.marshallString(Izjasnjenje.class,izjasnjenje);
        izjasnjenjeRepository.saveIzjasnjenjeFromText(text, id);

    }
}
