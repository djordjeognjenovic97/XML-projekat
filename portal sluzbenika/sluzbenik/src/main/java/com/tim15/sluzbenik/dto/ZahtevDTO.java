package com.tim15.sluzbenik.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class ZahtevDTO {

    private String id;

    private String nazivOrgana;

    private String datum;

    private String mesto;

    private String stanje;

    public ZahtevDTO(String id, String nazivOrgana, String datum, String mesto,String stanje) {
        this.id = id;
        this.nazivOrgana = nazivOrgana;
        this.datum = datum;
        this.mesto = mesto;
        this.stanje=stanje;
    }

    public ZahtevDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazivOrgana() {
        return nazivOrgana;
    }

    public void setNazivOrgana(String nazivOrgana) {
        this.nazivOrgana = nazivOrgana;
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

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }
}
