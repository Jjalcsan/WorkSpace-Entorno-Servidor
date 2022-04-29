package com.ejemplo.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;

@SpringBootApplication
public class ProyectoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner iniDataUsu (UsuarioRepository repoUsu) {
		return (args) -> {
			repoUsu.saveAll(Arrays.asList(
					new Usuario("admin","admin", "admin", "admin@admin.com", "C/Administrador Nº1", "123456789"),
					new Usuario("juanjo123","juanjo", "Juan Jose", "jjalsn@gm.cm", "C/Espronceda Nº59", "684928406")
					));
		};
	}
	
	@Bean
	CommandLineRunner iniDataProdu (ProductoRepository repoProd) {
		return (args) -> {
			repoProd.saveAll(Arrays.asList(
					new Producto("Leche", 1.0),
					new Producto("Carne", 3.0),
					new Producto("Pizza", 4.0),
					new Producto("Gel", 5.0)));
		};
	}
	
}
