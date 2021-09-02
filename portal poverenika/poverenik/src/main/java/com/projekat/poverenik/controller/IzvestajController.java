package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.IzvestajDTO;
import com.projekat.poverenik.dto.ListaIzvestajaDTO;
import com.projekat.poverenik.model.izvestaji.Izvestaj;
import com.projekat.poverenik.service.IzvestajService;
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
@RequestMapping(value = "api/izvestaji", produces = MediaType.APPLICATION_XML_VALUE)
public class IzvestajController {
    @Autowired
    private IzvestajService izvestajService;

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getAllIzvestaji",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaIzvestajaDTO> getIzvestajiAll() throws Exception {
        List<IzvestajDTO> ids = izvestajService.getAllIzvestaji();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaIzvestajaDTO>(new ListaIzvestajaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getSearchIzvestaji/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaIzvestajaDTO> getIzvestajiSearch(@PathVariable String content) throws Exception {
        List<IzvestajDTO> ids = izvestajService.getSearchIzvestaji(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaIzvestajaDTO>(new ListaIzvestajaDTO(ids), HttpStatus.OK);
    }
}
