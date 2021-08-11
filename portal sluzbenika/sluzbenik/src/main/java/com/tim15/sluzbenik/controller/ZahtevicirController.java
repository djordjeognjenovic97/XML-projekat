package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.IdList;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.service.ZahtevicirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/zahtevi", produces = MediaType.APPLICATION_XML_VALUE)
public class ZahtevicirController {
    @Autowired
    private ZahtevicirService zahtevicirService;

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addText", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addZahtevText(@RequestBody String text) throws Exception {
        zahtevicirService.addZahtevFromText(text);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addZahtev")
    public ResponseEntity<?> addZahtev(@Valid @RequestBody Zahtev zahtev) throws Exception {
        JaxbParser jaxbParser = new JaxbParser();
        String text = jaxbParser.marshallString(Zahtev.class,zahtev);
        zahtevicirService.addZahtevFromText(text);
        return new ResponseEntity<String>("Zahtev je dodat u exist bazu", HttpStatus.OK);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZahtevFile(@RequestBody String path) throws Exception {
        zahtevicirService.addZahtevFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getZahtevDocument(@PathVariable String id) throws Exception {
        Document document = zahtevicirService.getZahtevDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersZahtevi",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IdList> getZahteviUsers() throws Exception {
        ArrayList<String> ids = zahtevicirService.getUsersZahtevi();
        IdList idss=new IdList(ids);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<IdList>(idss, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getAllZahtevi",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<IdList> getZahteviAll() throws Exception {
        ArrayList<String> ids = zahtevicirService.getAllZahtevi();
        IdList idss=new IdList(ids);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<IdList>(idss, HttpStatus.OK);
    }

    @PutMapping(value = "/odbijZahtev/{id}")
    public ResponseEntity<?> odbijZahtev(@PathVariable String id) throws Exception {
        zahtevicirService.odbijZahtev(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
