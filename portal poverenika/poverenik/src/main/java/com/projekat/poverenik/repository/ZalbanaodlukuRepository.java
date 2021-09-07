package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.model.zalbacutanjecir.Zalbacutanje;
import com.projekat.poverenik.model.zalbanaodlukucir.Zalbaodluka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;

@Repository
public class ZalbanaodlukuRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/zalbenaodluku";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat/Zalbaodlukacir";

    public Zalbaodluka findRealZalbaodlukaById(String s) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, s);
        JaxbParser jaxbParser = new JaxbParser();
        Zalbaodluka zalbaodluka = (Zalbaodluka) jaxbParser.unmarshallXMLResource(Zalbaodluka.class,xmlResource);
        return zalbaodluka;
    }

    public ArrayList<Zalbaodluka> findAll() throws Exception {
        Collection kolekcijazc = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Zalbaodluka> zo = new ArrayList<Zalbaodluka>();
        String[] ids = kolekcijazc.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                zo.add(jaxbParser.unmarshallXMLResource(Zalbaodluka.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return zo;
    }

    public void saveZalbanaodlukucirFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public void saveZalbanaodlukucirFromFile(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }

    public Document findZalbanaodlukucirById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public ArrayList<Zalbaodluka> findByContent(String content) throws Exception {
        ArrayList<Zalbaodluka> lista = new ArrayList<Zalbaodluka>();
        ResourceSet resourceSet=existManager.retrieve(collectionId,"//*[contains(., '" + content + "')]",TARGET_NAMESPACE);
        ResourceIterator it = resourceSet.getIterator();
        while (it.hasMoreResources()) {
            try {
                XMLResource xmlResource = (XMLResource) it.nextResource();
                JaxbParser jaxbParser = new JaxbParser();
                Zalbaodluka zalbaodluka = (Zalbaodluka) jaxbParser.unmarshallXMLResource(Zalbaodluka.class, xmlResource);
                lista.add(zalbaodluka);
            }catch (Exception e){
                continue;
            }
        }
        return lista;
    }

    public Zalbaodluka findRealZalbaOdlukaById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        JaxbParser jaxbParser = new JaxbParser();
        Zalbaodluka zalbaodluka= jaxbParser.unmarshallXMLResource(Zalbaodluka.class,xmlResource);
        return zalbaodluka;
    }

    public String findZalbanaodlukuByIdAndReturnString(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        String tekst = (String) xmlResource.getContent();
        return tekst;
    }
}
