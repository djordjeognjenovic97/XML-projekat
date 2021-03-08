package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.service.ObavestenjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

@RestController
@RequestMapping(value = "api/obavestenja", produces = MediaType.APPLICATION_JSON_VALUE)
public class ObavestenjecirController {
    @Autowired
    private ObavestenjecirService obavestenjecirService;

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
}
