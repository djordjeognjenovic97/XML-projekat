package com.projekat.poverenik.model.izvestaji;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the resenje package.
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: resenje
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Izvestaj }
     *
     */
    public Izvestaj createIzvestaj() {
        return new Izvestaj();
    }

    /**
     * Create an instance of {@link Izvestaj.Id }
     *
     */
    public Izvestaj.Id createIzvestajId() {
        return new Izvestaj.Id();
    }

    /**
     * Create an instance of {@link Izvestaj.Zahtevi }
     *
     */
    public Izvestaj.Zahtevi createIzvestajZahtevi() {
        return new Izvestaj.Zahtevi();
    }

    /**
     * Create an instance of {@link Izvestaj.Zalbe }
     *
     */
    public Izvestaj.Zalbe createIzvestajZalbe() {
        return new Izvestaj.Zalbe();
    }

    /**
     * Create an instance of {@link Izvestaj.Datum }
     *
     */
    public Izvestaj.Datum createIzvestajDatum() {
        return new Izvestaj.Datum();
    }

}
