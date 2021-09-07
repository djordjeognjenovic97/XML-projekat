
package com.tim15.sluzbenik.soap.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TipZakon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipZakon"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clan" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="stav" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tacka" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="naziv_zakona" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="naziv_sluzbenog_glasnika" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="broj_slg" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipZakon", propOrder = {
    "clan",
    "stav",
    "tacka",
    "nazivZakona",
    "nazivSluzbenogGlasnika",
    "brojSlg"
})
public class TipZakon {

    protected List<String> clan;
    protected List<String> stav;
    protected List<String> tacka;
    @XmlElement(name = "naziv_zakona")
    protected List<String> nazivZakona;
    @XmlElement(name = "naziv_sluzbenog_glasnika")
    protected String nazivSluzbenogGlasnika;
    @XmlElement(name = "broj_slg")
    protected List<String> brojSlg;

    /**
     * Gets the value of the clan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getClan() {
        if (clan == null) {
            clan = new ArrayList<String>();
        }
        return this.clan;
    }

    /**
     * Gets the value of the stav property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stav property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStav().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStav() {
        if (stav == null) {
            stav = new ArrayList<String>();
        }
        return this.stav;
    }

    /**
     * Gets the value of the tacka property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tacka property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTacka().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTacka() {
        if (tacka == null) {
            tacka = new ArrayList<String>();
        }
        return this.tacka;
    }

    /**
     * Gets the value of the nazivZakona property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nazivZakona property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNazivZakona().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNazivZakona() {
        if (nazivZakona == null) {
            nazivZakona = new ArrayList<String>();
        }
        return this.nazivZakona;
    }

    /**
     * Gets the value of the nazivSluzbenogGlasnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivSluzbenogGlasnika() {
        return nazivSluzbenogGlasnika;
    }

    /**
     * Sets the value of the nazivSluzbenogGlasnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivSluzbenogGlasnika(String value) {
        this.nazivSluzbenogGlasnika = value;
    }

    /**
     * Gets the value of the brojSlg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brojSlg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrojSlg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBrojSlg() {
        if (brojSlg == null) {
            brojSlg = new ArrayList<String>();
        }
        return this.brojSlg;
    }

}
