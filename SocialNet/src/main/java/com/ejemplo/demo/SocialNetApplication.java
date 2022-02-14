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
					new Usuario("admin", "admin", "admin", "istrador", "123456789", "admin@admin.com", "C/Administrados Nº1", 30)));
		};
	}

}
