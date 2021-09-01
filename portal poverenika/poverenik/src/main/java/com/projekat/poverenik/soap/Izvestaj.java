
package com.projekat.poverenik.soap;

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
 *         &lt;element name="zahtevi"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
 *                   &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datum"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;minLength value="5"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
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
    "zalbe",
    "datum"
})
@XmlRootElement(name = "izvestaj")
public class Izvestaj {

    @XmlElement(required = true)
    protected Zahtevi zahtevi;
    @XmlElement(required = true)
    protected Zalbe zalbe;
    @XmlElement(required = true)
    protected Datum datum;
    @XmlAttribute(name = "id", required = true)
    protected String id;

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
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link Datum }
     *     
     */
    public Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datum }
     *     
     */
    public void setDatum(Datum value) {
        this.datum = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Datum {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        protected String property;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

        /**
         * Gets the value of the property property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProperty() {
            return property;
        }

        /**
         * Sets the value of the property property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProperty(String value) {
            this.property = value;
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
     *         &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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

        protected int ukupanBrPodnetihZahteva;
        protected int brUsvojenihZahteva;
        protected int brOdbijenihZahteva;
        protected int brOdbacenihZahteva;

        /**
         * Gets the value of the ukupanBrPodnetihZahteva property.
         * 
         */
        public int getUkupanBrPodnetihZahteva() {
            return ukupanBrPodnetihZahteva;
        }

        /**
         * Sets the value of the ukupanBrPodnetihZahteva property.
         * 
         */
        public void setUkupanBrPodnetihZahteva(int value) {
            this.ukupanBrPodnetihZahteva = value;
        }

        /**
         * Gets the value of the brUsvojenihZahteva property.
         * 
         */
        public int getBrUsvojenihZahteva() {
            return brUsvojenihZahteva;
        }

        /**
         * Sets the value of the brUsvojenihZahteva property.
         * 
         */
        public void setBrUsvojenihZahteva(int value) {
            this.brUsvojenihZahteva = value;
        }

        /**
         * Gets the value of the brOdbijenihZahteva property.
         * 
         */
        public int getBrOdbijenihZahteva() {
            return brOdbijenihZahteva;
        }

        /**
         * Sets the value of the brOdbijenihZahteva property.
         * 
         */
        public void setBrOdbijenihZahteva(int value) {
            this.brOdbijenihZahteva = value;
        }

        /**
         * Gets the value of the brOdbacenihZahteva property.
         * 
         */
        public int getBrOdbacenihZahteva() {
            return brOdbacenihZahteva;
        }

        /**
         * Sets the value of the brOdbacenihZahteva property.
         * 
         */
        public void setBrOdbacenihZahteva(int value) {
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
     *         &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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

        protected int ukupanBrIzjavljenihZalbi;
        protected int brZalbiNijePostupio;
        protected int brZalbiNijePostupioUCelosti;
        protected int brZalbiNijePostupioURoku;
        protected int brZalbiNaOdluku;

        /**
         * Gets the value of the ukupanBrIzjavljenihZalbi property.
         * 
         */
        public int getUkupanBrIzjavljenihZalbi() {
            return ukupanBrIzjavljenihZalbi;
        }

        /**
         * Sets the value of the ukupanBrIzjavljenihZalbi property.
         * 
         */
        public void setUkupanBrIzjavljenihZalbi(int value) {
            this.ukupanBrIzjavljenihZalbi = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupio property.
         * 
         */
        public int getBrZalbiNijePostupio() {
            return brZalbiNijePostupio;
        }

        /**
         * Sets the value of the brZalbiNijePostupio property.
         * 
         */
        public void setBrZalbiNijePostupio(int value) {
            this.brZalbiNijePostupio = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupioUCelosti property.
         * 
         */
        public int getBrZalbiNijePostupioUCelosti() {
            return brZalbiNijePostupioUCelosti;
        }

        /**
         * Sets the value of the brZalbiNijePostupioUCelosti property.
         * 
         */
        public void setBrZalbiNijePostupioUCelosti(int value) {
            this.brZalbiNijePostupioUCelosti = value;
        }

        /**
         * Gets the value of the brZalbiNijePostupioURoku property.
         * 
         */
        public int getBrZalbiNijePostupioURoku() {
            return brZalbiNijePostupioURoku;
        }

        /**
         * Sets the value of the brZalbiNijePostupioURoku property.
         * 
         */
        public void setBrZalbiNijePostupioURoku(int value) {
            this.brZalbiNijePostupioURoku = value;
        }

        /**
         * Gets the value of the brZalbiNaOdluku property.
         * 
         */
        public int getBrZalbiNaOdluku() {
            return brZalbiNaOdluku;
        }

        /**
         * Sets the value of the brZalbiNaOdluku property.
         * 
         */
        public void setBrZalbiNaOdluku(int value) {
            this.brZalbiNaOdluku = value;
        }

    }

}
