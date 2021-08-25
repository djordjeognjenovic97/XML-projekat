
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tipUvid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipUvid">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opis_trazene_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datum_uvida" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="broj_sati">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="8"/>
 *               &lt;maxInclusive value="21"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pocetak_akcije">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}time">
 *               &lt;minInclusive value="08:00:00"/>
 *               &lt;maxInclusive value="20:00:00"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="kraj_akcije">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}time">
 *               &lt;minInclusive value="09:00:00"/>
 *               &lt;maxInclusive value="21:00:00"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir}adresa"/>
 *         &lt;element name="broj_kancelarije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipUvid", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", propOrder = {
    "opisTrazeneInformacije",
    "datumUvida",
    "brojSati",
    "pocetakAkcije",
    "krajAkcije",
    "adresa",
    "brojKancelarije"
})
public class TipUvid {

    @XmlElement(name = "opis_trazene_informacije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected String opisTrazeneInformacije;
    @XmlElement(name = "datum_uvida", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumUvida;
    @XmlElement(name = "broj_sati", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true, type = Integer.class, nillable = true)
    protected Integer brojSati;
    @XmlElement(name = "pocetak_akcije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true, nillable = true)
    protected XMLGregorianCalendar pocetakAkcije;
    @XmlElement(name = "kraj_akcije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true, nillable = true)
    protected XMLGregorianCalendar krajAkcije;
    @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected Adresa adresa;
    @XmlElement(name = "broj_kancelarije", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true, nillable = true)
    protected String brojKancelarije;

    /**
     * Gets the value of the opisTrazeneInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisTrazeneInformacije() {
        return opisTrazeneInformacije;
    }

    /**
     * Sets the value of the opisTrazeneInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisTrazeneInformacije(String value) {
        this.opisTrazeneInformacije = value;
    }

    /**
     * Gets the value of the datumUvida property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumUvida() {
        return datumUvida;
    }

    /**
     * Sets the value of the datumUvida property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumUvida(XMLGregorianCalendar value) {
        this.datumUvida = value;
    }

    /**
     * Gets the value of the brojSati property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojSati() {
        return brojSati;
    }

    /**
     * Sets the value of the brojSati property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojSati(Integer value) {
        this.brojSati = value;
    }

    /**
     * Gets the value of the pocetakAkcije property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPocetakAkcije() {
        return pocetakAkcije;
    }

    /**
     * Sets the value of the pocetakAkcije property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPocetakAkcije(XMLGregorianCalendar value) {
        this.pocetakAkcije = value;
    }

    /**
     * Gets the value of the krajAkcije property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getKrajAkcije() {
        return krajAkcije;
    }

    /**
     * Sets the value of the krajAkcije property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKrajAkcije(XMLGregorianCalendar value) {
        this.krajAkcije = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the brojKancelarije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojKancelarije() {
        return brojKancelarije;
    }

    /**
     * Sets the value of the brojKancelarije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojKancelarije(String value) {
        this.brojKancelarije = value;
    }

}
