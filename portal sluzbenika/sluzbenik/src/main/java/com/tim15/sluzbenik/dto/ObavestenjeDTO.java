package com.tim15.sluzbenik.dto;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class ObavestenjeDTO {

    private String id;

    private String nazivOrgana;

    private String datum;

    public ObavestenjeDTO(String id, String nazivOrgana, String datum) {
        this.id = id;
        this.nazivOrgana = nazivOrgana;
        this.datum = datum;
    }

    public ObavestenjeDTO() {
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

}

