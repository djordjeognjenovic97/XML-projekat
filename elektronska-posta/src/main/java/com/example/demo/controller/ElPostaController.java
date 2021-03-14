package com.example.demo.controller;

import com.example.demo.dto.EmailDTO;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_XML_VALUE)
public class ElPostaController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/el-posta", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> initializeKorisniciDatabase(@RequestBody EmailDTO email) throws Exception {
        emailService.send(email);
        return new ResponseEntity<String>("Done", HttpStatus.OK);
    }
}
