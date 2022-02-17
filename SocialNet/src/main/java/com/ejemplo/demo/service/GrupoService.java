package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Grupo;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repoGrup;
	
	public List<Grupo> findAll(){
		
		return repoGrup.findAll();
		
	}
	
	public Grupo findById(Integer id) {
		
		return repoGrup.findById(id).orElse(null);
		
	}
	
	public Grupo cambiarDescripcion(Grupo grupoAntiguo) {
		
		repoGrup.delete(grupoAntiguo);
		Grupo grup = repoGrup.findById(grupoAntiguo.getId()).orElse(null);
		grup.setDescripcion(grupoAntiguo.getDescripcion());
		repoGrup.save(grup);
		
		return grup;
		
	}
	
	public Usuario addUsuario(Usuario usuario, Integer idGrup) {
		
		Grupo grup = findById(idGrup);
		grup.getUsuarios().add(usuario);
		return usuario;
		
	}
	
	public Usuario delUsuario(Usuario usuario, Integer idGrup) {
		
		Grupo grup = findById(idGrup);
		for (Usuario u : grup.getUsuarios()) {
			if(u.getId().equals(usuario.getId())) {

				grup.getUsuarios().remove(u);
				
			}
		}
		return usuario;
	}
	
	public Grupo newGrupo(Grupo grupo) {
		
		return repoGrup.save(grupo);
		
	}
	
	public Grupo delGrupo(Integer idGrup) {
		
		Grupo grup = findById(idGrup);
		repoGrup.delete(grup);
		
		return grup;
		
	}
}
