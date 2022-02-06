package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.exception.UsuarioNotFoundException;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;

@RestController
public class LoginController {

	
	@Autowired
	private UsuarioService serviceUsu;
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de los usuarios
	
	/**
	 * Metodo de consulta para encontrar todos los usuarios registrados
	 * @return Nos devuelve la lista de usuarios
	 */
	@GetMapping("/registrados")
	public ResponseEntity<List<Usuario>> findAll() {
		
		List<Usuario> registrados = serviceUsu.findAll();
		ResponseEntity<List<Usuario>> findall = ResponseEntity.ok(registrados);
		
		if(registrados == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	/**
	 * Metodo de consulta para buscar un usuario por su ID
	 * @param id
	 * @return devuelve el usuario o una excepcion en caso contrario
	 */
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable String id) throws Exception{
		
		Usuario usuario = serviceUsu.findById(id);
		ResponseEntity<Usuario> findbyid = ResponseEntity.notFound().build();
		
		if(usuario != null) {
			
			findbyid = ResponseEntity.ok(usuario);
			
		} else {
			
			throw new UsuarioNotFoundException(id);
			//En el caso de que no exista ese usuario lanzará la excepcion propia
			
		}
		
		return findbyid;
		
	}
	
	
	
	
}
