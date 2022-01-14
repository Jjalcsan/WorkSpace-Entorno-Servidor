package com.ejemplo.demo.service;

import java.util.List;

import com.ejemplo.demo.model.Producto;

public interface ServiceProducto {
	
	public List<Producto> findAll();
	public Producto getById(int id);
	
}
