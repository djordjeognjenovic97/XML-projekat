package com.tim15.sluzbenik.controller;

import com.tim15.sluzbenik.dto.UserLoginDTO;
import com.tim15.sluzbenik.dto.UserTokenStateDTO;
import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.security.TokenUtils;
import com.tim15.sluzbenik.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_XML_VALUE)
public class AuthenticationController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    @PostMapping("/log-in")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody UserLoginDTO authenticationRequest,
                                                       HttpServletResponse response) throws InterruptedException {

        /*RegistrovaniKorisnik k=rkService.findByEmail(authenticationRequest.getUsername());
        if(k!=null) {
            System.out.println(k.getEnabled());
            if (!k.isEnabled()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }*/

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //Thread.sleep(3000);
        /*
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        Korisnik u=(Korisnik)auth.getPrincipal();
        */

        // Kreiraj token za tog korisnika
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail(),user.getUloga()); // prijavljujemo se na sistem sa email adresom
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenStateDTO(jwt, expiresIn));
    }

    // Endpoint za registraciju novog korisnika
    @PostMapping("/sign-up")
    public ResponseEntity<?> addUser(@Valid @RequestBody Korisnik userRequest) throws Exception {
        Korisnik existUser = this.userDetailsService.findByEmail(userRequest.getEmail());
        if (existUser != null) {
            throw new Exception("Korisnik sa ovim e-mailom vec postoji.");
        }
        /*
        existUser = this.rkService.findByKorisnickoIme(userRequest.getKorisnickoIme());
        if (existUser != null) {
            throw new Exception("Username already exists");
        }*/
        Korisnik newUser;
        try {
            //RegistrovaniKorisnikDTO a=new RegistrovaniKorisnikDTO(userRequest);
            newUser =  this.userDetailsService.create(userRequest);
            //emailService.confirmRegistration(existUser);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
