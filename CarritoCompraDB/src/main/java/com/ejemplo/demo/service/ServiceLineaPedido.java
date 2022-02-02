package com.ejemplo.demo.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
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
	
		
>>>>>>> 59a7b8c7471c94b01ddda3e8899fdf1620cd7a25

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.repository.LineaPedidoRepository;

public class ServiceLineaPedido {

	@Autowired
	private LineaPedidoRepository repoLinPed;
	
	public LineaPedido addLinPed(LineaPedido linPed) {
		
		return repoLinPed.save(linPed);
		
	}
	/*
	public LineaPedido delLinPed(Integer id) {
		
		return repoLinPed.deleteById(id);
		
	}
	*/
	
}
