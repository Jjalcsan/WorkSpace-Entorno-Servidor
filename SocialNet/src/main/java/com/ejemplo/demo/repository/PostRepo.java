package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.demo.model.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	
	
}
