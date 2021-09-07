
package com.tim15.sluzbenik.soap.resenje;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for TipOptuzeni complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipOptuzeni"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="naziv_optuzenog"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sediste_optuzenog" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipOptuzeni", propOrder = {
    "nazivOptuzenog",
    "sedisteOptuzenog"
})
public class TipOptuzeni {

    @XmlElement(name = "naziv_optuzenog", required = true)
    protected NazivOptuzenog nazivOptuzenog;
    @XmlElement(name = "sediste_optuzenog", required = true)
    protected String sedisteOptuzenog;

    /**
     * Gets the value of the nazivOptuzenog property.
     * 
     * @return
     *     possible object is
     *     {@link NazivOptuzenog }
     *     
     */
    public NazivOptuzenog getNazivOptuzenog() {
        return nazivOptuzenog;
    }

    /**
     * Sets the value of the nazivOptuzenog property.
     * 
     * @param value
     *     allowed object is
     *     {@link NazivOptuzenog }
     *     
     */
    public void setNazivOptuzenog(NazivOptuzenog value) {
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
