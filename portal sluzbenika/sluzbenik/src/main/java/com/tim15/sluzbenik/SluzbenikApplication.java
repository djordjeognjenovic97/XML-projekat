package com.tim15.sluzbenik;

import com.tim15.sluzbenik.existdb.ExistManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SluzbenikApplication {

	public static void main(String[] args) {

		SpringApplication.run(SluzbenikApplication.class, args);
		//ovde treba kreirati kolekciju db/sluzbenik/korisnici
		// i treba ubaciti korisnici.xml(iz resources foldera korisnicii1.xml) u tu kolekciju
		/*
		ExistManager em = new ExistManager();
		try {
			em.getOrCreateCollection("/db/sluzbenik/korisnici", 0);
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
	}

}
