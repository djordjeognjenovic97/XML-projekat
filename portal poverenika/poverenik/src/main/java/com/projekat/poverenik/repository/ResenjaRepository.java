package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.modules.XMLResource;

@Repository
public class ResenjaRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/resenja";

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
}
