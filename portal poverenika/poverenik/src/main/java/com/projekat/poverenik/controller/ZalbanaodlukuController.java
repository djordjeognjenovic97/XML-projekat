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

import java.util.List;

@RestController
@RequestMapping(value = "api/zalbenaodluku", produces = MediaType.APPLICATION_XML_VALUE)
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

}
