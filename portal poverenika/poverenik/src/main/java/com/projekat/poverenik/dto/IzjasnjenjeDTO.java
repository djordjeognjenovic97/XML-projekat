package com.projekat.poverenik.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IzjasnjenjeDTO {

    private String id;

    private String sadrzaj;


    public IzjasnjenjeDTO(String id, String sadrzaj) {
        this.id = id;
        this.sadrzaj = sadrzaj;
    }

    public IzjasnjenjeDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

}
