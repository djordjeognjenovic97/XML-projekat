package com.projekat.poverenik.dto;

public class ZalbacutanjeDTO {

    private String id;
    private String mesto;
    private String datum;
    private String stanje;

    public ZalbacutanjeDTO() {
    }

    public ZalbacutanjeDTO(String id, String mesto, String datum, String stanje) {
        this.id = id;
        this.mesto = mesto;
        this.datum = datum;
        this.stanje= stanje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }
}
