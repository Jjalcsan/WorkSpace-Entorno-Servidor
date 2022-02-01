package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repoProd;
	
	public List<Producto> findAll(){
		
		return repoProd.findAll();
		
	}
	
	public Producto findById(int id) {
		
		return repoProd.findById(id).orElse(null);
		
	}
	
}
