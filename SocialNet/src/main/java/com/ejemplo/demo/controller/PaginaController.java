package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.model.Grupo;
import com.ejemplo.demo.model.Pais;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.GrupoService;
import com.ejemplo.demo.service.PaisService;
import com.ejemplo.demo.service.UsuarioService;

@RestController
public class PaginaController {
	
	@Autowired
	private UsuarioService serviceUsu;
	
	@Autowired
	private PaisService servicePais;
	
	@Autowired
	private GrupoService serviceGrup;

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable int id){
		
		Usuario usuario = serviceUsu.findById(id);
		ResponseEntity<Usuario> findbyid = ResponseEntity.notFound().build();
		
		if(usuario != null) {
			
			findbyid = ResponseEntity.ok(usuario);
			
		} else {
			
			findbyid = null;
			
		}
		
		return findbyid;
		
	}
	
	@GetMapping("/registrados")
	public ResponseEntity<List<Usuario>> findAllRegistrados() {
		
		List<Usuario> registrados = serviceUsu.findAll();
		ResponseEntity<List<Usuario>> findall = ResponseEntity.ok(registrados);
		
		if(registrados == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	@GetMapping("/paises")
	public ResponseEntity<List<Pais>> findAllPaises() {
		
		List<Pais> paises = servicePais.findAll();
		ResponseEntity<List<Pais>> findall = ResponseEntity.ok(paises);
		
		if(paises == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	@GetMapping("/pais/{id}")
	public ResponseEntity<Pais> findByIdPais(@PathVariable int id) {
		
		Pais pais = servicePais.findById(id);
		ResponseEntity<Pais> findbyid = ResponseEntity.notFound().build();
		
		if(pais != null) {
			
			findbyid = ResponseEntity.ok(pais);
			
		} else {
			
			findbyid = null;
			
		}
		
		return findbyid;
		
	}
	
	@PostMapping("/registro")
	public ResponseEntity<Usuario> registroUsu(@RequestBody Usuario usuario){
				
		serviceUsu.registro(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	
	}
	
	/*
	Rehacer login*/
	
	@PutMapping("/{idUsu}/update")
	public ResponseEntity<Usuario> updateUsu(@PathVariable int idUsu, @RequestBody Usuario usu){
		
		Usuario usuUpdated = serviceUsu.editUsu(usu);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuUpdated);
		
	}
	
	public ResponseEntity<List<Grupo>> findAllGrupos() {
		
		List<Grupo> grupos = serviceGrup.findAll();
		ResponseEntity<List<Grupo>> findall = ResponseEntity.ok(grupos);
		
		if(grupos == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	@GetMapping("/pais/{id}")
	public ResponseEntity<Pais> findByIdGrup(@PathVariable int id) {
		
		Pais pais = servicePais.findById(id);
		ResponseEntity<Pais> findbyid = ResponseEntity.notFound().build();
		
		if(pais != null) {
			
			findbyid = ResponseEntity.ok(pais);
			
		} else {
			
			findbyid = null;
			
		}
		
		return findbyid;
		
	}
	
	
	
}
