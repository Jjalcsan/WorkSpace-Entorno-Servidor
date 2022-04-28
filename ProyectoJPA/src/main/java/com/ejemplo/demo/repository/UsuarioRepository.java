package com.ejemplo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.demo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
}