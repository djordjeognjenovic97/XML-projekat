package com.projekat.poverenik.dto;

public class ResenjeDTO {

    private String id;
    private String datum;
    private String email;
    private String brP;

    public ResenjeDTO() {
    }

    public ResenjeDTO(String id, String datum, String email, String brP) {
        this.id = id;
        this.datum = datum;
        this.email = email;
        this.brP = brP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrP() {
        return brP;
    }

    public void setBrP(String brP) {
        this.brP = brP;
    }
}
