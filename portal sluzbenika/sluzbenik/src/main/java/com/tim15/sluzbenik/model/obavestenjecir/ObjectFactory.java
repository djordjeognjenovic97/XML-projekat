
package com.tim15.sluzbenik.model.obavestenjecir;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the mypackage package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Obavestenje }
     *
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link TPodnosilacZahteva }
     *
     */
    public TPodnosilacZahteva createTPodnosilacZahteva() {
        return new TPodnosilacZahteva();
    }

    /**
     * Create an instance of {@link Obavestenje.Organ }
     *
     */
    public Obavestenje.Organ createObavestenjeOrgan() {
        return new Obavestenje.Organ();
    }

    /**
     * Create an instance of {@link Obavestenje.BrojPredmeta }
     *
     */
    public Obavestenje.BrojPredmeta createObavestenjeBrojPredmeta() {
        return new Obavestenje.BrojPredmeta();
    }

    /**
     * Create an instance of {@link Obavestenje.Datum }
     *
     */
    public Obavestenje.Datum createObavestenjeDatum() {
        return new Obavestenje.Datum();
    }

    /**
     * Create an instance of {@link TipUvid }
     *
     */
    public TipUvid createTipUvid() {
        return new TipUvid();
    }

    /**
     * Create an instance of {@link Adresa }
     *
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link TPodnosilacZahteva.Ime }
     *
     */
    public TPodnosilacZahteva.Ime createTPodnosilacZahtevaIme() {
        return new TPodnosilacZahteva.Ime();
    }

    /**
     * Create an instance of {@link TPodnosilacZahteva.Prezime }
     *
     */
    public TPodnosilacZahteva.Prezime createTPodnosilacZahtevaPrezime() {
        return new TPodnosilacZahteva.Prezime();
    }

    /**
     * Create an instance of {@link Obavestenje.Organ.NazivOrgana }
     *
     */
    public Obavestenje.Organ.NazivOrgana createObavestenjeOrganNazivOrgana() {
        return new Obavestenje.Organ.NazivOrgana();
    }

}
