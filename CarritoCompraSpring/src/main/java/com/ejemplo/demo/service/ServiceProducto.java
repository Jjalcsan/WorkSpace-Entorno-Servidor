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
	 * 
	 * @param Pasamos el id del producto que queremos buscar
	 * @return Nos devuelve la información del producto
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
	 * 
	 * @return Este método nos devolverá nuestro array de productos
	 */
	public List<Producto> getAll() {
		
		return catalogo;
		
	}
	
	/**
	 * Método init para iniciar el array con algunos producto prehechos
	 */
	@PostConstruct
	public void init() {
		catalogo.add(new Producto(2, "Leche", 1.5));
		catalogo.add(new Producto(3, "Huevos", 2.0));
		catalogo.add(new Producto(4, "Cereales", 2.5));
		catalogo.add(new Producto(5, "Carne", 3.0));
		catalogo.add(new Producto(6, "Pescado", 3.5));
		catalogo.add(new Producto(7, "Pizza", 4.0));
		
		
	}
	

}
