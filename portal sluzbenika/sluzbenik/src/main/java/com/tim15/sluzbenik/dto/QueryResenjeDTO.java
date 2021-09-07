package com.tim15.sluzbenik.dto;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brojPredmeta",
        "imePoverenika",
        "prezimePoverenika",
        "datum",
        "gradjanin",
        "nazivOptuzenog"
})
@XmlRootElement(name = "Query")
public class QueryResenjeDTO {
    @XmlElement(required = true,name = "BrojPredmeta")
    protected String brojPredmeta;

    @XmlElement(required = true,name = "ImePoverenika")
    protected String imePoverenika;

    @XmlElement(required = true,name = "PrezimePoverenika")
    protected String prezimePoverenika;

    @XmlElement(required = true,name = "Datum")
    protected String datum;

    @XmlElement(required = true,name = "Gradjanin")
    protected String gradjanin;

    @XmlElement(required = true,name = "NazivOptuzenog")
    protected String nazivOptuzenog;

    public QueryResenjeDTO() {
    }

    public QueryResenjeDTO(String brojPredmeta, String imePoverenika, String prezimePoverenika, String datum, String mesto, String gradjanin, String nazivOptuzenog) {
        this.brojPredmeta = brojPredmeta;
        this.imePoverenika = imePoverenika;
        this.prezimePoverenika = prezimePoverenika;
        this.datum = datum;
        this.gradjanin = gradjanin;
        this.nazivOptuzenog = nazivOptuzenog;
    }

    public String getBrojPredmeta() {
        return brojPredmeta;
    }

    public void setBrojPredmeta(String brojPredmeta) {
        this.brojPredmeta = brojPredmeta;
    }

    public String getImePoverenika() {
        return imePoverenika;
    }

    public void setImePoverenika(String imePoverenika) {
        this.imePoverenika = imePoverenika;
    }

    public String getPrezimePoverenika() {
        return prezimePoverenika;
    }

    public void setPrezimePoverenika(String prezimePoverenika) {
        this.prezimePoverenika = prezimePoverenika;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getGradjanin() {
        return gradjanin;
    }

    public void setGradjanin(String gradjanin) {
        this.gradjanin = gradjanin;
    }

    public String getNazivOptuzenog() {
        return nazivOptuzenog;
    }

    public void setNazivOptuzenog(String nazivOptuzenog) {
        this.nazivOptuzenog = nazivOptuzenog;
    }
}

