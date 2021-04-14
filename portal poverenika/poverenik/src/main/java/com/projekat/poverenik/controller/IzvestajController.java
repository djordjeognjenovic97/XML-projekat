package com.projekat.poverenik.controller;

import com.projekat.poverenik.model.izvestaji.Izvestaj;
import com.projekat.poverenik.service.IzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/izvestaji", produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvestajController {
    @Autowired
    private IzvestajService izvestajService;

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/generateIzvestaj")
    public ResponseEntity<Izvestaj> generateIzvestaj() throws Exception {
        Izvestaj izi = izvestajService.generateIzvestaj();
        return new ResponseEntity<Izvestaj>(izi, HttpStatus.OK);
    }
}
