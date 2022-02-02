package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import javax.transaction.Transactional;

=======
>>>>>>> 59a7b8c7471c94b01ddda3e8899fdf1620cd7a25
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.PedidoRepository;

@Service
public class ServicePedido {
	
	@Autowired
	private ServiceUsuario servicioUser;
	
	@Autowired
<<<<<<< HEAD
	private PedidoRepository repoPed;
	
	@Autowired
	private ServiceLineaPedido servicioLineaPedido;
	
	/**
	 * Busca todos los pedidos
	 * @return devuelve toda la lista de pedidos
	 */
	public List<Pedido> getAll(){
		
		return repoPed.findAll();
	}
	
	/**
	 * Metodo para buscar un pedido por su ID
	 * @param id
	 * @return nos devolvera el pedido o en caso de no existir devolvera null
	 */
	public Pedido findPedido(Integer id){
		
		return repoPed.findById(id).orElse(null);
		
	}

	/**
	 * Metodo para añadir un nuevo pedido a la lista de pedidos
	 * @param pedido
	 */
	@Transactional
	public Pedido addPedido(Pedido pedido) {
		
		return repoPed.save(pedido);
		
	}
	
	/*
	public void delPedido(Pedido pedido) {
		
		int i = 0;
		
		while(pedido.getLineasPedido().size()>i) {
			
			LineaPedido linPed = pedido.getLineasPedido();
		}

		
	}
	
	/**
	 * Metodo para editar el pedido recibiendo los nuevos parametros
	 * @param id
	 * @param listaCantidades
	 * @param metodoEnvio
	 * @param usuario
	 */
	/*
	public Pedido editarPedido( String nick) {
		
		return repoPed.findBy(null, null)

		
		
	}*/
	
=======
	private ServiceLineaPedido servicioLineaPedido;
	
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


		
		
	}
	
>>>>>>> 59a7b8c7471c94b01ddda3e8899fdf1620cd7a25
	

}