package com.projekat.poverenik.soap.izvestaj;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zahtevi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datum">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "zahtevi",
        "zalbe",
        "datum"
})
@XmlRootElement(name = "izvestaj", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
public class Izvestaj {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj", required = true)
    protected Izvestaj.Id id;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj", required = true)
    protected Izvestaj.Zahtevi zahtevi;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj", required = true)
    protected Izvestaj.Zalbe zalbe;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj", required = true)
    protected Izvestaj.Datum datum;

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Izvestaj.Id }
     *
     */
    public Izvestaj.Id getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Izvestaj.Id }
     *
     */
    public void setId(Izvestaj.Id value) {
        this.id = value;
    }

    /**
     * Gets the value of the zahtevi property.
     *
     * @return
     *     possible object is
     *     {@link Izvestaj.Zahtevi }
     *
     */
    public Izvestaj.Zahtevi getZahtevi() {
        return zahtevi;
    }

    /**
     * Sets the value of the zahtevi property.
     *
     * @param value
     *     allowed object is
     *     {@link Izvestaj.Zahtevi }
     *
     */
    public void setZahtevi(Izvestaj.Zahtevi value) {
        this.zahtevi = value;
    }

    /**
     * Gets the value of the zalbe property.
     *
     * @return
     *     possible object is
     *     {@link Izvestaj.Zalbe }
     *
     */
    public Izvestaj.Zalbe getZalbe() {
        return zalbe;
    }

    /**
     * Sets the value of the zalbe property.
     *
     * @param value
     *     allowed object is
     *     {@link Izvestaj.Zalbe }
     *
     */
    public void setZalbe(Izvestaj.Zalbe value) {
        this.zalbe = value;
    }

    /**
     * Gets the value of the datum property.
     *
     * @return
     *     possible object is
     *     {@link Izvestaj.Datum }
     *
     */
    public Izvestaj.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     *
     * @param value
     *     allowed object is
     *     {@link Izvestaj.Datum }
     *
     */
    public void setDatum(Izvestaj.Datum value) {
        this.datum = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
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
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Id {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "property")
        protected String property;

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ukupanBrPodnetihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brUsvojenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brOdbacenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
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

        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int ukupanBrPodnetihZahteva;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int brUsvojenihZahteva;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int brOdbijenihZahteva;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ukupanBrIzjavljenihZalbi" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brZalbiNijePostupio" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brZalbiNijePostupioUCelosti" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brZalbiNijePostupioURoku" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="brZalbiNaOdluku" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
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

        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int ukupanBrIzjavljenihZalbi;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int brZalbiNijePostupio;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int brZalbiNijePostupioUCelosti;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
        protected int brZalbiNijePostupioURoku;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj")
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
