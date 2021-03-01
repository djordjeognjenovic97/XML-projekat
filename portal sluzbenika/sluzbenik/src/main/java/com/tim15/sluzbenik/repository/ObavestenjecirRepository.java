package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.modules.XMLResource;

@Repository
public class ObavestenjecirRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/obavestenja";

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
}
