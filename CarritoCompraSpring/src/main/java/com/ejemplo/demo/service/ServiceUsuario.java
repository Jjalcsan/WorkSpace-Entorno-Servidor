package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.model.Pedido;

@Service
public class ServiceUsuario {

	private List<Usuario> registrados = new ArrayList<>();
	
	/**
	 * 
	 * @param Le pasamos al método como parametro un string que tendra el nick que se quiera buscar
	 * @return Si lo encuentra nos devolverá la información del usuario buscado
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
	
	/**
	 * 
	 * @param nick
	 * @param nombre
	 * @param email
	 * @param tlfn
	 * @param direccion
	 * @param contra
	 */
	public void addUsuario(@NotEmpty String nick, @NotEmpty String nombre, @Email String email, String tlfn,
			@NotEmpty String direccion, @NotEmpty String contra) {
		
		Usuario nuevo = new Usuario(nick, nombre, email, tlfn, direccion, contra);
		registrados.add(nuevo);
		
	}
	
	/**
	 * 
	 * @param nick
	 */
	public void delUsuario(String nick) {
		
		for (Usuario u : registrados) {
			if(u.getNick().equalsIgnoreCase(nick)) {
				registrados.remove(u);
			}
		}
		
	}
	
	public String listUsuarios() {
		StringBuilder sb = new StringBuilder();
		
		for (Usuario u : registrados) {
			sb.append(u.toString());
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param nick
	 * @param pass
	 * @return
	 */
	public boolean login(String nick, String pass) {
		
		boolean encontrado = false;
		
		for (Usuario u : registrados) {
			if (u.getNick().equalsIgnoreCase(nick) && u.getContra().equalsIgnoreCase(pass)) {
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	/**
	 * 
	 * @param Le pasamos como parámetro un usuario
	 * @param Tambien le pasamos el pedido que queremos asociarle
	 */
	public void addPedido(Usuario u, Pedido p) {
		
		u.getPedidos().add(p);
		
	}
	
	
	/**
	 * 
	 * @param Le pasamos como parámetro el usuario del que queremos ver la lista de pedidos
	 */
	public ArrayList<Pedido> getAllPedidos(Usuario u) {
		
		return u.getPedidos();
		
	}
	
	/**
	 * 
	 * @param Pasamos como parámetro el usuario que queremos buscar
	 * @param Le pasamos tambien el id del pedido que queremos buscar y que esté asociado al usuario
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
	 * @param Pasamos como parámetro el usuario que queremos buscar
	 * @param Le pasamos tambien el id del pedido que queremos borrar y que esté asociado al usuario
	 */
	public void removePedido(Usuario u, int id) {
		
		for (Pedido p : u.getPedidos()) {
			if(p.getId()==id) {
				u.getPedidos().remove(p);
			}
		}
	}
	
	/**
	 * Método init para nuestra lista que se iniciará con dos usuarios prehechos
	 */
	@PostConstruct
	public void init() {
		
		registrados.add(new Usuario("admin", "admin", "admin@administrador.es", "123456789", "C Dir Nº1", "admin"));
		registrados.add(new Usuario("usuario123", "pepito", "unUsu@dominio.ar", "123456789", "C Cas Nº2", "usuusu"));

	}
	
	
	
}
