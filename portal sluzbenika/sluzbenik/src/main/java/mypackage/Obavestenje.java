
package mypackage;

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
 *         &lt;element name="organ">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv_organa">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="sediste_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="broj_predmeta">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
 *         &lt;element name="podnosilac_zahteva" type="{https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir}TPodnosilac_zahteva"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uvid" type="{https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir}tipUvid"/>
 *         &lt;element name="iznos_troskova" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dostavljeno" type="{https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir}tipDostavljeno"/>
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
    "organ",
    "brojPredmeta",
    "datum",
    "podnosilacZahteva",
    "naslov",
    "uvid",
    "iznosTroskova",
    "dostavljeno"
})
@XmlRootElement(name = "obavestenje", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir")
public class Obavestenje {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected Obavestenje.Organ organ;
    @XmlElement(name = "broj_predmeta", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected Obavestenje.BrojPredmeta brojPredmeta;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected Obavestenje.Datum datum;
    @XmlElement(name = "podnosilac_zahteva", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TPodnosilacZahteva podnosilacZahteva;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected String naslov;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TipUvid uvid;
    @XmlElement(name = "iznos_troskova", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir")
    protected double iznosTroskova;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TipDostavljeno dostavljeno;

    /**
     * Gets the value of the organ property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Organ }
     *     
     */
    public Obavestenje.Organ getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Organ }
     *     
     */
    public void setOrgan(Obavestenje.Organ value) {
        this.organ = value;
    }

    /**
     * Gets the value of the brojPredmeta property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.BrojPredmeta }
     *     
     */
    public Obavestenje.BrojPredmeta getBrojPredmeta() {
        return brojPredmeta;
    }

    /**
     * Sets the value of the brojPredmeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.BrojPredmeta }
     *     
     */
    public void setBrojPredmeta(Obavestenje.BrojPredmeta value) {
        this.brojPredmeta = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link Obavestenje.Datum }
     *     
     */
    public Obavestenje.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obavestenje.Datum }
     *     
     */
    public void setDatum(Obavestenje.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the podnosilacZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link TPodnosilacZahteva }
     *     
     */
    public TPodnosilacZahteva getPodnosilacZahteva() {
        return podnosilacZahteva;
    }

    /**
     * Sets the value of the podnosilacZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPodnosilacZahteva }
     *     
     */
    public void setPodnosilacZahteva(TPodnosilacZahteva value) {
        this.podnosilacZahteva = value;
    }

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
     * Gets the value of the uvid property.
     * 
     * @return
     *     possible object is
     *     {@link TipUvid }
     *     
     */
    public TipUvid getUvid() {
        return uvid;
    }

    /**
     * Sets the value of the uvid property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipUvid }
     *     
     */
    public void setUvid(TipUvid value) {
        this.uvid = value;
    }

    /**
     * Gets the value of the iznosTroskova property.
     * 
     */
    public double getIznosTroskova() {
        return iznosTroskova;
    }

    /**
     * Sets the value of the iznosTroskova property.
     * 
     */
    public void setIznosTroskova(double value) {
        this.iznosTroskova = value;
    }

    /**
     * Gets the value of the dostavljeno property.
     * 
     * @return
     *     possible object is
     *     {@link TipDostavljeno }
     *     
     */
    public TipDostavljeno getDostavljeno() {
        return dostavljeno;
    }

    /**
     * Sets the value of the dostavljeno property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipDostavljeno }
     *     
     */
    public void setDostavljeno(TipDostavljeno value) {
        this.dostavljeno = value;
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
    public static class BrojPredmeta {

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
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="naziv_organa">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="sediste_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "nazivOrgana",
        "sedisteOrgana"
    })
    public static class Organ {

        @XmlElement(name = "naziv_organa", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
        protected Obavestenje.Organ.NazivOrgana nazivOrgana;
        @XmlElement(name = "sediste_organa", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
        protected String sedisteOrgana;

        /**
         * Gets the value of the nazivOrgana property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.Organ.NazivOrgana }
         *     
         */
        public Obavestenje.Organ.NazivOrgana getNazivOrgana() {
            return nazivOrgana;
        }

        /**
         * Sets the value of the nazivOrgana property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.Organ.NazivOrgana }
         *     
         */
        public void setNazivOrgana(Obavestenje.Organ.NazivOrgana value) {
            this.nazivOrgana = value;
        }

        /**
         * Gets the value of the sedisteOrgana property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSedisteOrgana() {
            return sedisteOrgana;
        }

        /**
         * Sets the value of the sedisteOrgana property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSedisteOrgana(String value) {
            this.sedisteOrgana = value;
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
        public static class NazivOrgana {

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

}
