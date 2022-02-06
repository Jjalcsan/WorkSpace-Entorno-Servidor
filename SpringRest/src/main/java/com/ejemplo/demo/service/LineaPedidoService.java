package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.repository.LineaPedidoRepository;

@Service
public class LineaPedidoService {

	@Autowired
	private LineaPedidoRepository repoLinPed;
	
	/**
	 * Busca todas las lineas de pedido de la BBDD
	 * @return devuelve la lista de lineas
	 */
	public List<LineaPedido> findAll(){
		
		return repoLinPed.findAll();
		
	}
	
	/**
	 * Busca una linea por ID
	 * @param id
	 * @return devuelve la linea si existe o null en caso contrario
	 */
	public LineaPedido findById(int id) {
		
		return repoLinPed.findById(id).orElse(null);
		
	}
	
	/**
	 * Añade una nueva linea a la BBDD
	 * @param linea
	 * @return devuelve la linea guardada
	 */
	public LineaPedido add(LineaPedido linea) {
		
		return repoLinPed.save(linea);
		
	}
	
	/**
	 * Edita la cantidad de una de las lineas
	 * @param id
	 * @param cantidad
	 * @return devuelve la linea de pedido editada o null en caso de que no exista
	 */
	public LineaPedido edit(int id, double cantidad) {
		
		if(repoLinPed.existsById(id)) {
			
			LineaPedido lp = repoLinPed.findById(id).get();
			lp.setCantidad(cantidad);
			repoLinPed.save(lp);
			return lp;
			
		} else {
			
			return null;
			
		}
		
	}
	
	/**
	 * Borra una linea de pedido de la BBDD
	 * @param id
	 * @return devuelve la linea borrada
	 */
	public LineaPedido delete(int id) {
		
		if (repoLinPed.existsById(id)) {
			
			LineaPedido lp = repoLinPed.findById(id).get();
			repoLinPed.delete(lp);
			return lp;
			
		} else {
			
			return null;
			
		}
		
	}
}
