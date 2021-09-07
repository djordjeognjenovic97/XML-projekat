package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.soap.izvestaj.Izvestaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;

@Repository
public class IzvestajRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/izvestaji";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj";


    public void saveIzvestajFromText(String text, String docId) throws Exception {
        existManager.storeFromText(collectionId, docId , text);
    }

    public ArrayList<Izvestaj> findAll() throws Exception {
        Collection kolekcijaIzvestaja = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
        String[] ids = kolekcijaIzvestaja.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                izvestaji.add(jaxbParser.unmarshallXMLResource(Izvestaj.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return izvestaji;
    }

    public ArrayList<Izvestaj> findByContent(String content) throws Exception {
        ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
        ResourceSet resourceSet=existManager.retrieve(collectionId,"//*[contains(., '" + content + "')]",TARGET_NAMESPACE);
        ResourceIterator it = resourceSet.getIterator();
        while (it.hasMoreResources()) {
            try {
                XMLResource xmlResource = (XMLResource) it.nextResource();
                JaxbParser jaxbParser = new JaxbParser();
                Izvestaj izvestaj = (Izvestaj) jaxbParser.unmarshallXMLResource(Izvestaj.class, xmlResource);
                lista.add(izvestaj);
            }catch (Exception e){
                continue;
            }
        }
        return lista;
    }

    public String findIzvestajByIdAndReturnString(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        String tekst = (String) xmlResource.getContent();
        return tekst;
    }

    public Document findIzvestajById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public Izvestaj findRealIzvestajById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        JaxbParser jaxbParser = new JaxbParser();
        Izvestaj i = (Izvestaj) jaxbParser.unmarshallXMLResource(Izvestaj.class,xmlResource);
        return i;
    }
}

