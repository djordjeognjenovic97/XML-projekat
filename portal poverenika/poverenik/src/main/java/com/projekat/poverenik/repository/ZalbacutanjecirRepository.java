package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.model.zalbacutanjecir.Zalbacutanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;

@Repository
public class ZalbacutanjecirRepository {

    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/zalbecutanje";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat/zalbacutanjecir";

    public Zalbacutanje findRealZalbacutanjeById(String s) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, s);
        JaxbParser jaxbParser = new JaxbParser();
        Zalbacutanje zalbacutanje = (Zalbacutanje) jaxbParser.unmarshallXMLResource(Zalbacutanje.class,xmlResource);
        return zalbacutanje;
    }

    public ArrayList<Zalbacutanje> findAll() throws Exception {
        Collection kolekcijazc = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Zalbacutanje> zc = new ArrayList<Zalbacutanje>();
        String[] ids = kolekcijazc.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                zc.add(jaxbParser.unmarshallXMLResource(Zalbacutanje.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return zc;
    }

    public void saveZalbacutanjecirFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public void saveZalbacutanjecirFromFile(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }

    public Document findZalbacutanjecirById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public ArrayList<Zalbacutanje> findByContent(String content) throws Exception {
        ArrayList<Zalbacutanje> lista = new ArrayList<Zalbacutanje>();
        ResourceSet resourceSet=existManager.retrieve(collectionId,"//*[contains(., '" + content + "')]",TARGET_NAMESPACE);
        ResourceIterator it = resourceSet.getIterator();
        while (it.hasMoreResources()) {
            try {
                XMLResource xmlResource = (XMLResource) it.nextResource();
                JaxbParser jaxbParser = new JaxbParser();
                Zalbacutanje Zalbacutanje = (Zalbacutanje) jaxbParser.unmarshallXMLResource(Zalbacutanje.class, xmlResource);
                lista.add(Zalbacutanje);
            }catch (Exception e){
                continue;
            }
        }
        return lista;
    }
}
