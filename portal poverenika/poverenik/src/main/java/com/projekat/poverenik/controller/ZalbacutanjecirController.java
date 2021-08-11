package com.projekat.poverenik.controller;

import com.projekat.poverenik.service.ZalbacutanjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

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
}
