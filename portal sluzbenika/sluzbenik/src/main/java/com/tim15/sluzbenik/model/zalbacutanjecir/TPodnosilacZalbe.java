//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.11 at 08:57:30 PM CET 
//


package com.tim15.sluzbenik.model.zalbacutanjecir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac_Zalbe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac_Zalbe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/zalbacutanjecir}adresa"/&gt;
 *         &lt;element name="drugi_kontakt_podaci" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac_Zalbe", propOrder = {
    "ime",
    "prezime",
    "adresa",
    "drugiKontaktPodaci"
})
public class TPodnosilacZalbe {

    @XmlElement(required = true)
    protected String ime;
    @XmlElement(required = true)
    protected String prezime;
    @XmlElement(required = true)
    protected Adresa adresa;
    @XmlElement(name = "drugi_kontakt_podaci", required = true)
    protected String drugiKontaktPodaci;

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezime(String value) {
        this.prezime = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the drugiKontaktPodaci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugiKontaktPodaci() {
        return drugiKontaktPodaci;
    }

    /**
     * Sets the value of the drugiKontaktPodaci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugiKontaktPodaci(String value) {
        this.drugiKontaktPodaci = value;
    }

}
