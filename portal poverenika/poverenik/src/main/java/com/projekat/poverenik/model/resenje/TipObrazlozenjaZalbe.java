
package com.projekat.poverenik.model.resenje;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TipObrazlozenja_zalbe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipObrazlozenja_zalbe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum_izjasnjenja" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="datum_trazenja_informacija" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum_odgovora" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="razlozi_odluke">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "TipObrazlozenja_zalbe", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", propOrder = {
    "datumIzjasnjenja",
    "datumTrazenjaInformacija",
    "datumOdgovora",
    "razloziOdluke"
})
public class TipObrazlozenjaZalbe {

    @XmlElement(name = "datum_izjasnjenja", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzjasnjenja;
    @XmlElement(name = "datum_trazenja_informacija", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumTrazenjaInformacija;
    @XmlElement(name = "datum_odgovora", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOdgovora;
    @XmlElement(name = "razlozi_odluke", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
    protected TipObrazlozenjaZalbe.RazloziOdluke razloziOdluke;

    /**
     * Gets the value of the datumIzjasnjenja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumIzjasnjenja() {
        return datumIzjasnjenja;
    }

    /**
     * Sets the value of the datumIzjasnjenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumIzjasnjenja(XMLGregorianCalendar value) {
        this.datumIzjasnjenja = value;
    }

    /**
     * Gets the value of the datumTrazenjaInformacija property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumTrazenjaInformacija() {
        return datumTrazenjaInformacija;
    }

    /**
     * Sets the value of the datumTrazenjaInformacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumTrazenjaInformacija(XMLGregorianCalendar value) {
        this.datumTrazenjaInformacija = value;
    }

    /**
     * Gets the value of the datumOdgovora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOdgovora() {
        return datumOdgovora;
    }

    /**
     * Sets the value of the datumOdgovora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOdgovora(XMLGregorianCalendar value) {
        this.datumOdgovora = value;
    }

    /**
     * Gets the value of the razloziOdluke property.
     * 
     * @return
     *     possible object is
     *     {@link TipObrazlozenjaZalbe.RazloziOdluke }
     *     
     */
    public TipObrazlozenjaZalbe.RazloziOdluke getRazloziOdluke() {
        return razloziOdluke;
    }

    /**
     * Sets the value of the razloziOdluke property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipObrazlozenjaZalbe.RazloziOdluke }
     *     
     */
    public void setRazloziOdluke(TipObrazlozenjaZalbe.RazloziOdluke value) {
        this.razloziOdluke = value;
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
     *         &lt;element name="pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "pasus"
    })
    public static class RazloziOdluke {

        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/resenja", required = true)
        protected List<String> pasus;

        /**
         * Gets the value of the pasus property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pasus property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPasus().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPasus() {
            if (pasus == null) {
                pasus = new ArrayList<String>();
            }
            return this.pasus;
        }

    }

}
