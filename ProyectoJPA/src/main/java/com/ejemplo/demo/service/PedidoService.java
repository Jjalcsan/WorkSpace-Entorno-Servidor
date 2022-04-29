package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.PedidoRepository;
import com.ejemplo.demo.repository.UsuarioRepository;

@Service
public class PedidoService {
	
	@Autowired private UsuarioRepository repoUsu;
	
	@Autowired private PedidoRepository repoPed;

	/**
	 * Busca todos los pedidos de un usuario
	 * @param nick
	 * @return Nos devuelve la lista de pedidos
	 */
	public List<Pedido> pedidosUser(String nick){
		
		Usuario usu = repoUsu.findById(nick).orElse(null);
		return usu.getPedidos();
		
	}
	
	/**
	 * Añade un pedido a la BBDD
	 * @param pedido
	 * @return Nos devuelve el pedido que hemos añadido
	 */
	@Transactional
	public Pedido addPedido(Pedido pedido) {
		
		return this.repoPed.save(pedido);
		
	}
	
	/**
	 * Busca todos los pedidos de la BBDD
	 * @return Nos devuelve la lista de pedidos
	 */
	public List<Pedido> findAll() {
		
		return repoPed.findAll();
		
	}
	
	/**
	 * Busca un pedido por su ID que le pasamos por parametros
	 * @param pedidoID
	 * @return Nos devuelve el pedido o null si no lo encuentra
	 */
	public Pedido findPedidoById(Integer pedidoID) {
		
		return this.repoPed.findById(pedidoID).orElse(null);
		
	}
	
}
