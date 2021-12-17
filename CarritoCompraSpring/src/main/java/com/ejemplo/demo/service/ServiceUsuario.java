package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.model.Pedido;

@Service
public class ServiceUsuario {

	private List<Usuario> registrados = new ArrayList<>();
	
	/**
	 * Metodo para buscar un usuario por su nick
	 * @param nick Le pasamos al método como parametro un string que tendra el nick que se quiera buscar
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
	 * Metodo para verificar el login y que los datos existen
	 * @param nick
	 * @param pass
	 * @return devolvera el usuario si existe si no, devolvera null
	 */
	public boolean login(Usuario user) {
		
		boolean encontrado = false;
		
		for (Usuario u : registrados) {
			if (u.getNick().equalsIgnoreCase(user.getNick()) && u.getContra().equalsIgnoreCase(user.getContra())) {
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	/**
	 * Metodo para añadir un pedido
	 * @param Le pasamos como parámetro un usuario
	 * @param Tambien le pasamos el pedido que queremos asociarle
	 */
	public Pedido addPedido(Usuario u, Pedido p) {
		//Añadir al final del index para tenerlo ordenado sin comparable
		u.getPedidos().add(0, p);
		
		return p;
		
	}
	
	
	/**
	 * Metodo que nos devolvera todos los pedidos que ha realizado el usuario que pasemos por parametro
	 * @param Le pasamos como parámetro el usuario del que queremos ver la lista de pedidos
	 */
	public ArrayList<Pedido> getAllPedidos(Usuario u) {
		
		return u.getPedidos();
		
	}
	
	/**
	 * Metodo para buscar un pedido en concreto
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
	 * Metodo para borrar el pedido de un usuario
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
		
		registrados.add(new Usuario("admin", "admin", "admin@administrador.es", "123456788", "C Dir Nº1", "admin"));
		registrados.add(new Usuario("usuario123", "pepito", "unUsu@dominio.ar", "123456789", "C Cas Nº2", "usuusu"));
		registrados.add(new Usuario("juanjo", "Juan Jose", "juanjo@dominio.com", "123456787", "C Cas Nº2", "juanjo1"));
	}
	
	
	
}
