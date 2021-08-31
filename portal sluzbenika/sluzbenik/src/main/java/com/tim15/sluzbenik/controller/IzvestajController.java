package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.ListaIzvestajaDTO;
import com.tim15.sluzbenik.dto.IzvestajDTO;
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
import java.util.List;

@RestController
@RequestMapping(value = "api/izvestaji", produces = MediaType.APPLICATION_XML_VALUE)
public class IzvestajController {
    @Autowired
    private IzvestajService izvestajService;

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/generate")
    public ResponseEntity<Izvestaj> generateIzvestaj() throws Exception {
        Izvestaj izi = izvestajService.generateIzvestaj();
        return new ResponseEntity<Izvestaj>(izi, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getAllIzvestaji",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaIzvestajaDTO> getIzvestajiAll() throws Exception {
        List<IzvestajDTO> ids = izvestajService.getAllIzvestaji();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaIzvestajaDTO>(new ListaIzvestajaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getSearchIzvestaji/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaIzvestajaDTO> getIzvestajiSearch(@PathVariable String content) throws Exception {
        List<IzvestajDTO> ids = izvestajService.getSearchIzvestaji(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaIzvestajaDTO>(new ListaIzvestajaDTO(ids), HttpStatus.OK);
    }
}
