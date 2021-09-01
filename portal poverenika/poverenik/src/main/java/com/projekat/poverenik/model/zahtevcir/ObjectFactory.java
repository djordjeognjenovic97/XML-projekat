
package com.projekat.poverenik.model.zahtevcir;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the zalbanaodlukucir package.
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zalbanaodlukucir
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Zahtev }
     *
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link Zahtev.Sadrzaj }
     *
     */
    public Zahtev.Sadrzaj createZahtevSadrzaj() {
        return new Zahtev.Sadrzaj();
    }

    /**
     * Create an instance of {@link Zahtev.Sadrzaj.TipoviZahteva }
     *
     */
    public Zahtev.Sadrzaj.TipoviZahteva createZahtevSadrzajTipoviZahteva() {
        return new Zahtev.Sadrzaj.TipoviZahteva();
    }

    /**
     * Create an instance of {@link TOrgan }
     *
     */
    public TOrgan createTOrgan() {
        return new TOrgan();
    }

    /**
     * Create an instance of {@link Zahtev.Id }
     *
     */
    public Zahtev.Id createZahtevId() {
        return new Zahtev.Id();
    }

    /**
     * Create an instance of {@link Zahtev.MestoPodnosenjaZahteva }
     *
     */
    public Zahtev.MestoPodnosenjaZahteva createZahtevMestoPodnosenjaZahteva() {
        return new Zahtev.MestoPodnosenjaZahteva();
    }

    /**
     * Create an instance of {@link Zahtev.DatumPodnosenjaZahteva }
     *
     */
    public Zahtev.DatumPodnosenjaZahteva createZahtevDatumPodnosenjaZahteva() {
        return new Zahtev.DatumPodnosenjaZahteva();
    }

    /**
     * Create an instance of {@link TTrazilacInformacije }
     *
     */
    public TTrazilacInformacije createTTrazilacInformacije() {
        return new TTrazilacInformacije();
    }

    /**
     * Create an instance of {@link Adresa }
     *
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije }
     *
     */
    public Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije createZahtevSadrzajTipoviZahtevaDostavljanjeKopije() {
        return new Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije();
    }

    /**
     * Create an instance of {@link TOrgan.Naziv }
     *
     */
    public TOrgan.Naziv createTOrganNaziv() {
        return new TOrgan.Naziv();
    }

}
