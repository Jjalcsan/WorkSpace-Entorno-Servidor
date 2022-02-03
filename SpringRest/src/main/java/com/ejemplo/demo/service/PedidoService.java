package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repoPed;
	
	public List<Pedido> findAll() {
		
		return repoPed.findAll();
		
	}
	
	public Pedido findById(int id) {
		
		return repoPed.findById(id).orElse(null);
		
	}
	
	public Pedido add(Pedido pedido) {
		
		return repoPed.save(pedido);
		
	}
	
	public Pedido delete(int id) {
		
		if (repoPed.existsById(id)) {
			
			Pedido p = repoPed.findById(id).get();
			repoPed.deleteById(id);
			return p;
			
		} else {
			
			return null;
			
		}
	}
	
	public Pedido edit(int id, List<LineaPedido> nuevasLineas, String metodoEnvio) {
		
		if(repoPed.existsById(id)) {
			
			Pedido p = repoPed.findById(id).get();
			p.setLineasPedido(nuevasLineas);
			p.setMetodoEnvio(metodoEnvio);
			repoPed.save(p);
			return p;
			
		} else {
			
			return null;
			
		}
		
	}
	
	public double total(Pedido pedido) {
		
		double total = 0.0;
		
		for (int i = 0; i < pedido.getLineasPedido().size(); i++) {
			
			//
			//total += pedido.getLineasPedido().;
			
		}
		
		return total;
	}
	
	public double precioTotal(Pedido pedido) {
		
		double total = 0;
		List<LineaPedido> lineas = pedido.getLineasPedido();
		
		for(LineaPedido linea : lineas) {
			
			total += linea.getCantidad()*linea.getProducto().getPrecio();
			
		}
		
		return total;
		
	}
	
}
