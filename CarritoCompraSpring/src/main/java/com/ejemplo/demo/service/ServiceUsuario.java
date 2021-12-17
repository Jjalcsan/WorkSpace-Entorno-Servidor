package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

@Service
public class ServiceUsuario {

	private List<Usuario> registrados = new ArrayList<>();

	/**
	 * Añade a la lista de usuarios dos usuarios para el testeo de la aplicacion
	 */
	@PostConstruct
	public void init() {
		
		registrados.add(new Usuario("admin", "admin", "admin", "admin@dominio.com", "123456789", "C Generica Nº1"));
		registrados.add(new Usuario("usuario123", "pepito", "usuusu", "unUsu@dominio.ar", "123456789", "C Cas Nº2"));
	
	}
	
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
	 * Metodo que nos devuelve todos los usuarios
	 * @return
	 */
	public List<Usuario> getAllUsuarios() {
		
		return registrados;
		
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
	 * Metodo para añadir un nuevo pedido a la lista de pedidos de un usuario
	 * @param usuario
	 * @param productos
	 * @param metodoEnvio
	 */
	public void addPedido(Usuario usuario, Map<Producto, Integer> productos, String metodoEnvio) {
		
		Pedido pedido = new Pedido(productos, metodoEnvio);

		pedido.setMetodoEnvio(metodoEnvio);
		
		usuario.getPedidos().add(0, pedido);
		
	}

	/**
	 * Metodo que nos devuelve la lista de pedidos de un usuario
	 * @param usuario
	 * @return
	 */
	public List<Pedido> getAllPedidos(Usuario usuario) {
		
		return usuario.getPedidos();
		
	}
	

	/**
	 * Buscamos el pedido de un usuario por su id
	 * @param id
	 * @param usuario
	 * @return
	 */
	public Pedido getPedidoById(int id, Usuario usuario) {
		
		Pedido pedido = new Pedido(id);
		
		for(int i=0; i<usuario.getPedidos().size(); i++) {
			if(usuario.getPedidos().get(i).getId() == (pedido.getId())) {
				
				pedido = usuario.getPedidos().get(i);
				
			}
		}
		
		return pedido;
		
	}

	
	/**
	 * Metodo para borrar uno de los pedidos asociados a un usuario
	 * @param pedido
	 * @param usuario
	 */
	public void delPedido(Pedido pedido, Usuario usuario) {
		
		usuario.getPedidos().remove(pedido);
		
	}
	
}