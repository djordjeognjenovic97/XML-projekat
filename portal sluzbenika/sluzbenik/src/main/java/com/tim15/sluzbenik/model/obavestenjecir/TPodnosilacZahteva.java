
package com.tim15.sluzbenik.model.obavestenjecir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for TPodnosilac_zahteva complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TPodnosilac_zahteva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ime">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="prezime">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir}adresa"/>
 *       &lt;/sequence>
 *       &lt;attribute name="email" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac_zahteva", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", propOrder = {
        "ime",
        "prezime",
        "adresa"
})
public class TPodnosilacZahteva {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TPodnosilacZahteva.Ime ime;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TPodnosilacZahteva.Prezime prezime;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected Adresa adresa;
    @XmlAttribute(name = "email", required = true)
    protected String email;

    /**
     * Gets the value of the ime property.
     *
     * @return
     *     possible object is
     *     {@link TPodnosilacZahteva.Ime }
     *
     */
    public TPodnosilacZahteva.Ime getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     *
     * @param value
     *     allowed object is
     *     {@link TPodnosilacZahteva.Ime }
     *
     */
    public void setIme(TPodnosilacZahteva.Ime value) {
        this.ime = value;
    }

    /**
     * Gets the value of the prezime property.
     *
     * @return
     *     possible object is
     *     {@link TPodnosilacZahteva.Prezime }
     *
     */
    public TPodnosilacZahteva.Prezime getPrezime() {
        return prezime;
    }

    /**
     * Sets the value of the prezime property.
     *
     * @param value
     *     allowed object is
     *     {@link TPodnosilacZahteva.Prezime }
     *
     */
    public void setPrezime(TPodnosilacZahteva.Prezime value) {
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
     * Gets the value of the email property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEmail(String value) {
        this.email = value;
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
    public static class Ime {

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
    public static class Prezime {

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
