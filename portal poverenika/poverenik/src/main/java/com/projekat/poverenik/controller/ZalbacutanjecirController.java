package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.ListaZalbacutanjeDTO;
import com.projekat.poverenik.dto.QueryZalbacutanjeDTO;
import com.projekat.poverenik.dto.ZalbacutanjeDTO;
import com.projekat.poverenik.service.ZalbacutanjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import java.util.List;

@RestController
@RequestMapping(value = "api/zalbecutanje", produces = MediaType.APPLICATION_XML_VALUE)
public class ZalbacutanjecirController {
    @Autowired
    private ZalbacutanjecirService zalbacutanjecirService;

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addText",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addZalbacutanjeText(@RequestBody String text) throws Exception {
        zalbacutanjecirService.addZalbacutanjeFromText(text);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZalbacutanjeFile(@RequestBody String path) throws Exception {
        zalbacutanjecirService.addZalbacutanjeFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getZalbacutanjeDocument(@PathVariable String id) throws Exception {
        Document document = zalbacutanjecirService.getZalbacutanjeDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeUsers() throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getUsersZalbecutanje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getAllZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeAll() throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getAllZalbecutanje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getSearchZalbecutanje/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeSearch(@PathVariable String content) throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getSearchZalbecutanje(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @PostMapping(value = "/getSearchMetadataZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeMeatadataSearch(@RequestBody QueryZalbacutanjeDTO dto) throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getSearchMetadataZalbecutanje(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/traziIzjasnjenje/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> traziIzjasnjenje(@PathVariable String id) throws Exception {
        //promjeniti status zalbe i poslati preko soap zahtev za izjasnjnjem
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/pogledajIzjasnjenje/{id}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> pogledajIzjasnjenje(@PathVariable String id) throws Exception {
        //pretrazi izjasnjenje iz exist baze poruka
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
