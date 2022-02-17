package com.ejemplo.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ejemplo.demo.model.User;
import com.ejemplo.demo.repository.UserRepo;

@SpringBootApplication
public class SocialNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initU (UserRepo repoUsu) {
		
		return(args) -> {
			repoUsu.saveAll(Arrays.asList(
				  //new User(nick,  password, name,     surname,   phoneNumber,  email           , address,              age)
					new User("admin", "admin", "admin", "istrador", "123456789", "admin@admin.com", "C/Administrados Nº1", 30),
					new User("jjalcsan", "contra1", "Juan Jose", "Alcazar", "123456789", "jjalcsan@gmail.com", "C/JuanJo Nº80", 25)));
		};
		
	}

}
