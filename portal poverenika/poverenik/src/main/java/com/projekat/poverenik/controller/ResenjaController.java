package com.projekat.poverenik.controller;

import com.projekat.poverenik.dto.ListaResenjeDTO;
import com.projekat.poverenik.dto.QueryResenjeDTO;
import com.projekat.poverenik.dto.ResenjeDTO;
import com.projekat.poverenik.service.ResenjaService;
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
@RequestMapping(value = "api/resenja", produces = "application/xml; charset=UTF-8")
public class ResenjaController {
    @Autowired
    private ResenjaService resenjaService;

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @PostMapping(value = "/addText", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> addResenjeText(@RequestBody String text) throws Exception {
        resenjaService.addResenjeFromText(text);
        return new ResponseEntity<String>(HttpStatus.CREATED);
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

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersResenje",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeUsers() throws Exception {
        List<ResenjeDTO> ids = resenjaService.getUsersResenje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getAllResenje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeAll() throws Exception {
        List<ResenjeDTO> ids = resenjaService.getAllResenje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @GetMapping(value = "/getSearchResenje/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeSearch(@PathVariable String content) throws Exception {
        List<ResenjeDTO> ids = resenjaService.getSearchResenje(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_POVERENIK')")
    @PostMapping(value = "/getSearchMetadataResenje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeMeatadataSearch(@RequestBody QueryResenjeDTO dto) throws Exception {
        List<ResenjeDTO> ids = resenjaService.getSearchMetadataResenje(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @GetMapping(value = "/downloadRDF/{id}")
    public ResponseEntity<Object> getResenjeRDF(@PathVariable String id) throws Exception {

        try {
            String fileName = "src/main/resources/rdf/resenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadJSON/{id}")
    public ResponseEntity<Object> getResenjeJSON(@PathVariable String id) throws Exception {

        try {
            resenjaService.downloadJSON(id);
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
    public ResponseEntity<Object> getResenjeHTML(@PathVariable String id) throws Exception {

        try {
            resenjaService.downloadHTML(id);
            String fileName = "src/main/resources/html/Resenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/downloadPDF/{id}")
    public ResponseEntity<Object> getResenjePDF(@PathVariable String id) throws Exception {

        try {
            resenjaService.downloadPDF(id);
            String fileName = "src/main/resources/pdf/Resenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
