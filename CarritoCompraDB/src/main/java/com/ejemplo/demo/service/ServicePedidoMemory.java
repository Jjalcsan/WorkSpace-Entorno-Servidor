package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

@Service
public class ServicePedidoMemory {
	
	@Autowired
	private ServiceUsuarioMemory servicioUser;
	
	@Autowired
	private ServiceLineaPedidoMemory servicioLineaPedido;
	
	/**
	 * Busca todos los productos y sus cantidades
	 * @return devuelve los productos y sus cantidades
	 */
	public List<LineaPedido> getAll(Pedido pedido){
		
		return pedido.getLineasPedido();
	}
	
	/**
	 * Metodo para buscar los pedidos asociados a un usuario
	 * @param usuario
	 * @return nos devolvera la lista de pedidos
	 */
	public List<Pedido>findPedidoUsuario(Usuario usuario){
		
		return usuario.getPedidos();
		
	}

	
	/**
	 * Metodo para editar el pedido recibiendo los nuevos parametros
	 * @param id
	 * @param listaCantidades
	 * @param metodoEnvio
	 * @param usuario
	 */
	public void editarPedido(int id, Integer[] cantidades, String metodoEnvio, Usuario usuario) {
		
		Pedido pedido = servicioUser.getPedidoById(id, usuario);

		pedido.setMetodoEnvio(metodoEnvio);
		pedido.setLineasPedido(servicioLineaPedido.editarLineasPedido(cantidades));

		
		
	}
	
	

}