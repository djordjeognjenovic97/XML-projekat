package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.*;
import com.tim15.sluzbenik.jaxb.JaxbParser;
import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;
import com.tim15.sluzbenik.service.ObavestenjecirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(value = "api/obavestenja", produces = MediaType.APPLICATION_XML_VALUE)
public class ObavestenjecirController {
    @Autowired
    private ObavestenjecirService obavestenjecirService;

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @PostMapping(value = "/addObavestenje")
    public ResponseEntity<?> addObavestenje(@Valid @RequestBody Obavestenje obavestenje) throws Exception {
        JaxbParser jaxbParser = new JaxbParser();
        String text = jaxbParser.marshallString(Obavestenje.class,obavestenje);
        obavestenjecirService.addObavestenjeFromText(text);
        return new ResponseEntity<String>("Obavestenje je dodato u exist bazu", HttpStatus.OK);
    }

    @PostMapping(value = "/addText",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addObavestenjeText(@RequestBody String text) throws Exception {
        //TREBA IZMENITI ZAHTEV-PRIHVACEN, POSLATI MAIL GRADJANINU ISTO
        obavestenjecirService.addObavestenjeFromText(text);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/addFile", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> addObavestenjeFile(@RequestBody String path) throws Exception {
        obavestenjecirService.addObavestenjeFromFile(path);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }

    @GetMapping(value = "/getDocument/{id}")
    public ResponseEntity<Document> getObavestenjeDocument(@PathVariable String id) throws Exception {
        Document document = obavestenjecirService.getObavestenjeDocument(id);
        if(document == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_GRADJANIN')")
    @GetMapping(value = "/getUsersObavestenja",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaObavestenjaDTO> getObavestenjaUsers() throws Exception {
        List<ObavestenjeDTO> ids = obavestenjecirService.getUsersObavestenja();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaObavestenjaDTO>(new ListaObavestenjaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getAllObavestenja",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaObavestenjaDTO> getObavestenjaAll() throws Exception {
        List<ObavestenjeDTO> ids = obavestenjecirService.getAllObavestenja();
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaObavestenjaDTO>(new ListaObavestenjaDTO(ids), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @GetMapping(value = "/getSearchObavestenja/{content}",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaObavestenjaDTO> getObavestenjaSearch(@PathVariable String content) throws Exception {
        List<ObavestenjeDTO> ids = obavestenjecirService.getSearchObavestenja(content);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaObavestenjaDTO>(new ListaObavestenjaDTO(ids), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_SLUZBENIK')")
    @PostMapping(value = "/getSearchMetadataObavestenja",consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ListaObavestenjaDTO> getObavestenjaMeatadataSearch(@RequestBody QueryObavestenjeDTO dto) throws Exception {
        List<ObavestenjeDTO> ids = obavestenjecirService.getSearchMetadataObavestenja(dto);
        if(ids == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ListaObavestenjaDTO>(new ListaObavestenjaDTO(ids), HttpStatus.OK);
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
    public ResponseEntity<Object> getObavestenjeJSON(@PathVariable String id) throws Exception {

        try {
            obavestenjecirService.skiniJSON(id);
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
    public ResponseEntity<Object> getObavestenjeHTML(@PathVariable String id) throws Exception {

        try {
            obavestenjecirService.skiniHTML(id);
            String fileName = "src/main/resources/html/Obavestenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/skiniPDF/{id}")
    public ResponseEntity<Object> getObavestenjePDF(@PathVariable String id) throws Exception {

        try {
            obavestenjecirService.skiniPDF(id);
            String fileName = "src/main/resources/pdf/Obavestenje"+id;
            Path filePath = Paths.get(fileName);
            byte[] data = Files.readAllBytes(filePath);
            return new ResponseEntity<Object>(data, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/htmlOblik/{id}")
    public ResponseEntity<Object> seeObavestenjeHTML(@PathVariable String id) throws Exception {

        try {
            String tekst=obavestenjecirService.skiniHTML(id);
            return new ResponseEntity<Object>(tekst, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
