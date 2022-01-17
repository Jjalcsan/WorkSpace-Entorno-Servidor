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
	private ServiceProductoMemory productService;
	
	/**
	 * Busca todos los productos y sus cantidades
	 * @return devuelve los productos y sus cantidades
	 */
	public List<LineaPedido> getAll(){
		
		return ;
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
	 * Metodo para añadir un producto a un pedido
	 * @param listaCantidades
	 */
	public void addProducto(Integer[] listaCantidades) {
		
		List<Producto> listaDeProductos = this.productService.findAll();
		List<LineaPedido> temp = new ArrayList<>();
		
		for(int i = 0; i<listaCantidades.length; i++) {
			temp.put(listaDeProductos.get(i), listaCantidades[i]);
		}
		
		this.ProYCan = temp;
	}

	
	/**
	 * Metodo para editar el pedido recibiendo los nuevos parametros
	 * @param id
	 * @param listaCantidades
	 * @param metodoEnvio
	 * @param usuario
	 */
	public void editarPedido(int id, Integer[] listaCantidades, String metodoEnvio, Usuario usuario) {
		
		Pedido pedido = servicioUser.getPedidoById(id, usuario);

		pedido.setMetodoEnvio(metodoEnvio);
		List<LineaPedido> mapAux = new ArrayList<>();
		List<Producto> listaDeProductos = productService.findAll();
		
		for(int i=0; i<listaCantidades.length; i++) {
			mapAux.add(listaDeProductos.get(i), listaCantidades[i]);
		}
		
		pedido.setLineasPedido(mapAux);
		
	}
	
	

}