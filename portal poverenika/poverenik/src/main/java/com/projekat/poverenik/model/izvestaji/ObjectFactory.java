//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.19 at 05:52:25 PM CET 
//


package com.projekat.poverenik.model.izvestaji;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.github_com.djordjeognjenovic97.xml_projekat.izvestaji package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.github_com.djordjeognjenovic97.xml_projekat.izvestaji
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

}
