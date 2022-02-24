package com.ejemplo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.model.Post;
import com.ejemplo.demo.model.User;
import com.ejemplo.demo.repository.PostRepo;
import com.ejemplo.demo.repository.UserRepo;

@RestController
public class SocialController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@GetMapping("/user")
	public User getUserDetails(){
		
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findByEmail(email).get();
		
	}
	
	@GetMapping("/registrados")
	public List<User> registrados() {
		
		return userRepo.findAll();
		
	}
	
	@GetMapping("/{userID}/posts")
	public List<Post> getPosts(@PathVariable int userID){
		
		List<Post> posts = new ArrayList<>();
		List<Post> global = postRepo.findAll();
		
		for (Post p : global) {
			if(p.getUsuario().getId() == userID){
				
				posts.add(p);
				
			}
		}
		
		return posts;
		
	}
	
	/*@PostMapping("/{userID}/newPost")
	public Post newPost(@PathVariable int userID, @RequestBody Post post) {
		
		User user = userRepo.findById(userID).orElse(getUserDetails());
		
	}*/
	
}
