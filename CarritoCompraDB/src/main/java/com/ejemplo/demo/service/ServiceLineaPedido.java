package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Producto;

public class ServiceLineaPedido {
	
	@Autowired
	private ServiceProducto serviceProducto;
	
	/*public void addProducto(Integer[] listaCantidades) {
		
		List<Producto> listaDeProductos = this.productService.findAll();
		List<LineaPedido> temp = new ArrayList<>();
		
		for(int i = 0; i<listaCantidades.length; i++) {
			temp.put(listaDeProductos.get(i), listaCantidades[i]);
		}
		
		this.ProYCan = temp;*/
	

	public void editarLineasPedido(Integer[] cantidades, LineaPedido lineasPedido) {
		
		
	}
	
		

}
