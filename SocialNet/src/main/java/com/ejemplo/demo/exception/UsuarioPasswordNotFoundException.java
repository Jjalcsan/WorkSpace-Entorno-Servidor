package com.ejemplo.demo.exception;

public class UsuarioPasswordNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2247316770610041628L;

	public UsuarioPasswordNotFoundException() {
		
		super("La contraseña no es correcta");
		
	}

}
