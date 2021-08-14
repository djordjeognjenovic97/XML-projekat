package com.tim15.sluzbenik.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "idDokumenta",
        "mesto",
        "datum",
        "nazivOrgana"
})
@XmlRootElement(name = "Query")
public class QueryZahtevDTO {

    @XmlElement(required = true,name = "IdDokumenta")
    protected String idDokumenta;

    @XmlElement(required = true,name = "Mesto")
    protected String mesto;

    @XmlElement(required = true,name = "Datum")
    protected String datum;

    @XmlElement(required = true,name = "NazivOrgana")
    protected String nazivOrgana;

    public QueryZahtevDTO() {
    }

    public QueryZahtevDTO(String idDokumenta, String mesto, String datum, String nazivOrgana) {
        this.idDokumenta = idDokumenta;
        this.mesto = mesto;
        this.datum = datum;
        this.nazivOrgana = nazivOrgana;
    }

    public String getIdDokumenta() {
        return idDokumenta;
    }

    public void setIdDokumenta(String idDokumenta) {
        this.idDokumenta = idDokumenta;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
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
