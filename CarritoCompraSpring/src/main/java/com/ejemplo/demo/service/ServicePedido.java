package com.ejemplo.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;

@Service
public class ServicePedido {
	
	@Autowired
	private ServiceUsuario servicioUser;
	
	@Autowired
	private ServiceProducto productService;
	
	
	private Map<Producto, Integer> ProYCan = new HashMap<>();
	
	/**
	 * Busca todos los productos y sus cantidades
	 * @return devuelve los productos y sus cantidades
	 */
	public Map<Producto, Integer> getAll(){
		
		return this.ProYCan;
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
		Map<Producto, Integer> temp = new HashMap<>();
		
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
		Map<Producto, Integer> mapAux = new HashMap<>();
		List<Producto> listaDeProductos = productService.findAll();
		
		for(int i=0; i<listaCantidades.length; i++) {
			mapAux.put(listaDeProductos.get(i), listaCantidades[i]);
		}
		
		pedido.setProductos(mapAux);
		
	}
	
	

}