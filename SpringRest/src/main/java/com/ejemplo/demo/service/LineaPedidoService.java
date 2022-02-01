package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.repository.LineaPedidoRepository;

public class LineaPedidoService {

	@Autowired
	private LineaPedidoRepository repoLinPed;
	
	public List<LineaPedido> findAll(){
		
		return repoLinPed.findAll();
		
	}
	
	public LineaPedido findById(int id) {
		
		return repoLinPed.findById(id).orElse(null);
		
	}
	
	public LineaPedido edit(int id, double cantidad) {
		
		if(repoLinPed.existsById(id)) {
			
			LineaPedido lp = repoLinPed.findById(id).get();
			lp.setCantidad(cantidad);
			return lp;
			
		} else {
			
			return null;
			
		}
		
	}
	
	public LineaPedido delete(int id) {
		
		if (repoLinPed.existsById(id)) {
			
			LineaPedido lp = repoLinPed.findById(id).get();
			lp.setCantidad(0.0);
			return lp;
			
		} else {
			
			return null;
			
		}
		
	}
}
