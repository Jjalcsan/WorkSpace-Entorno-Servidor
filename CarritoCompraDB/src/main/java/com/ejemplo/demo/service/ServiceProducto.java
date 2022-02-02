package com.ejemplo.demo.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;

@Service
public class ServiceProducto {
	
	private ProductoRepository repoProd;


	/**
	 * Metodo que devuelve el catalogo de productos actuales
	 * @return
	 */
	public List<Producto> findAll(){
		
		return repoProd.findAll();
		
	}
	
	/**
	 * Metodo para buscar un producto por su id
	 * @param id
	 * @return Nos devuelve el producto si lo encuentra, en caso contrario nos dara null
	 */
	public Producto getById(int id) {
		
		return repoProd.findById(id).orElse(null);
		
	}
	

	
}