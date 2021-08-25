
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipDostavljeno complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipDostavljeno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="opcija_dostave">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="izabrano">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="da"/>
 *                         &lt;enumeration value="ne"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="naziv">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
@XmlType(name = "tipDostavljeno", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", propOrder = {
    "opcijaDostave"
})
public class TipDostavljeno {

    @XmlElement(name = "opcija_dostave", namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
    protected TipDostavljeno.OpcijaDostave opcijaDostave;

    /**
     * Gets the value of the opcijaDostave property.
     * 
     * @return
     *     possible object is
     *     {@link TipDostavljeno.OpcijaDostave }
     *     
     */
    public TipDostavljeno.OpcijaDostave getOpcijaDostave() {
        return opcijaDostave;
    }

    /**
     * Sets the value of the opcijaDostave property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipDostavljeno.OpcijaDostave }
     *     
     */
    public void setOpcijaDostave(TipDostavljeno.OpcijaDostave value) {
        this.opcijaDostave = value;
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
     *         &lt;element name="izabrano">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="da"/>
     *               &lt;enumeration value="ne"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="naziv">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="50"/>
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
        "izabrano",
        "naziv"
    })
    public static class OpcijaDostave {

        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
        protected String izabrano;
        @XmlElement(namespace = "https://github.com/djordjeognjenovic97/XML-projekat/obavestenjecir", required = true)
        protected String naziv;

        /**
         * Gets the value of the izabrano property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIzabrano() {
            return izabrano;
        }

        /**
         * Sets the value of the izabrano property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIzabrano(String value) {
            this.izabrano = value;
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

    }

}
