package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.model.resenje.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;

@Repository
public class ResenjaRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/resenja";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat/resenja";

    public void saveResenjeFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public void saveResenjeFromFile(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }

    public Document findResenjeById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public ArrayList<Resenje> findByContent(String content) throws Exception {
        ArrayList<Resenje> lista = new ArrayList<Resenje>();
        ResourceSet resourceSet=existManager.retrieve(collectionId,"//*[contains(., '" + content + "')]",TARGET_NAMESPACE);
        ResourceIterator it = resourceSet.getIterator();
        while (it.hasMoreResources()) {
            try {
                XMLResource xmlResource = (XMLResource) it.nextResource();
                JaxbParser jaxbParser = new JaxbParser();
                Resenje Resenje = (Resenje) jaxbParser.unmarshallXMLResource(Resenje.class, xmlResource);
                lista.add(Resenje);
            }catch (Exception e){
                continue;
            }
        }
        return lista;
    }

    public Resenje findRealResenjeById(String s) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, s);
        JaxbParser jaxbParser = new JaxbParser();
        Resenje resenje = (Resenje) jaxbParser.unmarshallXMLResource(Resenje.class,xmlResource);
        return resenje;
    }

    public ArrayList<Resenje> findAll() throws Exception {
        Collection kolekcijazc = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Resenje> rs = new ArrayList<Resenje>();
        String[] ids = kolekcijazc.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                rs.add(jaxbParser.unmarshallXMLResource(Resenje.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return rs;
    }

    public String findResenjeByIdAndReturnString(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        String tekst = (String) xmlResource.getContent();
        return tekst;
    }
}
