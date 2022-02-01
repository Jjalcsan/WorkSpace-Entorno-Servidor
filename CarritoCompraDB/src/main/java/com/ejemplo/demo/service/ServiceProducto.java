package com.ejemplo.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Producto;

@Service
public class ServiceProducto {
	
	private List<Producto> catalogo = new ArrayList<>();


	/**
	 * Metodo que devuelve el catalogo de productos actuales
	 * @return
	 */
	public List<Producto> findAll(){
		
		return catalogo;
		
	}
	
	/**
	 * Metodo para buscar un producto por su id
	 * @param id
	 * @return Nos devuelve el producto si lo encuentra, en caso contrario nos dara null
	 */
	public Producto getById(int id) {
		
		Producto buscado = null;
				
		for (Producto p : catalogo) {
			if(p.getId()==id) {
				buscado = p;
			}
		}
		
		return buscado;
		
	}
	
	/**
	 * Metodo init que añadira una serie de productos
	 */
	@PostConstruct
	public void init() {
		catalogo.add(new Producto(1, "Leche", 1.5));
		catalogo.add(new Producto(2, "Huevos", 2.0));
		catalogo.add(new Producto(3, "Cereales", 2.5));
		catalogo.add(new Producto(4, "Carne", 3.0));
		catalogo.add(new Producto(5, "Pescado", 3.5));
		catalogo.add(new Producto(6, "Pizza", 4.0));
		
		
	}
	
}