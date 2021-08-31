package com.projekat.poverenik.repository;

import com.projekat.poverenik.existdb.ExistManager;
import com.projekat.poverenik.jaxb.JaxbParser;
import com.projekat.poverenik.model.korisnici.Korisnik;
import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

@Repository
public class KorisnikRepository {

    @Autowired
    ExistManager existManager;

    private String collectionId = "/db/sluzbenik/korisnici";
    private final static String TARGET_NAMESPACE = "https://github.com/djordjeognjenovic97/XML-projekat";

    public Korisnik findByEmail(String email) throws Exception {
        String xPathExpression = String.format("/Korisnici/Korisnik[Email='%s']", email);
        Korisnik pronadjeniKorisnik = null;
        try {
            ResourceSet result = existManager.retrieve(collectionId, xPathExpression, TARGET_NAMESPACE);
            if (result == null) {
                return null;
            }
            ResourceIterator i = result.getIterator();
            XMLResource resource = null;
            JaxbParser jaxbParser = new JaxbParser();
            while (i.hasMoreResources()) {
                try {
                    resource = (XMLResource) i.nextResource();
                    pronadjeniKorisnik = jaxbParser.unmarshallXMLResource(Korisnik.class, resource);

                } finally {
                    try {
                        ((EXistResource) resource).freeResources();
                    } catch (XMLDBException xe) {
                        xe.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pronadjeniKorisnik;
    }

    public void save(Korisnik k) throws Exception {
        JaxbParser jaxbParser = new JaxbParser();
        String xmlKorisnik = jaxbParser.marshallString(Korisnik.class,k);
        System.out.println(xmlKorisnik);
        existManager.update(1, collectionId,"korisnici.xml","/Korisnici", xmlKorisnik);
    }

    public void initialize(String path, String id) throws Exception {
        existManager.store(collectionId, id, path);
    }
}
