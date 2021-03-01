package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.service.ZalbacutanjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

@RestController
@RequestMapping(value = "api/zalbecutanje", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZalbacutanjecirController {
    @Autowired
    private ZalbacutanjecirService zalbacutanjecirService;

    @PostMapping(value = "/addText", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZalbacutanjeText(@RequestBody String text) throws Exception {
        zalbacutanjecirService.addZalbacutanjeFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
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
