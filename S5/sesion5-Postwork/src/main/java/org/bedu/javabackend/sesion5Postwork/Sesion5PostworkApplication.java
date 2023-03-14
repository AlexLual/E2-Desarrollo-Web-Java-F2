package org.bedu.javabackend.sesion5Postwork;

import org.bedu.javabackend.sesion5Postwork.model.Persona;
import org.bedu.javabackend.sesion5Postwork.service.FormatoService;
import org.bedu.javabackend.sesion5Postwork.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Sesion5PostworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sesion5PostworkApplication.class, args);
	}

	private final PhoneService phoneService;
	private final FormatoService formatoService;

	@Autowired
	public Sesion5PostworkApplication (PhoneService phoneService, FormatoService formatoService) {
		this.phoneService = phoneService;
		this.formatoService = formatoService;
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);

		System.out.println("Introduce el nombre: ");
		String name = reader.nextLine();

		System.out.println("Introduce el teléfono: ");
		String phone = reader.nextLine();

		if (phoneService.isValido(phone)) {
			String telefonoNumerico = phoneService.validarTelefono(phone);
			String telefonoFormateado = formatoService.darFormatoTelefonico(telefonoNumerico);

			Persona persona = new Persona(name, phone);
			System.out.println(persona);
		} else {
			System.out.println("Introduzca un número válido");
		}
	}

}
