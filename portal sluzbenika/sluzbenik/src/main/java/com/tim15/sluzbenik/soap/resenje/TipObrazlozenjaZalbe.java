
package com.tim15.sluzbenik.soap.resenje;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TipObrazlozenja_zalbe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipObrazlozenja_zalbe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datum_izjasnjenja" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="datum_trazenja_informacija" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="datum_odgovora" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="razlozi_odluke"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipObrazlozenja_zalbe", propOrder = {
    "datumIzjasnjenja",
    "datumTrazenjaInformacija",
    "datumOdgovora",
    "razloziOdluke"
})
public class TipObrazlozenjaZalbe {

    @XmlElement(name = "datum_izjasnjenja")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumIzjasnjenja;
    @XmlElement(name = "datum_trazenja_informacija", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumTrazenjaInformacija;
    @XmlElement(name = "datum_odgovora", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumOdgovora;
    @XmlElement(name = "razlozi_odluke", required = true)
    protected RazloziOdluke razloziOdluke;

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
     *     {@link RazloziOdluke }
     *     
     */
    public RazloziOdluke getRazloziOdluke() {
        return razloziOdluke;
    }

    /**
     * Sets the value of the razloziOdluke property.
     * 
     * @param value
     *     allowed object is
     *     {@link RazloziOdluke }
     *     
     */
    public void setRazloziOdluke(RazloziOdluke value) {
        this.razloziOdluke = value;
    }


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
     *         &lt;element name="pasus" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pasus"
    })
    public static class RazloziOdluke {

        @XmlElement(required = true)
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
