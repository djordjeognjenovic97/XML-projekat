package com.projekat.poverenik.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brojPredmeta",
        "imePodnosioca",
        "prezimePodnosioca",
        "datum",
        "mesto"
})
@XmlRootElement(name = "Query")
public class QueryZalbanaodlukuDTO {
    @XmlElement(required = true,name = "BrojPredmeta")
    protected String brojPredmeta;

    @XmlElement(required = true,name = "ImePodnosioca")
    protected String imePodnosioca;

    @XmlElement(required = true,name = "PrezimePodnosioca")
    protected String prezimePodnosioca;

    @XmlElement(required = true,name = "Datum")
    protected String datum;

    @XmlElement(required = true,name = "Mesto")
    protected String mesto;

    public QueryZalbanaodlukuDTO() {
    }

    public QueryZalbanaodlukuDTO(String brojPredmeta, String imePodnosioca, String prezimePodnosioca, String datum, String mesto) {
        this.brojPredmeta = brojPredmeta;
        this.imePodnosioca = imePodnosioca;
        this.prezimePodnosioca = prezimePodnosioca;
        this.datum = datum;
        this.mesto = mesto;
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

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
}
