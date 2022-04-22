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
	
	/**
	 * Busca todos los usuarios de la BBDD
	 * @return Nos devuelve la lista de usuarios
	 */
	public List<Usuario> findAll() {
		
		return repoUsu.findAll();
		
	}
	
	/**
	 * Busca un pedido por su nick que le pasamos por parametros
	 * @param nick
	 * @return Nos devuelve el usuario buscado o null si no lo encuentra
	 */
	public Usuario findById(String nick) {
		
		return repoUsu.findById(nick).orElse(null);
		
	}
	
	public boolean loginUsuario(String nick, String pass) {
		
		List<Usuario> registrado = findAll();
		boolean encontrado = false;
		int contador = 0;
		
		while(!encontrado && contador<registrado.size()) {
			
			Usuario usuTemp = registrado.get(contador);
			
			if (nick.equals(usuTemp.getNick()) && pass.equals(usuTemp.getContra())) {
				
				encontrado = true;
				
			} else { contador++; }
			
		}
		
		return encontrado;
		
	}

}
