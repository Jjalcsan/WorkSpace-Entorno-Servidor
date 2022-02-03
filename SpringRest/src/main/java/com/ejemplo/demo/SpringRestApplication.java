package com.ejemplo.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.ProductoRepository;
import com.ejemplo.demo.repository.UsuarioRepository;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	
	@Bean
	CommandLineRunner initU (UsuarioRepository repoUsu) {
		
		return (args) -> {
			repoUsu.saveAll(Arrays.asList(
					new Usuario("admin", "admin", "admin", "admin@dominio.com", "123456789", "C Generica Nº1"),
					new Usuario("usuario123", "pepito", "usuusu", "unUsu@dominio.ar", "123456789", "C Cas Nº2")));
		};
		
	}
	
	@Bean
	CommandLineRunner initP (ProductoRepository repoProd) {
		return (args) -> {
			repoProd.saveAll(Arrays.asList(
					new Producto("Leche", 1.5),
					new Producto("Huevos", 2.0),
					new Producto("Cereales", 2.5),
					new Producto("Carne", 3.0),
					new Producto("Pescado", 3.5),
					new Producto("Pizza", 4.0)));
		};
	}
}
