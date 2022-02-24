package com.ejemplo.demo.exception;

public class UsuarioEmailNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5118670609206385241L;

	public UsuarioEmailNotFoundException(String email) {
		
		super("No existe el usuario con email: "+email);
		
	}
	
}
