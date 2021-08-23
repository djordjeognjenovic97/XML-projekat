package com.projekat.poverenik.model.zahtevcir;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="br_ulice">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
        "mesto",
        "ulica",
        "brUlice"
})
@XmlRootElement(name = "adresa", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
public class Adresa {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected String mesto;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected String ulica;
    @XmlElement(name = "br_ulice", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
    protected int brUlice;

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
     * Gets the value of the ulica property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the brUlice property.
     *
     */
    public int getBrUlice() {
        return brUlice;
    }

    /**
     * Sets the value of the brUlice property.
     *
     */
    public void setBrUlice(int value) {
        this.brUlice = value;
    }

}
