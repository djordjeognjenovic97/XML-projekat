//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.01 at 10:47:00 AM CET 
//


package com.tim15.sluzbenik.model.zahtevcir;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="Header" type="{http://www.ftn.uns.ac.rs/zahtevcir}tipHeader"/&gt;
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telo" type="{http://www.ftn.uns.ac.rs/zahtevcir}tipTelo"/&gt;
 *         &lt;element name="fusnote"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fusnota" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="br_zvezda" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "", propOrder = {
    "header",
    "naslov",
    "telo",
    "fusnote"
})
@XmlRootElement(name = "zahtev")
public class Zahtev {

    @XmlElement(name = "Header", required = true)
    protected TipHeader header;
    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(required = true)
    protected TipTelo telo;
    @XmlElement(required = true)
    protected Zahtev.Fusnote fusnote;

    /**
     * Gets the value of the header property.
     *
     * @return
     *     possible object is
     *     {@link TipHeader }
     *
     */
    public TipHeader getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value
     *     allowed object is
     *     {@link TipHeader }
     *
     */
    public void setHeader(TipHeader value) {
        this.header = value;
    }

    /**
     * Gets the value of the naslov property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the telo property.
     *
     * @return
     *     possible object is
     *     {@link TipTelo }
     *
     */
    public TipTelo getTelo() {
        return telo;
    }

    /**
     * Sets the value of the telo property.
     *
     * @param value
     *     allowed object is
     *     {@link TipTelo }
     *
     */
    public void setTelo(TipTelo value) {
        this.telo = value;
    }

    /**
     * Gets the value of the fusnote property.
     *
     * @return
     *     possible object is
     *     {@link Zahtev.Fusnote }
     *
     */
    public Zahtev.Fusnote getFusnote() {
        return fusnote;
    }

    /**
     * Sets the value of the fusnote property.
     *
     * @param value
     *     allowed object is
     *     {@link Zahtev.Fusnote }
     *
     */
    public void setFusnote(Zahtev.Fusnote value) {
        this.fusnote = value;
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
     *         &lt;element name="fusnota" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="br_zvezda" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
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
    @XmlType(name = "", propOrder = {
        "fusnota"
    })
    public static class Fusnote {

        protected List<Zahtev.Fusnote.Fusnota> fusnota;

        /**
         * Gets the value of the fusnota property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fusnota property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFusnota().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Zahtev.Fusnote.Fusnota }
         *
         *
         */
        public List<Zahtev.Fusnote.Fusnota> getFusnota() {
            if (fusnota == null) {
                fusnota = new ArrayList<Zahtev.Fusnote.Fusnota>();
            }
            return this.fusnota;
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
         *       &lt;attribute name="br_zvezda" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
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
        public static class Fusnota {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "br_zvezda")
            @XmlSchemaType(name = "anySimpleType")
            protected String brZvezda;

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
             * Gets the value of the brZvezda property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBrZvezda() {
                return brZvezda;
            }

            /**
             * Sets the value of the brZvezda property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBrZvezda(String value) {
                this.brZvezda = value;
            }

        }

    }

}
