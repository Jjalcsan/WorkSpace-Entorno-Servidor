package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repoUsu;

	
	/**
	 * Busca todos los usuarios de la BBDD
	 * @return Nos devuelve la lista de usuarios
	 */
	public List<Usuario> findAll(){
		
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

	/**
	 * Comprueba que el nick y la contraseña que le pasamos por parametros corresponden a un usuario de la BBDD
	 * @param nick
	 * @param contra
	 * @return nos devuelve un valor booleano que sera true si los parametros corresponden a un usuario y false en caso contrario
	 */
	public boolean existeUsuario(String nick, String contra) {
		
		boolean existe = false;
		int i = 0;
		
		List<Usuario> registrados = repoUsu.findAll();
		
		while (!existe && i<registrados.size()) {
			if(registrados.get(i).getNick().equals(nick) && registrados.get(i).getContra().equals(contra)){
				
				existe = true;
				
			} else {
				
				i++;
				
			}
		}
		
		return existe;
		
	}
	

	

}
