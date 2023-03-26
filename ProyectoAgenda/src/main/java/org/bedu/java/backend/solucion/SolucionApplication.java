package org.bedu.java.backend.solucion;

import org.bedu.java.backend.solucion.model.Persona;
import org.bedu.java.backend.solucion.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolucionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SolucionApplication.class, args);
    }
    @Autowired
    private PersonaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Persona persona1 = new Persona("Luis Alejandro", "(56)-1706-8191");
        repository.save(persona1);
    }
}
