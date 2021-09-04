package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.IzjasnjenjeDTO;
import com.projekat.poverenik.service.IzjasnjenjeService;
import com.projekat.poverenik.soap.izjasnjenje.Izjasnjenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/izjasnjenje", produces = MediaType.APPLICATION_XML_VALUE)
public class IzjasnjenjeController {

    @Autowired
    IzjasnjenjeService izjasnjenjeService;

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/traziIzjasnjenje/{tip}/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> traziIzjasnjenje(@PathVariable String tip,@PathVariable String id) throws Exception {
        //promjeniti status zalbe i poslati preko soap zahtev za izjasnjnjem
        izjasnjenjeService.traziIzjasnjenje(tip,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/pogledajIzjasnjenje/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IzjasnjenjeDTO> pogledajIzjasnjenje(@PathVariable String id) throws Exception {
        //pretrazi izjasnjenje iz exist baze poruka
        IzjasnjenjeDTO izjasnjenjeDTO=izjasnjenjeService.pogledajIzjasnjenje(id);
        return new ResponseEntity<IzjasnjenjeDTO>(izjasnjenjeDTO,HttpStatus.OK);
    }
}
