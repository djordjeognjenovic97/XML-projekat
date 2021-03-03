package com.tim15.sluzbenik.repository;

import com.tim15.sluzbenik.existdb.ExistManager;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xmldb.api.modules.XMLResource;

@Repository
public class KorisnikRepository {

    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/sluzbenik";

    //TREBA PRONACI KORISNIKA IZ /db/sluzbenik/korisnici kolekcije iz fajla korisnici.xml I VRATI TI GA
    public Korisnik findByEmail(String id) throws Exception {
        //XMLResource xmlResource = existManager.load(collectionId, id);
        //Document document = (Document) xmlResource.getContentAsDOM();
        //Korisnik k = new Korisnik();
        //return k;
        return null;
    }
    //TREBA SACUVATI KORISNIKA U FAJL KORISNICI.XML KOJI BI SE TREBAO NALAZITI U DB/SLUZBENIK/KORISNICI
    public void save(Korisnik k) throws Exception {
        JaxbParser jaxbParser=new JaxbParser();
        String xmlKorisnik=jaxbParser.marshallString(Korisnik.class,k);
        this.existManager.update(1,collectionId,"korisnici.xml","/korisnici",xmlKorisnik);
        System.out.println("Korisnik je sacuvan");
    }


}
