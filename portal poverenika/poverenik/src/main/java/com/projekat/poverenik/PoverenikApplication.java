package com.projekat.poverenik;

import com.projekat.poverenik.service.CustomUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PoverenikApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext appContext=SpringApplication.run(PoverenikApplication.class, args);

		CustomUserDetailsService cuds=appContext.getBean(CustomUserDetailsService.class);
		cuds.initialize("src/main/resources/korisnici.xml");
	}

}
