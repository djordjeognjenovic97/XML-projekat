package com.projekat.poverenik.controller;

import com.projekat.poverenik.service.ResenjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

@RestController
@RequestMapping(value = "api/resenja", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResenjaController {
    @Autowired
    private ResenjaService resenjaService;

    @PostMapping(value = "/addText", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addResenjeText(@RequestBody String text) throws Exception {
        resenjaService.addResenjeFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addResenjeFile(@RequestBody String path) throws Exception {
        resenjaService.addResenjeFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getResenjeDocument(@PathVariable String id) throws Exception {
        Document document = resenjaService.getResenjeDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
}
