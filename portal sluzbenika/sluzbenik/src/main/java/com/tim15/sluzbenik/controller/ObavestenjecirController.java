package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.service.ObavestenjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/obavestenja", produces = MediaType.APPLICATION_JSON_VALUE)
public class ObavestenjecirController {
    @Autowired
    private ObavestenjecirService obavestenjecirService;

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @PostMapping(value = "/addObavestenje")
    public ResponseEntity<?> addObavestenje(@Valid @RequestBody Obavestenje obavestenje) throws Exception {
        JaxbParser jaxbParser = new JaxbParser();
        String text = jaxbParser.marshallString(Obavestenje.class,obavestenje);
        obavestenjecirService.addObavestenjeFromText(text);
        return new ResponseEntity<String>("Obavestenje je dodato u exist bazu", HttpStatus.OK);
    }

    @PostMapping(value = "/addText", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addObavestenjeText(@RequestBody String text) throws Exception {
        obavestenjecirService.addObavestenjeFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addObavestenjeFile(@RequestBody String path) throws Exception {
        obavestenjecirService.addObavestenjeFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getObavestenjeDocument(@PathVariable String id) throws Exception {
        Document document = obavestenjecirService.getObavestenjeDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @GetMapping(value = "/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getObavestenjeAsHTML(@PathVariable String id) throws Exception {
        String document = obavestenjecirService.convertXMLtoHTML(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @GetMapping(value = "/pdf/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Object> getPdf(@PathVariable("id") String id) throws Exception {
        Resource resource = obavestenjecirService.getPdf(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
