package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.model.Pedido;

@Service
public class ServiceUsuario {

	private List<Usuario> registrados = new ArrayList<>();
	
	/**
	 * 
	 * @param nick
	 * @return
	 */
	public Usuario getByNick(String nick) {
		
		Usuario buscado = null;
		
		for (Usuario u : registrados) {
			
			if(u.getNick().equalsIgnoreCase(nick)) {
				buscado=u;
			}
		}
		
		return buscado;
	}
	
	
	public void login() {}
	
	/**
	 * 
	 * @param u
	 * @param p
	 */
	public void addPedido(Usuario u, Pedido p) {
		
		u.getPedidos().add(p);
		
	}
	
	
	/**
	 * 
	 * @param u
	 */
	public ArrayList<Pedido> getAllPedidos(Usuario u) {
		
		return u.getPedidos();
		
	}
	
	/**
	 * 
	 * @param u
	 * @param id
	 * @return
	 */
	public Pedido getPedidoById(Usuario u, int id){
		
		Pedido buscado = null;
		
		for (Pedido p : u.getPedidos()) {
			
			if(p.getId()==id) {
				buscado=p;
				
			}
		}
		
		return buscado;
	}
	
	/**
	 * 
	 * @param u
	 * @param id
	 */
	public void removePedido(Usuario u, int id) {
		
		for (Pedido p : u.getPedidos()) {
			if(p.getId()==id) {
				u.getPedidos().remove(p);
			}
		}
	}
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		
		registrados.add(new Usuario("admin", "admin", "admin@administrador.es", "123456789", "C Dir Nº1", "admin"));
		registrados.add(new Usuario("usuario123", "pepito", "unUsu@dominio.ar", "123456789", "C Cas Nº2", "usuusu"));

	}
	
	
	
}
