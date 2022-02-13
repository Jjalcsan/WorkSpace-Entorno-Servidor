package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repoUsu;
	
	public List<Usuario> findAll() {
		
		return repoUsu.findAll();
		
	}
	
	public Usuario findById(int id) {
		
		return repoUsu.findById(id).orElse(null);
	}
	
}
