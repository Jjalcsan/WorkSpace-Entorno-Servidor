package com.ejemplo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

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
