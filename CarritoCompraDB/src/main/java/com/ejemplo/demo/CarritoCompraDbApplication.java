package com.ejemplo.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.ProductoRepository;
import com.ejemplo.demo.repository.UsuarioRepository;

@SpringBootApplication
public class CarritoCompraDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoCompraDbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initUsers (UsuarioRepository repoUsu) {
		return (args) -> {
			repoUsu.save(
					new Usuario("admin", "admin", "admin", "admin@dominio.com", "123456789", "Calle Administrados Nº1"));
			repoUsu.save(
					new Usuario("usuario123", "pepito", "usuusu", "unUsu@dominio.ar", "123456789", "C Cas Nº2"));
		};
	}
	
	@Bean
	CommandLineRunner initProd (ProductoRepository repoProd) {
		return (args) -> {
			repoProd.save(
					new Producto("Leche", 1.5, ""));
			repoProd.save(
					new Producto("Huevos", 2.0, ""));
			repoProd.save(
					new Producto("Cereales", 2.5, ""));
			repoProd.save(
					new Producto("Carne", 3.0, ""));
			repoProd.save(
					new Producto("Pescado", 3.5, ""));
			repoProd.save(
					new Producto("Pizza", 4.0, ""));
		};
	}

}