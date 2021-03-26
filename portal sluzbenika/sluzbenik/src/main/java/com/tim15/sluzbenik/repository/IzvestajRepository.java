package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IzvestajRepository {
    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/obavestenja";

    public void saveObavestenjeFromText(String text, String id) throws Exception {
        existManager.storeFromText(collectionId, id, text);
    }
}
