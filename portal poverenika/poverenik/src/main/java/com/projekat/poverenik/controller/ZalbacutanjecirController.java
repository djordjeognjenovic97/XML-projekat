package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.ListaZalbacutanjeDTO;
import com.projekat.poverenik.dto.QueryZalbacutanjeDTO;
import com.projekat.poverenik.dto.ZalbacutanjeDTO;
import com.projekat.poverenik.service.ZalbacutanjecirService;
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
@RequestMapping(value = "api/zalbecutanje", produces = "application/xml; charset=UTF-8")
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

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeUsers() throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getUsersZalbecutanje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getAllZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeAll() throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getAllZalbecutanje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getSearchZalbecutanje/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeSearch(@PathVariable String content) throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getSearchZalbecutanje(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @PostMapping(value = "/getSearchMetadataZalbecutanje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZalbacutanjeDTO> getZalbecutanjeMeatadataSearch(@RequestBody QueryZalbacutanjeDTO dto) throws Exception {
        List<ZalbacutanjeDTO> ids = zalbacutanjecirService.getSearchMetadataZalbecutanje(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZalbacutanjeDTO>(new ListaZalbacutanjeDTO(ids), HttpStatus.OK);
    }

    @GetMapping(value = "/downloadRDF/{id}")
    public ResponseEntity<Object> getZalbacutanjeRDF(@PathVariable String id) throws Exception {

        try {
            String fileName = "src/main/resources/rdf/zalbac"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadJSON/{id}")
    public ResponseEntity<Object> getZalbacutanjeJSON(@PathVariable String id) throws Exception {

        try {
            zalbacutanjecirService.downloadJSON(id);
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
    public ResponseEntity<Object> getZalbacutanjeHTML(@PathVariable String id) throws Exception {

        try {
            zalbacutanjecirService.downloadHTML(id);
            String fileName = "src/main/resources/html/Zalbacutanje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadPDF/{id}")
    public ResponseEntity<Object> getZalbacutanjePDF(@PathVariable String id) throws Exception {

        try {
            zalbacutanjecirService.downloadPDF(id);
            String fileName = "src/main/resources/pdf/Zalbacutanje"+id;
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
            String tekst=zalbacutanjecirService.downloadHTML(id);
            return new ResponseEntity<Object>(tekst, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
