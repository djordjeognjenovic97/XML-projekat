package com.tim15.sluzbenik.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "username",
        "password"
})
public class UserLoginDTO {

    @XmlElement(required = true)
    @NotEmpty(message = "Email ne moze biti prazan.")
    @Email(message = "Nevalidan email.")
    protected String username;

    @XmlElement(required = true)
    @NotEmpty(message = "Lozinka ne moze biti prazna.")
    protected String password;

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserLoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
