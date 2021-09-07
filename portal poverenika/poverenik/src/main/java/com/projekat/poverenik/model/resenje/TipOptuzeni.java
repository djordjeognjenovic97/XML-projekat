
package com.projekat.poverenik.model.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for TipOptuzeni complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipOptuzeni">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_optuzenog">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sediste_optuzenog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipOptuzeni", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", propOrder = {
    "nazivOptuzenog",
    "sedisteOptuzenog"
})
public class TipOptuzeni {

    @XmlElement(name = "naziv_optuzenog", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    protected TipOptuzeni.NazivOptuzenog nazivOptuzenog;
    @XmlElement(name = "sediste_optuzenog", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    protected String sedisteOptuzenog;

    /**
     * Gets the value of the nazivOptuzenog property.
     * 
     * @return
     *     possible object is
     *     {@link TipOptuzeni.NazivOptuzenog }
     *     
     */
    public TipOptuzeni.NazivOptuzenog getNazivOptuzenog() {
        return nazivOptuzenog;
    }

    /**
     * Sets the value of the nazivOptuzenog property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipOptuzeni.NazivOptuzenog }
     *     
     */
    public void setNazivOptuzenog(TipOptuzeni.NazivOptuzenog value) {
        this.nazivOptuzenog = value;
    }

    /**
     * Gets the value of the sedisteOptuzenog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSedisteOptuzenog() {
        return sedisteOptuzenog;
    }

    /**
     * Sets the value of the sedisteOptuzenog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSedisteOptuzenog(String value) {
        this.sedisteOptuzenog = value;
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
    public static class NazivOptuzenog {

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
