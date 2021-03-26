package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.izvestaji.Izvestaj;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.service.IzvestajService;
import com.tim15.sluzbenik.service.ObavestenjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
