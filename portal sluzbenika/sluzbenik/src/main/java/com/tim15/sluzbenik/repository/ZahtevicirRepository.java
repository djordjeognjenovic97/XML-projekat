package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;

@Repository
public class ZahtevicirRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/zahtevi";

    public void saveZahtevFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id , text);
    }

    public void saveZahtevFromFile(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }

    public Document findZahtevById(String id) throws Exception {
        XMLResource xmlResource = existManager.load(collectionId, id);
        Document document = (Document) xmlResource.getContentAsDOM();
        return document;
    }

    public ArrayList<Zahtev> findAll() throws Exception {
        Collection kolekcijaZahteva = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Zahtev> zahtevi = new ArrayList<Zahtev>();
        String[] ids = kolekcijaZahteva.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                zahtevi.add(jaxbParser.unmarshallXMLResource(Zahtev.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return zahtevi;
    }
}
