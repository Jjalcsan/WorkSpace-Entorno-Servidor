package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.model.Pais;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.PaisService;
import com.ejemplo.demo.service.UsuarioService;

@RestController
public class PaginaController {
	
	@Autowired
	private UsuarioService serviceUsu;
	
	@Autowired
	private PaisService servicePais;

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable int id) throws Exception{
		
		Usuario usuario = serviceUsu.findById(id);
		ResponseEntity<Usuario> findbyid = ResponseEntity.notFound().build();
		
		if(usuario != null) {
			
			findbyid = ResponseEntity.ok(usuario);
			
		} else {
			
			findbyid = null;
			//En el caso de que no exista ese usuario lanzará la excepcion propia
			
		}
		
		return findbyid;
		
	}
	
	@GetMapping("/paises")
	public ResponseEntity<List<Pais>> findAll() {
		
		List<Pais> paises = servicePais.findAll();
		ResponseEntity<List<Pais>> findall = ResponseEntity.ok(paises);
		
		if(paises == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
}
