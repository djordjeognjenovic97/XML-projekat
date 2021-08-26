package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
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
public class ObavestenjecirRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/obavestenja";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir";

    public void saveObavestenjeFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public void saveObavestenjeFromFile(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }

    public Document findObavestenjeById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public ArrayList<Obavestenje> findAll() throws Exception {
        Collection kolekcijaObavestenja = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Obavestenje> obavestenja = new ArrayList<Obavestenje>();
        String[] ids = kolekcijaObavestenja.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                obavestenja.add(jaxbParser.unmarshallXMLResource(Obavestenje.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return obavestenja;
    }

    public ArrayList<Obavestenje> findByContent(String content) throws Exception {
        ArrayList<Obavestenje> lista = new ArrayList<Obavestenje>();
        ResourceSet resourceSet=existManager.retrieve(collectionId,"//*[contains(., '" + content + "')]",TARGET_NAMESPACE);
        ResourceIterator it = resourceSet.getIterator();
        while (it.hasMoreResources()) {
            try {
                XMLResource xmlResource = (XMLResource) it.nextResource();
                JaxbParser jaxbParser = new JaxbParser();
                Obavestenje obavestenje = (Obavestenje) jaxbParser.unmarshallXMLResource(Obavestenje.class, xmlResource);
                lista.add(obavestenje);
            }catch (Exception e){
                continue;
            }
        }
        return lista;
    }

    public Obavestenje findRealObavestenjeById(String s) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, s);
        JaxbParser jaxbParser = new JaxbParser();
        Obavestenje obavestenje = (Obavestenje) jaxbParser.unmarshallXMLResource(Obavestenje.class,xmlResource);
        return obavestenje;
    }
}
