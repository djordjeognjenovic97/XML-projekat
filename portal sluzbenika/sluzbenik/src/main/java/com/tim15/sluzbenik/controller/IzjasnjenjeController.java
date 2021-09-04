package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.ListaIzjasnjenjaDTO;
import com.tim15.sluzbenik.dto.ListaZahtevaDTO;
import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.service.IzjasnjenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/izjasnjenje", produces = MediaType.APPLICATION_XML_VALUE)
public class IzjasnjenjeController {

    @Autowired
    IzjasnjenjeService izjasnjenjeService;

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/izjasniSe/{sadrzaj}/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> traziIzjasnjenje(@PathVariable String sadrzaj, @PathVariable String id) throws Exception {
        izjasnjenjeService.izjasniSe(sadrzaj,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/pogledajIzjasnjenja",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaIzjasnjenjaDTO> getIzjasnjenja() throws Exception {
        List<String> ids = izjasnjenjeService.getIzjasnjenja();
        if (ids == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaIzjasnjenjaDTO>(new ListaIzjasnjenjaDTO(ids), HttpStatus.OK);
    }
}
