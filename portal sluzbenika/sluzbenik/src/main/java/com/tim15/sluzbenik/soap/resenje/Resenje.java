
package com.tim15.sluzbenik.soap.resenje;

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
 *         &lt;element name="datum"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="broj_resenja"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="gradjanin"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="optuzeni" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipOptuzeni" minOccurs="0"/&gt;
 *         &lt;element name="opis_zalbe" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipOpis_zalbe"/&gt;
 *         &lt;element name="resenje_zalbe" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipResenjeZalbe" minOccurs="0"/&gt;
 *         &lt;element name="obrazlozenja_zalbe" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipObrazlozenja_zalbe" minOccurs="0"/&gt;
 *         &lt;element name="poverenik" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipPoverenik" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="email_gradjanina" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datum",
    "brojResenja",
    "status",
    "gradjanin",
    "datumPodnosenja",
    "optuzeni",
    "opisZalbe",
    "resenjeZalbe",
    "obrazlozenjaZalbe",
    "poverenik"
})
@XmlRootElement(name = "resenje")
public class Resenje {

    @XmlElement(required = true)
    protected Datum datum;
    @XmlElement(name = "broj_resenja", required = true)
    protected BrojResenja brojResenja;
    @XmlElement(required = true)
    protected String status;
    @XmlElement(required = true)
    protected Gradjanin gradjanin;
    @XmlElement(name = "datum_podnosenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPodnosenja;
    protected TipOptuzeni optuzeni;
    @XmlElement(name = "opis_zalbe", required = true)
    protected TipOpisZalbe opisZalbe;
    @XmlElement(name = "resenje_zalbe")
    protected TipResenjeZalbe resenjeZalbe;
    @XmlElement(name = "obrazlozenja_zalbe")
    protected TipObrazlozenjaZalbe obrazlozenjaZalbe;
    protected TipPoverenik poverenik;
    @XmlAttribute(name = "email_gradjanina")
    protected String emailGradjanina;
    @XmlAttribute(name = "id")
    protected String id;

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
     * Gets the value of the brojResenja property.
     * 
     * @return
     *     possible object is
     *     {@link BrojResenja }
     *     
     */
    public BrojResenja getBrojResenja() {
        return brojResenja;
    }

    /**
     * Sets the value of the brojResenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link BrojResenja }
     *     
     */
    public void setBrojResenja(BrojResenja value) {
        this.brojResenja = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the gradjanin property.
     * 
     * @return
     *     possible object is
     *     {@link Gradjanin }
     *     
     */
    public Gradjanin getGradjanin() {
        return gradjanin;
    }

    /**
     * Sets the value of the gradjanin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gradjanin }
     *     
     */
    public void setGradjanin(Gradjanin value) {
        this.gradjanin = value;
    }

    /**
     * Gets the value of the datumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    /**
     * Sets the value of the datumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPodnosenja(XMLGregorianCalendar value) {
        this.datumPodnosenja = value;
    }

    /**
     * Gets the value of the optuzeni property.
     * 
     * @return
     *     possible object is
     *     {@link TipOptuzeni }
     *     
     */
    public TipOptuzeni getOptuzeni() {
        return optuzeni;
    }

    /**
     * Sets the value of the optuzeni property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipOptuzeni }
     *     
     */
    public void setOptuzeni(TipOptuzeni value) {
        this.optuzeni = value;
    }

    /**
     * Gets the value of the opisZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TipOpisZalbe }
     *     
     */
    public TipOpisZalbe getOpisZalbe() {
        return opisZalbe;
    }

    /**
     * Sets the value of the opisZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipOpisZalbe }
     *     
     */
    public void setOpisZalbe(TipOpisZalbe value) {
        this.opisZalbe = value;
    }

    /**
     * Gets the value of the resenjeZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TipResenjeZalbe }
     *     
     */
    public TipResenjeZalbe getResenjeZalbe() {
        return resenjeZalbe;
    }

    /**
     * Sets the value of the resenjeZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipResenjeZalbe }
     *     
     */
    public void setResenjeZalbe(TipResenjeZalbe value) {
        this.resenjeZalbe = value;
    }

    /**
     * Gets the value of the obrazlozenjaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TipObrazlozenjaZalbe }
     *     
     */
    public TipObrazlozenjaZalbe getObrazlozenjaZalbe() {
        return obrazlozenjaZalbe;
    }

    /**
     * Sets the value of the obrazlozenjaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipObrazlozenjaZalbe }
     *     
     */
    public void setObrazlozenjaZalbe(TipObrazlozenjaZalbe value) {
        this.obrazlozenjaZalbe = value;
    }

    /**
     * Gets the value of the poverenik property.
     * 
     * @return
     *     possible object is
     *     {@link TipPoverenik }
     *     
     */
    public TipPoverenik getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPoverenik }
     *     
     */
    public void setPoverenik(TipPoverenik value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the emailGradjanina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailGradjanina() {
        return emailGradjanina;
    }

    /**
     * Sets the value of the emailGradjanina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailGradjanina(String value) {
        this.emailGradjanina = value;
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
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
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
    public static class BrojResenja {

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
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
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
    public static class Gradjanin {

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

}
