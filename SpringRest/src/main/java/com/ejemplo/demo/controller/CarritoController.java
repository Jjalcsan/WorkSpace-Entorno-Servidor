package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.LineaPedidoService;
import com.ejemplo.demo.service.PedidoService;
import com.ejemplo.demo.service.ProductoService;
import com.ejemplo.demo.service.UsuarioService;

@RestController
public class CarritoController {

	
	@Autowired
	private PedidoService servicePed;
	
	@Autowired
	private ProductoService serviceProd;
	
	@Autowired
	private UsuarioService serviceUsu;
	
	@Autowired
	private LineaPedidoService serviceLinPed;

	@GetMapping("/catalogo")
	public ResponseEntity<List<Producto>> findAll() {
		
		List<Producto> catalogo = serviceProd.findAll();
		ResponseEntity<List<Producto>> findall = ResponseEntity.ok(catalogo);
		
		if(catalogo == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> findById(@PathVariable int id) {
		
		Producto producto = serviceProd.findById(id);
		ResponseEntity<Producto> findbyid = ResponseEntity.notFound().build();
		
		if(producto != null) {
			
			findbyid = ResponseEntity.ok(producto);
			
		}
		
		return findbyid;
		
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> findAllPed() {
		
		List<Pedido> pedidos = servicePed.findAll();
		ResponseEntity<List<Pedido>> findall = ResponseEntity.ok(pedidos);
		
		if(pedidos == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> findByIdProd(@PathVariable int id){
		
		Pedido pedido = servicePed.findById(id);
		ResponseEntity<Pedido> findbyid = ResponseEntity.notFound().build();
		
		if(pedido != null) {
			
			findbyid = ResponseEntity.ok(pedido);
			
		}
		
		return findbyid;
		
		
	}
	
	@PostMapping("/newPedido")
	public ResponseEntity<Pedido> newPedido(@RequestBody String id){
		
		Usuario usu = serviceUsu.findById(id);
		
		if (usu == null) {
			
			return null;
			
		} else {
			
			Pedido pedido = new Pedido();
			usu.getPedidos().add(pedido);
			servicePed.add(pedido);
			return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
			
		}
		
	}
	
	
	//Delete Pedido
	
	//Put Pedido
	
	//findAllLineasPedidos
	@GetMapping("/lineas")
	public ResponseEntity<List<LineaPedido>> findAllLineas() {
		
		List<LineaPedido> lineas = serviceLinPed.findAll();
		ResponseEntity<List<LineaPedido>> findall = ResponseEntity.ok(lineas);
		
		if(lineas == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	//findByIdLinea
	
	//Post addLineaPedido
	
	//Put editarLineaPedido
	
	//Delete LineaPedido

	
}
