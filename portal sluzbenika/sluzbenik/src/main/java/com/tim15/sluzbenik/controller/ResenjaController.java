package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.ListaResenjeDTO;
import com.tim15.sluzbenik.dto.QueryResenjeDTO;
import com.tim15.sluzbenik.dto.ResenjeDTO;
import com.tim15.sluzbenik.service.ResenjaService;
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
@RequestMapping(value = "api/resenja", produces={"application/xml; charset=UTF-8"})
public class ResenjaController {
    @Autowired
    private ResenjaService resenjaService;

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getResenjeDocument(@PathVariable String id) throws Exception {
        Document document = resenjaService.getResenjeDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
    @GetMapping(value = "/skiniRDF/{id}")
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
    @GetMapping(value = "/skiniJSON/{id}")
    public ResponseEntity<Object> getResenjeJSON(@PathVariable String id) throws Exception {

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
    public ResponseEntity<Object> getResenjeHTML(@PathVariable String id) throws Exception {

        try {
            resenjaService.skiniHTML(id);
            String fileName = "src/main/resources/html/Resenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/skiniPDF/{id}")
    public ResponseEntity<Object> getResenjePDF(@PathVariable String id) throws Exception {

        try {
            resenjaService.skiniPDF(id);
            String fileName = "src/main/resources/pdf/Resenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/htmlOblik/{id}")
    public ResponseEntity<Object> seeResenjeHTML(@PathVariable String id) throws Exception {

        try {
            String tekst=resenjaService.skiniHTML(id);
            return new ResponseEntity<Object>(tekst, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getAllResenje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeAll() throws Exception {
        List<ResenjeDTO> ids = resenjaService.getAllResenje();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getSearchResenje/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeSearch(@PathVariable String content) throws Exception {
        List<ResenjeDTO> ids = resenjaService.getSearchResenje(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @PostMapping(value = "/getSearchMetadataResenje",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaResenjeDTO> getResenjeMeatadataSearch(@RequestBody QueryResenjeDTO dto) throws Exception {
        List<ResenjeDTO> ids = resenjaService.getSearchMetadataResenje(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaResenjeDTO>(new ListaResenjeDTO(ids), HttpStatus.OK);
    }
}
