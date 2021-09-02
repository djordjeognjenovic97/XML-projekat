package com.projekat.poverenik.dto;

public class ZalbanaodlukuDTO {

    private String id;
    private String mesto;
    private String datum;

    public ZalbanaodlukuDTO() {
    }

    public ZalbanaodlukuDTO(String id, String mesto, String datum) {
        this.id = id;
        this.mesto = mesto;
        this.datum = datum;
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
}
