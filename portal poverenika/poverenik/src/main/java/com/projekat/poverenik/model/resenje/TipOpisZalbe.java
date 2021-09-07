
package com.projekat.poverenik.model.resenje;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipOpis_zalbe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipOpis_zalbe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="razlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="na_osnovu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakon" type="{https://github.com/djordjeognjenovic97/XML-projekat/resenja}TipZakon" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipOpis_zalbe", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", propOrder = {
    "razlog",
    "naOsnovu",
    "zakon"
})
public class TipOpisZalbe {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    protected String razlog;
    @XmlElement(name = "na_osnovu", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    protected String naOsnovu;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja")
    protected List<TipZakon> zakon;

    /**
     * Gets the value of the razlog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazlog() {
        return razlog;
    }

    /**
     * Sets the value of the razlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazlog(String value) {
        this.razlog = value;
    }

    /**
     * Gets the value of the naOsnovu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaOsnovu() {
        return naOsnovu;
    }

    /**
     * Sets the value of the naOsnovu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaOsnovu(String value) {
        this.naOsnovu = value;
    }

    /**
     * Gets the value of the zakon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zakon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZakon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipZakon }
     * 
     * 
     */
    public List<TipZakon> getZakon() {
        if (zakon == null) {
            zakon = new ArrayList<TipZakon>();
        }
        return this.zakon;
    }

}
