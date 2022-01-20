package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository repoUsu;

	private List<Usuario> registrados = new ArrayList<>();
	
	/**
	 * Metodo booleano para comprobar si existe un usuario por su nick y contraseña para la validacion del login
	 * @param nick
	 * @param contra
	 * @return nos devolvera true si existe o false en caso contrario
	 */
	public boolean existeUsuario(String nick, String contra) {
		
		boolean encontrado = false;
		int i = 0;
		
		while (!encontrado && i<registrados.size()) {
			if(registrados.get(i).getNick().equals(nick) && registrados.get(i).getContra().equals(contra)){
				
				encontrado = true;
				
			}else {i++;}
		}
		
		return encontrado;
		
	}
	
	/**
	 * Metodo para buscar un usuario por su nick, ya que este es unico lo podemos utilizar como id para los usuarios
	 * aunque en la practica real esto no sea eficiente
	 * @param nick
	 * @return nos devolvera el usuario si lo encuentra o null en caso contrario
	 */
	public Usuario getByNick(String nick) {
		
		Usuario usuEncontrado = null;
		boolean encontrado = false;
		int i = 0;
		
		while(!encontrado && i<registrados.size()) {
			if(Objects.equals(registrados.get(i).getNick(), nick)) {
				
				encontrado = true;
				usuEncontrado = registrados.get(i);
				
			}else {i++;}
		}
		
		return usuEncontrado;
	}
	
	/**
	 * Metodo que nos devuelve todos los usuarios
	 * @return
	 */
	public List<Usuario> getAllUsuarios() {
		
		return repoUsu.findAll();
		
	}

	
}