
package com.tim15.sluzbenik.soap.izjasnjenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="emailPoverenik" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="emailSluzbenik" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sadrzaj"
})
@XmlRootElement(name = "izjasnjenje")
public class Izjasnjenje {

    @XmlElement(required = true)
    protected String sadrzaj;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "emailPoverenik")
    protected String emailPoverenik;
    @XmlAttribute(name = "emailSluzbenik")
    protected String emailSluzbenik;

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
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
     * Gets the value of the emailPoverenik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPoverenik() {
        return emailPoverenik;
    }

    /**
     * Sets the value of the emailPoverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPoverenik(String value) {
        this.emailPoverenik = value;
    }

    /**
     * Gets the value of the emailSluzbenik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailSluzbenik() {
        return emailSluzbenik;
    }

    /**
     * Sets the value of the emailSluzbenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailSluzbenik(String value) {
        this.emailSluzbenik = value;
    }

}
