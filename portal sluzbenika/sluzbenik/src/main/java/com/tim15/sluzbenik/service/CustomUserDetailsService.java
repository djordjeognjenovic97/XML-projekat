package com.tim15.sluzbenik.service;

import com.tim15.sluzbenik.model.korisnici.Korisnik;
import com.tim15.sluzbenik.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Ovaj servis je namerno izdvojen kao poseban u ovom primeru.
// U opstem slucaju UserServiceImpl klasa bi mogla da implementira UserDetailService interfejs.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ako se ne radi nasledjivanje, paziti gde sve treba da se proveri email
        Korisnik user = null;
        try {
            user = userRepository.findByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
            return user;
        }
    }

    // Funkcija pomocu koje korisnik menja svoju lozinku
    public void changePassword(String oldPassword, String newPassword) throws Exception {

        // Ocitavamo trenutno ulogovanog korisnika
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((Korisnik) currentUser.getPrincipal()).getEmail();

        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            return;
        }
        Korisnik user = (Korisnik) loadUserByUsername(username);

        // pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
        // ne zelimo da u bazi cuvamo lozinke u plain text formatu
        user.setLozinka(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    public Korisnik findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email);
    }

    public Korisnik create(Korisnik userRequest) throws Exception {
        Korisnik user=userRepository.findByEmail(userRequest.getEmail());
        if(user!=null){
            throw new Exception("Ne moze ovaj email.");
        }
        userRequest.setLozinka(passwordEncoder.encode(userRequest.getLozinka()));
        userRepository.save(userRequest);
        return  userRequest;
    }

    public void initialize(String path) throws Exception {
        userRepository.initialize(path, "korisnici.xml");
    }
}
