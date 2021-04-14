//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.19 at 05:52:25 PM CET 
//


package com.projekat.poverenik.model.izvestaji;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


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
 *         &lt;element name="zahtevi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="zalbe"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                   &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;minLength value="5"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="datum" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zahtevi",
    "zalbe"
})
@XmlRootElement(name = "izvestaj")
public class Izvestaj {

    @XmlElement(required = true)
    protected Zahtevi zahtevi;
    @XmlElement(required = true)
    protected Zalbe zalbe;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;

    /**
     * Gets the value of the zahtevi property.
     *
     * @return
     *     possible object is
     *     {@link Zahtevi }
     *
     */
    public Zahtevi getZahtevi() {
        return zahtevi;
    }

    /**
     * Sets the value of the zahtevi property.
     *
     * @param value
     *     allowed object is
     *     {@link Zahtevi }
     *
     */
    public void setZahtevi(Zahtevi value) {
        this.zahtevi = value;
    }

    /**
     * Gets the value of the zalbe property.
     *
     * @return
     *     possible object is
     *     {@link Zalbe }
     *
     */
    public Zalbe getZalbe() {
        return zalbe;
    }

    /**
     * Sets the value of the zalbe property.
     *
     * @param value
     *     allowed object is
     *     {@link Zalbe }
     *
     */
    public void setZalbe(Zalbe value) {
        this.zalbe = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ukupanBrPodnetihZahteva",
        "brUsvojenihZahteva",
        "brOdbijenihZahteva",
        "brOdbacenihZahteva"
    })
    public static class Zahtevi {

        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger ukupanBrPodnetihZahteva;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brUsvojenihZahteva;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brOdbijenihZahteva;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brOdbacenihZahteva;

        /**
         * Gets the value of the ukupanBrPodnetihZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getUkupanBrPodnetihZahteva() {
            return ukupanBrPodnetihZahteva;
        }

        /**
         * Sets the value of the ukupanBrPodnetihZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setUkupanBrPodnetihZahteva(BigInteger value) {
            this.ukupanBrPodnetihZahteva = value;
        }

        /**
         * Gets the value of the brUsvojenihZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrUsvojenihZahteva() {
            return brUsvojenihZahteva;
        }

        /**
         * Sets the value of the brUsvojenihZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrUsvojenihZahteva(BigInteger value) {
            this.brUsvojenihZahteva = value;
        }

        /**
         * Gets the value of the brOdbijenihZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrOdbijenihZahteva() {
            return brOdbijenihZahteva;
        }

        /**
         * Sets the value of the brOdbijenihZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrOdbijenihZahteva(BigInteger value) {
            this.brOdbijenihZahteva = value;
        }

        /**
         * Gets the value of the brOdbacenihZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrOdbacenihZahteva() {
            return brOdbacenihZahteva;
        }

        /**
         * Sets the value of the brOdbacenihZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrOdbacenihZahteva(BigInteger value) {
            this.brOdbacenihZahteva = value;
        }

    }


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
     *         &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *         &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ukupanBrIzjavljenihZalbi",
        "brZalbiNijePostupio",
        "brZalbiNijePostupioUCelosti",
        "brZalbiNijePostupioURoku",
        "brZalbiNaOdluku"
    })
    public static class Zalbe {

        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger ukupanBrIzjavljenihZalbi;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brZalbiNijePostupio;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brZalbiNijePostupioUCelosti;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brZalbiNijePostupioURoku;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger brZalbiNaOdluku;

        /**
         * Gets the value of the ukupanBrIzjavljenihZalbi property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getUkupanBrIzjavljenihZalbi() {
            return ukupanBrIzjavljenihZalbi;
        }

        /**
         * Sets the value of the ukupanBrIzjavljenihZalbi property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setUkupanBrIzjavljenihZalbi(BigInteger value) {
            this.ukupanBrIzjavljenihZalbi = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupio property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrZalbiNijePostupio() {
            return brZalbiNijePostupio;
        }

        /**
         * Sets the value of the brZalbiNijePostupio property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrZalbiNijePostupio(BigInteger value) {
            this.brZalbiNijePostupio = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupioUCelosti property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrZalbiNijePostupioUCelosti() {
            return brZalbiNijePostupioUCelosti;
        }

        /**
         * Sets the value of the brZalbiNijePostupioUCelosti property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrZalbiNijePostupioUCelosti(BigInteger value) {
            this.brZalbiNijePostupioUCelosti = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupioURoku property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrZalbiNijePostupioURoku() {
            return brZalbiNijePostupioURoku;
        }

        /**
         * Sets the value of the brZalbiNijePostupioURoku property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrZalbiNijePostupioURoku(BigInteger value) {
            this.brZalbiNijePostupioURoku = value;
        }

        /**
         * Gets the value of the brZalbiNaOdluku property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrZalbiNaOdluku() {
            return brZalbiNaOdluku;
        }

        /**
         * Sets the value of the brZalbiNaOdluku property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrZalbiNaOdluku(BigInteger value) {
            this.brZalbiNaOdluku = value;
        }

    }

}
