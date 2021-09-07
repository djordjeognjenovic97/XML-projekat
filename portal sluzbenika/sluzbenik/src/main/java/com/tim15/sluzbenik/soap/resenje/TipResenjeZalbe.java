
package com.tim15.sluzbenik.soap.resenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipResenjeZalbe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipResenjeZalbe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rok_trajanja_mora_izvrsi_resenje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dokument_koji_se_trazi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rok_trajanja_provera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipResenjeZalbe", propOrder = {
    "rokTrajanjaMoraIzvrsiResenje",
    "dokumentKojiSeTrazi",
    "rokTrajanjaProvera"
})
public class TipResenjeZalbe {

    @XmlElement(name = "rok_trajanja_mora_izvrsi_resenje")
    protected String rokTrajanjaMoraIzvrsiResenje;
    @XmlElement(name = "dokument_koji_se_trazi")
    protected String dokumentKojiSeTrazi;
    @XmlElement(name = "rok_trajanja_provera")
    protected String rokTrajanjaProvera;

    /**
     * Gets the value of the rokTrajanjaMoraIzvrsiResenje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRokTrajanjaMoraIzvrsiResenje() {
        return rokTrajanjaMoraIzvrsiResenje;
    }

    /**
     * Sets the value of the rokTrajanjaMoraIzvrsiResenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRokTrajanjaMoraIzvrsiResenje(String value) {
        this.rokTrajanjaMoraIzvrsiResenje = value;
    }

    /**
     * Gets the value of the dokumentKojiSeTrazi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDokumentKojiSeTrazi() {
        return dokumentKojiSeTrazi;
    }

    /**
     * Sets the value of the dokumentKojiSeTrazi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDokumentKojiSeTrazi(String value) {
        this.dokumentKojiSeTrazi = value;
    }

    /**
     * Gets the value of the rokTrajanjaProvera property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRokTrajanjaProvera() {
        return rokTrajanjaProvera;
    }

    /**
     * Sets the value of the rokTrajanjaProvera property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRokTrajanjaProvera(String value) {
        this.rokTrajanjaProvera = value;
    }

}
