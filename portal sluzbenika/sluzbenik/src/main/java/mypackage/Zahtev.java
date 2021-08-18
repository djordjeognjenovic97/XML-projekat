
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="id">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="organ" type="{https://github.com/djordjeognjenovic97/XML-projekat/zahtev}TOrgan"/>
 *         &lt;element name="sadrzaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tipovi_zahteva">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="obavestenje_posedovanje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="uvid_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="kopija_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dostavljanje_kopije">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;choice>
 *                                       &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="elektronska_posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="drugi_nacin" minOccurs="0">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;minLength value="1"/>
 *                                             &lt;maxLength value="100"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/choice>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="opis_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mesto_podnosenja_zahteva">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datum_podnosenja_zahteva">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;attribute name="property" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="trazilac_informacije" type="{https://github.com/djordjeognjenovic97/XML-projekat/zahtev}TTrazilac_informacije"/>
 *       &lt;/sequence>
 *       &lt;attribute name="stanje" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="podnet"/>
 *             &lt;enumeration value="usvojen"/>
 *             &lt;enumeration value="odbijen"/>
 *             &lt;enumeration value="odbacen"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "naziv",
    "organ",
    "sadrzaj",
    "mestoPodnosenjaZahteva",
    "datumPodnosenjaZahteva",
    "trazilacInformacije"
})
@XmlRootElement(name = "zahtev", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
public class Zahtev {

    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected Zahtev.Id id;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected String naziv;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected TOrgan organ;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected Zahtev.Sadrzaj sadrzaj;
    @XmlElement(name = "mesto_podnosenja_zahteva", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected Zahtev.MestoPodnosenjaZahteva mestoPodnosenjaZahteva;
    @XmlElement(name = "datum_podnosenja_zahteva", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected Zahtev.DatumPodnosenjaZahteva datumPodnosenjaZahteva;
    @XmlElement(name = "trazilac_informacije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
    protected TTrazilacInformacije trazilacInformacije;
    @XmlAttribute(name = "stanje", required = true)
    protected String stanje;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.Id }
     *     
     */
    public Zahtev.Id getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.Id }
     *     
     */
    public void setId(Zahtev.Id value) {
        this.id = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the organ property.
     * 
     * @return
     *     possible object is
     *     {@link TOrgan }
     *     
     */
    public TOrgan getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOrgan }
     *     
     */
    public void setOrgan(TOrgan value) {
        this.organ = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.Sadrzaj }
     *     
     */
    public Zahtev.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.Sadrzaj }
     *     
     */
    public void setSadrzaj(Zahtev.Sadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the mestoPodnosenjaZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.MestoPodnosenjaZahteva }
     *     
     */
    public Zahtev.MestoPodnosenjaZahteva getMestoPodnosenjaZahteva() {
        return mestoPodnosenjaZahteva;
    }

    /**
     * Sets the value of the mestoPodnosenjaZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.MestoPodnosenjaZahteva }
     *     
     */
    public void setMestoPodnosenjaZahteva(Zahtev.MestoPodnosenjaZahteva value) {
        this.mestoPodnosenjaZahteva = value;
    }

    /**
     * Gets the value of the datumPodnosenjaZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link Zahtev.DatumPodnosenjaZahteva }
     *     
     */
    public Zahtev.DatumPodnosenjaZahteva getDatumPodnosenjaZahteva() {
        return datumPodnosenjaZahteva;
    }

    /**
     * Sets the value of the datumPodnosenjaZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zahtev.DatumPodnosenjaZahteva }
     *     
     */
    public void setDatumPodnosenjaZahteva(Zahtev.DatumPodnosenjaZahteva value) {
        this.datumPodnosenjaZahteva = value;
    }

    /**
     * Gets the value of the trazilacInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link TTrazilacInformacije }
     *     
     */
    public TTrazilacInformacije getTrazilacInformacije() {
        return trazilacInformacije;
    }

    /**
     * Sets the value of the trazilacInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTrazilacInformacije }
     *     
     */
    public void setTrazilacInformacije(TTrazilacInformacije value) {
        this.trazilacInformacije = value;
    }

    /**
     * Gets the value of the stanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStanje() {
        return stanje;
    }

    /**
     * Sets the value of the stanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStanje(String value) {
        this.stanje = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
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
    public static class DatumPodnosenjaZahteva {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "property")
        protected String property;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
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
    public static class Id {

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
    public static class MestoPodnosenjaZahteva {

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
     *         &lt;element name="tipovi_zahteva">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="obavestenje_posedovanje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="uvid_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="kopija_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dostavljanje_kopije">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;choice>
     *                             &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="elektronska_posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="drugi_nacin" minOccurs="0">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;minLength value="1"/>
     *                                   &lt;maxLength value="100"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/choice>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="opis_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "tipoviZahteva",
        "opisInformacije"
    })
    public static class Sadrzaj {

        @XmlElement(name = "tipovi_zahteva", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
        protected Zahtev.Sadrzaj.TipoviZahteva tipoviZahteva;
        @XmlElement(name = "opis_informacije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
        protected String opisInformacije;

        /**
         * Gets the value of the tipoviZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link Zahtev.Sadrzaj.TipoviZahteva }
         *     
         */
        public Zahtev.Sadrzaj.TipoviZahteva getTipoviZahteva() {
            return tipoviZahteva;
        }

        /**
         * Sets the value of the tipoviZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link Zahtev.Sadrzaj.TipoviZahteva }
         *     
         */
        public void setTipoviZahteva(Zahtev.Sadrzaj.TipoviZahteva value) {
            this.tipoviZahteva = value;
        }

        /**
         * Gets the value of the opisInformacije property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpisInformacije() {
            return opisInformacije;
        }

        /**
         * Sets the value of the opisInformacije property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpisInformacije(String value) {
            this.opisInformacije = value;
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
         *         &lt;element name="obavestenje_posedovanje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="uvid_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="kopija_dokument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dostavljanje_kopije">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice>
         *                   &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="elektronska_posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="drugi_nacin" minOccurs="0">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="100"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/choice>
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
        @XmlType(name = "", propOrder = {
            "obavestenjePosedovanje",
            "uvidDokument",
            "kopijaDokument",
            "dostavljanjeKopije"
        })
        public static class TipoviZahteva {

            @XmlElement(name = "obavestenje_posedovanje", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
            protected String obavestenjePosedovanje;
            @XmlElement(name = "uvid_dokument", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
            protected String uvidDokument;
            @XmlElement(name = "kopija_dokument", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
            protected String kopijaDokument;
            @XmlElement(name = "dostavljanje_kopije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", required = true)
            protected Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije dostavljanjeKopije;

            /**
             * Gets the value of the obavestenjePosedovanje property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObavestenjePosedovanje() {
                return obavestenjePosedovanje;
            }

            /**
             * Sets the value of the obavestenjePosedovanje property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObavestenjePosedovanje(String value) {
                this.obavestenjePosedovanje = value;
            }

            /**
             * Gets the value of the uvidDokument property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUvidDokument() {
                return uvidDokument;
            }

            /**
             * Sets the value of the uvidDokument property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUvidDokument(String value) {
                this.uvidDokument = value;
            }

            /**
             * Gets the value of the kopijaDokument property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKopijaDokument() {
                return kopijaDokument;
            }

            /**
             * Sets the value of the kopijaDokument property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKopijaDokument(String value) {
                this.kopijaDokument = value;
            }

            /**
             * Gets the value of the dostavljanjeKopije property.
             * 
             * @return
             *     possible object is
             *     {@link Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije }
             *     
             */
            public Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije getDostavljanjeKopije() {
                return dostavljanjeKopije;
            }

            /**
             * Sets the value of the dostavljanjeKopije property.
             * 
             * @param value
             *     allowed object is
             *     {@link Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije }
             *     
             */
            public void setDostavljanjeKopije(Zahtev.Sadrzaj.TipoviZahteva.DostavljanjeKopije value) {
                this.dostavljanjeKopije = value;
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
             *       &lt;choice>
             *         &lt;element name="posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="elektronska_posta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="faks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="drugi_nacin" minOccurs="0">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="100"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/choice>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "posta",
                "elektronskaPosta",
                "faks",
                "drugiNacin"
            })
            public static class DostavljanjeKopije {

                @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
                protected String posta;
                @XmlElement(name = "elektronska_posta", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
                protected String elektronskaPosta;
                @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
                protected String faks;
                @XmlElement(name = "drugi_nacin", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev")
                protected String drugiNacin;

                /**
                 * Gets the value of the posta property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPosta() {
                    return posta;
                }

                /**
                 * Sets the value of the posta property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPosta(String value) {
                    this.posta = value;
                }

                /**
                 * Gets the value of the elektronskaPosta property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getElektronskaPosta() {
                    return elektronskaPosta;
                }

                /**
                 * Sets the value of the elektronskaPosta property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setElektronskaPosta(String value) {
                    this.elektronskaPosta = value;
                }

                /**
                 * Gets the value of the faks property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFaks() {
                    return faks;
                }

                /**
                 * Sets the value of the faks property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFaks(String value) {
                    this.faks = value;
                }

                /**
                 * Gets the value of the drugiNacin property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDrugiNacin() {
                    return drugiNacin;
                }

                /**
                 * Sets the value of the drugiNacin property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDrugiNacin(String value) {
                    this.drugiNacin = value;
                }

            }

        }

    }

}
