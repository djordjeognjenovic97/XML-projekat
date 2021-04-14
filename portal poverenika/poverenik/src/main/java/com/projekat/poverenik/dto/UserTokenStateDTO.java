package com.projekat.poverenik.dto;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accessToken",
        "expiresIn"
})
// DTO koji enkapsulira generisani JWT i njegovo trajanje koji se vracaju klijentu
@XmlRootElement(name = "UserToken")
public class UserTokenStateDTO {

    @XmlElement(required = true,name = "accessToken")
    private String accessToken;
    @XmlElement(required = true,name = "expiresIn")
    private Long expiresIn;

    public UserTokenStateDTO() {
    }

    public UserTokenStateDTO(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
