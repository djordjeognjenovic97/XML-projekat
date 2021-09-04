package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.soap.izjasnjenje.Izjasnjenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.Collection;
import org.xmldb.api.modules.XMLResource;

import java.util.ArrayList;
@Repository
public class IzjasnjenjeRepository {

    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/izjasnjenja";
    private final static String TARGET_NAMESPACE = "http://izjasnjenje";


    public void saveIzjasnjenjeFromText(String text, String docId) throws Exception {
        existManager.storeFromText(collectionId, docId , text);
    }

    public ArrayList<Izjasnjenje> findAll() throws Exception {
        Collection kolekcijaIz = existManager.getOrCreateCollection(collectionId,0);
        ArrayList<Izjasnjenje> iz = new ArrayList<Izjasnjenje>();
        String[] ids = kolekcijaIz.listResources();
        for(String id:ids){
            XMLResource xmlResource = existManager.load(collectionId, id);
            JaxbParser jaxbParser = new JaxbParser();
            try{
                iz.add(jaxbParser.unmarshallXMLResource(Izjasnjenje.class,xmlResource));
            }catch (Exception e){
                continue;
            }
        }
        return iz;
    }
}
