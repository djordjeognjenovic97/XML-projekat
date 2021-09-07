package com.projekat.poverenik.service;

import com.projekat.poverenik.dto.IzjasnjenjeDTO;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.model.zalbacutanjecir.Zalbacutanje;
import com.projekat.poverenik.model.zalbanaodlukucir.Zalbaodluka;
import com.projekat.poverenik.repository.IzjasnjenjeRepository;
import com.projekat.poverenik.repository.ZalbacutanjecirRepository;
import com.projekat.poverenik.repository.ZalbanaodlukuRepository;
import com.projekat.poverenik.soap.izjasnjenje.Izjasnjenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.soap.*;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class IzjasnjenjeService {

    @Autowired
    private ZalbacutanjecirRepository zalbacutanjecirRepository;

    @Autowired
    private ZalbanaodlukuRepository zalbanaodlukuRepository;

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

    public void traziIzjasnjenje(String tip,String id) throws Exception {
        if(tip.equalsIgnoreCase("zc")){
            Zalbacutanje zalbacutanje=zalbacutanjecirRepository.findRealZalbaCutanjeById(id);
            zalbacutanje.setStanje("izjasnjavanje");
            String text = jaxbParser.marshallString(Zalbacutanje.class,zalbacutanje);
            zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, id);
        }else if(tip.equalsIgnoreCase("zo")){
            Zalbaodluka zalbaodluka= zalbanaodlukuRepository.findRealZalbaOdlukaById(id);
            zalbaodluka.setStanje("izjasnjavanje");
            String text = jaxbParser.marshallString(Zalbaodluka.class,zalbaodluka);
            zalbanaodlukuRepository.saveZalbanaodlukucirFromText(text, id);
        }
        posaljiUpitzaIzjasnjenjem(id,"");
    }

    private void posaljiUpitzaIzjasnjenjem(String id,String sadrzaj) throws SOAPException {
        String soapEndpointUrl = "http://localhost:8080/ws/izjasnjenje";

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
    }

    public void sacuvajPopunjenoIzjasnjenje(Izjasnjenje izjasnjenje) throws Exception {
        sacuvajIzjasnjenje(izjasnjenje);
        ArrayList<Zalbacutanje> zcs=zalbacutanjecirRepository.findAll();
        String stanje="izjasnjeno";
        if(izjasnjenje.getSadrzaj().equalsIgnoreCase("obustavljeno")){
            stanje="obustavljeno";
        }
        for(Zalbacutanje z:zcs){
            if(z.getBrojPredmeta().getValue().equalsIgnoreCase(izjasnjenje.getId())){
                z.setStanje(stanje);
                String text = jaxbParser.marshallString(Zalbacutanje.class,z);
                zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, izjasnjenje.getId());
                break;
            }
        }
        ArrayList<Zalbaodluka> zos=zalbanaodlukuRepository.findAll();
        for(Zalbaodluka zo:zos){
            if(zo.getBrojPredmeta().getValue().equalsIgnoreCase(izjasnjenje.getId())){
                zo.setStanje(stanje);
                String text = jaxbParser.marshallString(Zalbaodluka.class,zo);
                zalbanaodlukuRepository.saveZalbanaodlukucirFromText(text, izjasnjenje.getId());
                break;
            }
        }
    }

    public IzjasnjenjeDTO pogledajIzjasnjenje(String id) throws Exception {
        Izjasnjenje izjasnjenje = izjasnjenjeRepository.findRealIzjasnjenjeById(id);
        return new IzjasnjenjeDTO(izjasnjenje.getId(), izjasnjenje.getSadrzaj());
    }

    public void obustaviZalbu(String id) throws Exception {
        ArrayList<Zalbacutanje> zcs=zalbacutanjecirRepository.findAll();
        for(Zalbacutanje z:zcs){
            if(z.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                z.setStanje("obustavljeno");
                String text = jaxbParser.marshallString(Zalbacutanje.class,z);
                zalbacutanjecirRepository.saveZalbacutanjecirFromText(text, id);
                break;
            }
        }
        ArrayList<Zalbaodluka> zos=zalbanaodlukuRepository.findAll();
        for(Zalbaodluka zo:zos){
            if(zo.getBrojPredmeta().getValue().equalsIgnoreCase(id)){
                zo.setStanje("obustavljeno");
                String text = jaxbParser.marshallString(Zalbaodluka.class,zo);
                zalbanaodlukuRepository.saveZalbanaodlukucirFromText(text, id);
                break;
            }
        }
        posaljiUpitzaIzjasnjenjem(id,"obustavljeno");
    }
}
