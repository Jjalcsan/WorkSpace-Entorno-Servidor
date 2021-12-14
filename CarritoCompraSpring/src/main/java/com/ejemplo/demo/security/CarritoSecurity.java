package com.ejemplo.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CarritoSecurity extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.formLogin()
				.loginPage("/inicio.html")
				.loginProcessingUrl("/inicio.html")
				.defaultSuccessUrl("/inicioUsuario.html", true)
				.failureUrl("/inicio.html?error=true");
			
	}

	
	
}
