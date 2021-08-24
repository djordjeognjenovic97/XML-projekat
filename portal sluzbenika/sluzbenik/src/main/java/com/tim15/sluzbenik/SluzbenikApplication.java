package com.tim15.sluzbenik;

import com.tim15.sluzbenik.service.CustomUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SluzbenikApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext appContext=SpringApplication.run(SluzbenikApplication.class, args);

		CustomUserDetailsService cuds=appContext.getBean(CustomUserDetailsService.class);
		cuds.initialize("src/main/resources/korisnici.xml");
	}

}
