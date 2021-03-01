package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.service.ZalbanaodlukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

@RestController
@RequestMapping(value = "api/zalbenaodluku", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZalbanaodlukuController {

    @Autowired
    private ZalbanaodlukuService zalbanaodlukuService;

    @PostMapping(value = "/addText", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZalbanaodlukuText(@RequestBody String text) throws Exception {
        zalbanaodlukuService.addZalbanaodlukuFromText(text);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZalbanaodlukuFile(@RequestBody String path) throws Exception {
        zalbanaodlukuService.addZalbanaodlukuFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable String id) throws Exception {
        Document document = zalbanaodlukuService.getDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
}
