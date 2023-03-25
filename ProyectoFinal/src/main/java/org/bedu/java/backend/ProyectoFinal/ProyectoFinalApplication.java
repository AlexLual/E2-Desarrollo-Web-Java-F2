package org.bedu.java.backend.ProyectoFinal;

import org.bedu.java.backend.ProyectoFinal.model.Persona;
import org.bedu.java.backend.ProyectoFinal.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

@Autowired
private PersonaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		/*Persona persona1 = new Persona("Luis Alejandro","Hernandez Duran","5617068191");
		repository.save(persona1); Esto solo se hizo para comprobar que se conecto a la base de datos y se creo la tabla */



	}
}
