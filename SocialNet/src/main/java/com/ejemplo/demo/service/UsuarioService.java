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
	
	public Usuario existeUsuario(String email, String contra) {
		
		Usuario usu = null;
		List<Usuario> findall = findAll();
		for(Usuario u : findall) {
			if(u.getEmail().equals(email) && u.getContra().equals(contra)) {
				usu = u;
			}
		}
		
		return usu;
		
	}
	
	public Usuario editUsu(Usuario usu) {
		
		Usuario usuAux = repoUsu.findById(usu.getId()).orElse(null);
		repoUsu.delete(usuAux);
		usuAux.setApellidos(usu.getApellidos());
		usuAux.setContra(usu.getContra());
		usuAux.setDireccion(usu.getDireccion());
		usuAux.setEmail(usu.getEmail());
		usuAux.setNick(usu.getNick());
		usuAux.setImagenPerf(usuAux.getImagenPerf());
		usuAux.setNombre(usu.getNombre());
		usuAux.setNombre(usu.getNombre());
		usuAux.setTelefono(usu.getTelefono());
		repoUsu.save(usuAux);
		
		return usuAux;
	}
	
}
