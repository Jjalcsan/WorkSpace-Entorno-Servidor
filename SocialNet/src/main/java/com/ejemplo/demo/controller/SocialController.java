package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.model.User;
import com.ejemplo.demo.repository.UserRepo;

@RestController
public class SocialController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/user")
	public User getUserDetails(){
		
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findByEmail(email).get();
		
	}
	
	@GetMapping("/registrados")
	public List<User> registrados() {
		
		return userRepo.findAll();
		
	}
	

	
	
}
