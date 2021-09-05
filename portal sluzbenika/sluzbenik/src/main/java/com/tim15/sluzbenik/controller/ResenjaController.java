package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.service.ResenjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    @GetMapping(value = "/skiniRDF/{id}")
    public ResponseEntity<Object> getZahtevRDF(@PathVariable String id) throws Exception {

        try {
            String fileName = "src/main/resources/rdf/"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/skiniJSON/{id}")
    public ResponseEntity<Object> getResenjaJSON(@PathVariable String id) throws Exception {

        try {
            resenjaService.skiniJSON(id);
            String fileName = "src/main/resources/json/"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/skiniHTML/{id}")
    public ResponseEntity<Object> getResenjaHTML(@PathVariable String id) throws Exception {

        try {
            resenjaService.skiniHTML(id);
            String fileName = "src/main/resources/html/Resenja"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/skiniPDF/{id}")
    public ResponseEntity<Object> getResenjaPDF(@PathVariable String id) throws Exception {

        try {
            resenjaService.skiniPDF(id);
            String fileName = "src/main/resources/pdf/Resenja"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/htmlOblik/{id}")
    public ResponseEntity<Object> seeResenjaHTML(@PathVariable String id) throws Exception {

        try {
            String tekst=resenjaService.skiniHTML(id);
            return new ResponseEntity<Object>(tekst, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
