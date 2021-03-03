package com.tim15.sluzbenik.model.korisnici;
import org.springframework.security.core.GrantedAuthority;

//@Table(name="ULOGE")
public class Uloga implements GrantedAuthority {

    private String ime;

    public Uloga() {

    }

    public Uloga(String ime) {
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String getAuthority() {
        return this.ime;
    }


}
