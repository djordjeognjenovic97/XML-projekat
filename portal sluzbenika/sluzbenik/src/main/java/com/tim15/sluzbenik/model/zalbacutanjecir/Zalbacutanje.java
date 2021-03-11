//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.11 at 08:57:30 PM CET 
//


package com.tim15.sluzbenik.model.zalbacutanjecir;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="primalac_zalbe" type="{http://www.ftn.uns.ac.rs/zalbacutanjecir}TPrimalac_Zalbe"/&gt;
 *         &lt;element name="sadrzaj" type="{http://www.ftn.uns.ac.rs/zalbacutanjecir}TSadrzaj"/&gt;
 *         &lt;element name="podnosilac_zalbe" type="{http://www.ftn.uns.ac.rs/zalbacutanjecir}TPodnosilac_Zalbe"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="mesto" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="br_predmeta" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "naslov",
    "primalacZalbe",
    "sadrzaj",
    "podnosilacZalbe"
})
@XmlRootElement(name = "zalbacutanje")
public class Zalbacutanje {

    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "primalac_zalbe", required = true)
    protected TPrimalacZalbe primalacZalbe;
    @XmlElement(required = true)
    protected TSadrzaj sadrzaj;
    @XmlElement(name = "podnosilac_zalbe", required = true)
    protected TPodnosilacZalbe podnosilacZalbe;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "mesto")
    protected String mesto;
    @XmlAttribute(name = "br_predmeta")
    protected String brPredmeta;

    /**
     * Gets the value of the naslov property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the primalacZalbe property.
     *
     * @return
     *     possible object is
     *     {@link TPrimalacZalbe }
     *
     */
    public TPrimalacZalbe getPrimalacZalbe() {
        return primalacZalbe;
    }

    /**
     * Sets the value of the primalacZalbe property.
     *
     * @param value
     *     allowed object is
     *     {@link TPrimalacZalbe }
     *
     */
    public void setPrimalacZalbe(TPrimalacZalbe value) {
        this.primalacZalbe = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     *
     * @return
     *     possible object is
     *     {@link TSadrzaj }
     *
     */
    public TSadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     *
     * @param value
     *     allowed object is
     *     {@link TSadrzaj }
     *
     */
    public void setSadrzaj(TSadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the podnosilacZalbe property.
     *
     * @return
     *     possible object is
     *     {@link TPodnosilacZalbe }
     *
     */
    public TPodnosilacZalbe getPodnosilacZalbe() {
        return podnosilacZalbe;
    }

    /**
     * Sets the value of the podnosilacZalbe property.
     *
     * @param value
     *     allowed object is
     *     {@link TPodnosilacZalbe }
     *     
     */
    public void setPodnosilacZalbe(TPodnosilacZalbe value) {
        this.podnosilacZalbe = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the mesto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the brPredmeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrPredmeta() {
        return brPredmeta;
    }

    /**
     * Sets the value of the brPredmeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrPredmeta(String value) {
        this.brPredmeta = value;
    }

}
