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
	
	public Usuario registro(Usuario usuario) {
		
		return repoUsu.save(usuario);
		
	}
	
	public boolean existeUsuario(String email, String contra) {
		
		boolean encontrado = false;
		//Usuario usuario = findById(nick);
		//Añadir iterador para buscar el usuario
		//if ( usuario != null && usuario.getNick().equals(nick) && usuario.getContra().equals(contra)) {
			
			//encontrado = true;
			
		//}
		List<Usuario> findall = findAll();
		for(Usuario u : findall) {
			if(u.getEmail().equals(email) && u.getContra().equals(contra)) {
				encontrado = true;
			}
		}
		
		return encontrado;
		
	}
	
}
