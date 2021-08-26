package com.tim15.sluzbenik.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brojPredmeta",
        "imePodnosioca",
        "prezimePodnosioca",
        "datum",
        "nazivOrgana"
})
@XmlRootElement(name = "Query")
public class QueryObavestenjeDTO {

    @XmlElement(required = true,name = "BrojPredmeta")
    protected String brojPredmeta;

    @XmlElement(required = true,name = "ImePodnosioca")
    protected String imePodnosioca;

    @XmlElement(required = true,name = "PrezimePodnosioca")
    protected String prezimePodnosioca;

    @XmlElement(required = true,name = "Datum")
    protected String datum;

    @XmlElement(required = true,name = "NazivOrgana")
    protected String nazivOrgana;

    public QueryObavestenjeDTO() {
    }

    public QueryObavestenjeDTO(String brojPredmeta, String imePodnosioca,String prezimePodnosioca, String datum, String nazivOrgana) {
        this.brojPredmeta = brojPredmeta;
        this.imePodnosioca = imePodnosioca;
        this.prezimePodnosioca=prezimePodnosioca;
        this.datum = datum;
        this.nazivOrgana = nazivOrgana;
    }

    public String getBrojPredmeta() {
        return brojPredmeta;
    }

    public void setBrojPredmeta(String brojPredmeta) {
        this.brojPredmeta = brojPredmeta;
    }

    public String getImePodnosioca() {
        return imePodnosioca;
    }

    public void setImePodnosioca(String imePodnosioca) {
        this.imePodnosioca = imePodnosioca;
    }

    public String getPrezimePodnosioca() {
        return prezimePodnosioca;
    }

    public void setPrezimePodnosioca(String prezimePodnosioca) {
        this.prezimePodnosioca = prezimePodnosioca;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getNazivOrgana() {
        return nazivOrgana;
    }

    public void setNazivOrgana(String nazivOrgana) {
        this.nazivOrgana = nazivOrgana;
    }
}

