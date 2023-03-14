package org.bedu.javabackend.sesion4Postwork;

import org.bedu.javabackend.sesion4Postwork.model.Persona;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Sesion4PostworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sesion4PostworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);

		System.out.println("Introduce el nombre: ");
		String name = reader.nextLine();

		System.out.println("Introduce el teléfono: ");
		String phone = reader.nextLine();

		Persona persona = new Persona(name, phone);

		System.out.println(persona);
	}

}

