package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.*;
import com.projekat.poverenik.service.ZalbanaodlukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "api/zalbenaodluku", produces = "application/xml; charset=UTF-8")
public class ZalbanaodlukuController {
    @Autowired
    private ZalbanaodlukuService zalbanaodlukuService;

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addText",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addZalbanaoduluText(@RequestBody String text) throws Exception {
        zalbanaodlukuService.addZalbanaodlukuFromText(text);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZalbanaodlukuFile(@RequestBody String path) throws Exception {
        zalbanaodlukuService.addZalbanaodlukuFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getZalbanaodlukuDocument(@PathVariable String id) throws Exception {
        Document document = zalbanaodlukuService.getZalbanaodlukuDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersZalbenaodluku",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbanaodlukuDTO> getZalbecutanjeUsers() throws Exception {
        List<ZalbanaodlukuDTO> ids = zalbanaodlukuService.getUsersZalbenaodluku();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbanaodlukuDTO>(new ListaZalbanaodlukuDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getAllZalbenaodluku",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbanaodlukuDTO> getZalbecutanjeAll() throws Exception {
        List<ZalbanaodlukuDTO> ids = zalbanaodlukuService.getAllZalbenaodluku();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbanaodlukuDTO>(new ListaZalbanaodlukuDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getSearchZalbenaodluku/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbanaodlukuDTO> getZalbenaodlukuSearch(@PathVariable String content) throws Exception {
        List<ZalbanaodlukuDTO> ids = zalbanaodlukuService.getSearchZalbenaodluku(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbanaodlukuDTO>(new ListaZalbanaodlukuDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @PostMapping(value = "/getSearchMetadataZalbenaodluku",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbanaodlukuDTO> getZalbenaodlukuMeatadataSearch(@RequestBody QueryZalbanaodlukuDTO dto) throws Exception {
        List<ZalbanaodlukuDTO> ids = zalbanaodlukuService.getSearchMetadataZalbenaodluku(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbanaodlukuDTO>(new ListaZalbanaodlukuDTO(ids), HttpStatus.OK);
    }

    @GetMapping(value = "/downloadRDF/{id}")
    public ResponseEntity<Object> getZalbanaodlukuRDF(@PathVariable String id) throws Exception {

        try {
            String fileName = "src/main/resources/rdf/zalbao"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadJSON/{id}")
    public ResponseEntity<Object> getZalbanaodlukuJSON(@PathVariable String id) throws Exception {

        try {
            zalbanaodlukuService.downloadJSON(id);
            String fileName = "src/main/resources/json/"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadHTML/{id}")
    public ResponseEntity<Object> getZalbanaodlukuHTML(@PathVariable String id) throws Exception {

        try {
            zalbanaodlukuService.downloadHTML(id);
            String fileName = "src/main/resources/html/Zalbanaodluku"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadPDF/{id}")
    public ResponseEntity<Object> getZalbanaodlukuPDF(@PathVariable String id) throws Exception {

        try {
            zalbanaodlukuService.downloadPDF(id);
            String fileName = "src/main/resources/pdf/Zalbanaodluku"+id;
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
            String tekst=zalbanaodlukuService.downloadHTML(id);
            return new ResponseEntity<Object>(tekst, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
