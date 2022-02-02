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

	public List<Usuario> findAll(){
		
		return repoUsu.findAll();
		
	}
	
	public Usuario findById(String nick) {
		
		return repoUsu.findById(nick).orElse(null);
		
	}
	
	public boolean existeUsuario(String nick, String contra) {
		
		boolean encontrado = false;
		Usuario usuario = findById(nick);
		
		if ( usuario != null && usuario.getNick().equals(nick) && usuario.getContra().equals(contra)) {
			
			encontrado = true;
			
		}
		
		return encontrado;
		
	}
}
