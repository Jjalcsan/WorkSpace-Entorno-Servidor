package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Pedido;

@Service
public class ServicePedido {

	private List<Pedido> pedidos = new ArrayList<>();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Pedido getById(int id) {
		
		Pedido buscado = null;
		
		for (Pedido p : pedidos) {
			if (p.getId()==id) {
				buscado = p;
			}
		}
		
		return buscado;
		
	}
	
	/**
	 * 
	 * 
	 */
	public void getAll() {
		
		for (Pedido p : pedidos) {
			System.out.println(p.toString());
		}
		
	}
	

	/**
	 * 	
	 * @param pedido
	 * @param idProducto
	 * @param cantidad
	 */
	public void addProduct(Pedido pedido, int idProducto, int cantidad) {
			
		ServiceProducto lista = new ServiceProducto();
		
		if(lista.getById(idProducto)!=null) {
			pedido.getProductos().put(lista.getById(idProducto), cantidad);
		}
			
	}
		
	/**
	 * 
	 * @param pedido
	 * @param idProducto
	 */
	public void delProduct(Pedido pedido, int idProducto) {
		
		ServiceProducto lista = new ServiceProducto();
		
		if(lista.getById(idProducto)!=null) {
			pedido.getProductos().remove(lista.getById(idProducto));
		}
		
	}
		

	

}