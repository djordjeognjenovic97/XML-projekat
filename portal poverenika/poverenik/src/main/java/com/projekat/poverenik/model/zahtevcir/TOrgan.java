
package com.projekat.poverenik.model.zahtevcir;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for TOrgan complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TOrgan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sediste" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TOrgan", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", propOrder = {
        "naziv",
        "sediste"
})
public class TOrgan {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected Naziv naziv;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected String sediste;

    /**
     * Gets the value of the naziv property.
     *
     * @return
     *     possible object is
     *     {@link Naziv }
     *
     */
    public Naziv getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value
     *     allowed object is
     *     {@link Naziv }
     *
     */
    public void setNaziv(Naziv value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the sediste property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSediste() {
        return sediste;
    }

    /**
     * Sets the value of the sediste property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSediste(String value) {
        this.sediste = value;
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
    public static class Naziv {

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
