package com.tim15.sluzbenik.dto;

public class IzvestajDTO {

    private String id;

    private String datum;


    public IzvestajDTO(String id, String datum) {
        this.id = id;
        this.datum = datum;
    }

    public IzvestajDTO() {
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

}
