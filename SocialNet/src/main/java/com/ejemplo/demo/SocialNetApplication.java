package com.ejemplo.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;

@SpringBootApplication
public class SocialNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initU (UsuarioRepository repoUsu) {
		
		return(args) -> {
			repoUsu.saveAll(Arrays.asList(
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen"),
					new Usuario("nick", "contra", "nombre", "apellidos", "telefono", "email", "direccion", "imagen")));
		};
	}

}
