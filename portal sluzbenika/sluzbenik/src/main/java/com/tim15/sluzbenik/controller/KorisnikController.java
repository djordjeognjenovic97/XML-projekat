package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/korisnici", produces = MediaType.APPLICATION_JSON_VALUE)
public class KorisnikController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping(value = "/initialize", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> initializeKorisniciDatabase(@RequestBody String path) throws Exception {
        customUserDetailsService.initialize(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @PostMapping(value = "/test")
    public ResponseEntity<String> test() throws Exception {
        Korisnik k = new Korisnik();
        k.setEmail("test");
        k.setIme("test");
        k.setLozinka("test");
        k.setPrezime("test");
        k.setUloga("GRADJANIN");
        customUserDetailsService.create(k);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }
}
