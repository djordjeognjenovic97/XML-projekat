package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.ListaZahtevaDTO;
import com.tim15.sluzbenik.dto.QueryZahtevDTO;
import com.tim15.sluzbenik.dto.ZahtevDTO;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.service.ZahtevicirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/zahtevi", produces = MediaType.APPLICATION_XML_VALUE)
public class ZahtevicirController {
    @Autowired
    private ZahtevicirService zahtevicirService;

    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addText", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addZahtevText(@RequestBody String text) throws Exception {
        zahtevicirService.addZahtevFromText(text);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @PostMapping(value = "/addZahtev")
    public ResponseEntity<?> addZahtev(@Valid @RequestBody Zahtev zahtev) throws Exception {
        JaxbParser jaxbParser = new JaxbParser();
        String text = jaxbParser.marshallString(Zahtev.class,zahtev);
        zahtevicirService.addZahtevFromText(text);
        return new ResponseEntity<String>("Zahtev je dodat u exist bazu", HttpStatus.OK);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addZahtevFile(@RequestBody String path) throws Exception {
        zahtevicirService.addZahtevFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getZahtevDocument(@PathVariable String id) throws Exception {
        Document document = zahtevicirService.getZahtevDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersZahtevi",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZahtevaDTO> getZahteviUsers() throws Exception {
        List<ZahtevDTO> ids = zahtevicirService.getUsersZahtevi();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZahtevaDTO>(new ListaZahtevaDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getAllZahtevi",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZahtevaDTO> getZahteviAll() throws Exception {
        List<ZahtevDTO> ids = zahtevicirService.getAllZahtevi();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZahtevaDTO>(new ListaZahtevaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getSearchZahtevi/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZahtevaDTO> getZahteviSearch(@PathVariable String content) throws Exception {
        List<ZahtevDTO> ids = zahtevicirService.getSearchZahtevi(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZahtevaDTO>(new ListaZahtevaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @PostMapping(value = "/getSearchMetadataZahtevi",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaZahtevaDTO> getZahteviMeatadataSearch(@RequestBody QueryZahtevDTO dto) throws Exception {
        List<ZahtevDTO> ids = zahtevicirService.getSearchMetadataZahtevi(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaZahtevaDTO>(new ListaZahtevaDTO(ids), HttpStatus.OK);
    }

    @PutMapping(value = "/odbijZahtev/{id}")
    public ResponseEntity<?> odbijZahtev(@PathVariable String id) throws Exception {
        zahtevicirService.odbijZahtev(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
    public ResponseEntity<Object> getZahtevJSON(@PathVariable String id) throws Exception {

        try {
            zahtevicirService.skiniJSON(id);
            String fileName = "src/main/resources/json/"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Scheduled(cron = "${greeting.cron}")
    public void cronJob() throws Exception {
        zahtevicirService.odbaciZahtev();
    }
}
