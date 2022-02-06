package com.ejemplo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.exception.LineaPedidoNotFoundException;
import com.ejemplo.demo.exception.PedidoNotFoundException;
import com.ejemplo.demo.exception.ProductoNotFoundException;
import com.ejemplo.demo.exception.UsuarioNotFoundException;
import com.ejemplo.demo.model.LineaPedido;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.repository.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository repoPed;

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de los productos
	
	/**
	 * Metodo de consulta para encontrar todos los productos de la BBDD
	 * @return nos devuelve la lista de productos
	 */
	@GetMapping("/catalogo")
	public ResponseEntity<List<Producto>> findAll() {
		
		List<Producto> catalogo = serviceProd.findAll();
		ResponseEntity<List<Producto>> findall = ResponseEntity.ok(catalogo);
		
		if(catalogo == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	/**
	 * Metodo de consulta para encontrar un producto por su ID
	 * @param id
	 * @return Devuelve el producto o una excepcion en caso contrario
	 */
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> findById(@PathVariable int id)throws Exception {
		
		Producto producto = serviceProd.findById(id);
		ResponseEntity<Producto> findbyid;
		
		if(producto != null) {
			
			findbyid = ResponseEntity.ok(producto);
			
		} else {
			
			throw new ProductoNotFoundException(id);
			//En el caso de que no exista ese producto lanzará la excepcion propia
			
		}
		
		return findbyid;
		
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de los pedidos	

	/**
	 * Metodo de consulta para encontrar todos los pedidos de la BBDD
	 * @return nos devuelve la lista de pedidos
	 */
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> findAllPed() {
		
		List<Pedido> pedidos = servicePed.findAll();
		ResponseEntity<List<Pedido>> findall = ResponseEntity.ok(pedidos);
		
		if(pedidos == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	/**
	 * Metodo de consulta para encontrar un pedido por su ID
	 * @param id
	 * @return Devuelve el pedido o una excepcion en caso contrario
	 */
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> findByIdProd(@PathVariable int id)throws Exception{
		
		Pedido pedido = servicePed.findById(id);
		ResponseEntity<Pedido> findbyid;
		
		if(pedido != null) {
			
			findbyid = ResponseEntity.ok(pedido);
			
		} else {
			
			throw new PedidoNotFoundException(id);
			//En el caso de que no exista ese pedido lanzará la excepcion propia
			
		}
		
		return findbyid;
		
		
	}
	
	/**
	 * Crea un pedido vacio para el usuario indicado en la ruta
	 * @param idUsu
	 * @return Devolvera el pedido creado o lanzara una excepcion si no existe el usuario
	 */
	@PostMapping("/{idUsu}/newPedido")
	public ResponseEntity<Pedido> newPedido(@RequestBody String idUsu)throws Exception{
			
			Usuario usuario = serviceUsu.findById(idUsu);
			
			if (usuario != null) {
				
				Pedido pedido = new Pedido();
				servicePed.add(pedido);
				usuario.getPedidos().add(pedido);
				return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
				
			} else {
				
				throw new UsuarioNotFoundException(idUsu);
				//En el caso de que no exista ese usuario lanzará la excepcion propia
				
			}
	
	}
	
	/**
	 * Metodo de consulta para buscar todas las lineas del pedido indicado en la ruta
	 * @param idPed
	 * @return Devolvera las lineas del pedido o lanzara una excepcion si no existe el pedido
	 */
	@GetMapping("/{idPed}/lineas")
	public ResponseEntity<List<LineaPedido>> findAllLineas(@PathVariable int idPed)throws Exception{
		
		List<LineaPedido> findall = servicePed.findById(idPed).getLineasPedido();
		ResponseEntity<List<LineaPedido>> linPedFind;
		
		if(findall != null) {
			
			linPedFind = ResponseEntity.ok(findall);
			
		} else {
			
			throw new PedidoNotFoundException(idPed);
			//En el caso de que no exista ese pedido lanzará la excepcion propia
			
		}
		
		return linPedFind;
		
	}
	
	//addLinea
	@PostMapping("/{idPed}/addProd/{idProd}")
	public void addLinea(@PathVariable int idPed, @PathVariable int idProd, @RequestBody double cant)throws Exception {
		
		servicePed.addLinPed(idPed, cant, idProd);
		
	}
	
	/**
	 * Metodo para eliminar un pedido por su ID
	 * @param idUsu
	 * @param idPed
	 */
	@DeleteMapping("/{idUsu}/{idPed}/borrar")
	public void eliminarPedido(@PathVariable String idUsu, @PathVariable int idPed)throws Exception {
		
		Usuario usuario = serviceUsu.findById(idUsu);
		Pedido pedido = servicePed.findById(idPed);
		
		if (usuario == null) {
			
			throw new UsuarioNotFoundException(idUsu);
			//En el caso de que no exista ese usuario lanzará la excepcion propia
			
		} else if (pedido == null) {
			
			throw new PedidoNotFoundException(idPed);
			//En el caso de que no exista ese pedido lanzará la excepcion propia
			
		} else {
			
			servicePed.delete(idPed);
			
		}
		
	}
	
	/**
	 * Cambia el tipo de envio y el precio total del pedido pasado por la ID, en caso de no existir el pedido lanzara una excepcion
	 * @param metodo
	 * @param idPed
	 * @throws Exception
	 */
	@PutMapping("/{idPed}/editar")
	public void editarPedido(@RequestBody String metodo, @PathVariable int idPed)throws Exception {
		
		Pedido pedido = servicePed.findById(idPed);
		
		if(pedido != null ) {
			
			pedido.setMetodoEnvio(metodo);
			pedido.setTotal(servicePed.precioTotal(idPed));
			repoPed.save(pedido);
			
		} else {
			
			throw new PedidoNotFoundException(idPed);
			
		}
		
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Metodos de los pedidos
	
	/**
	 * Metodo de consulta para encontrar todos las lineas de los pedidos de la BBDD
	 * @return nos devuelve la lista de lineas
	 */
	@GetMapping("/lineas")
	public ResponseEntity<List<LineaPedido>> findAllLineas() {
		
		List<LineaPedido> lineas = serviceLinPed.findAll();
		ResponseEntity<List<LineaPedido>> findall = ResponseEntity.ok(lineas);
		
		if(lineas == null) {
			
			findall = ResponseEntity.notFound().build();
			
		}
		
		return findall;
		
	}
	
	/**
	 * Metodo de consulta para buscar una linea de pedido por su ID
	 * @param id
	 * @return devolvera la linea del pedido o una excepcion en caso contrario
	 */
	@GetMapping("/LineaPedido/{id}")
	public ResponseEntity<LineaPedido> findByIdLinPed(@PathVariable int id)throws Exception{
		
		LineaPedido linea = serviceLinPed.findById(id);
		ResponseEntity<LineaPedido> findbyid = ResponseEntity.notFound().build();
		
		if(linea != null) {
			
			findbyid = ResponseEntity.ok(linea);
			
		} else {
			
			throw new LineaPedidoNotFoundException(id);
			//En el caso de que no exista la linea del pedido lanzara una excepcion
			
		}
		
		return findbyid;
		
		
	}

	//Put editarLineaPedido
	@PutMapping("/{idPed}/{idLinPed}/edit")
	public void putNuevaCantidad(@PathVariable int idPed, @PathVariable int idLinPed, @RequestBody double cantidad) {
		
		Pedido pedido = servicePed.findById(idPed);
		LineaPedido lineaPed = serviceLinPed.findById(idLinPed);
		
		if(pedido != null && lineaPed != null) {
			
			lineaPed.setCantidad(cantidad);
			
		}
		
	}
	
	//Delete LineaPedido
	@DeleteMapping("{idPed}/{idLinPed}/delete")
	public void deleteLinPed(@PathVariable int idPed, @PathVariable int idLinPed) {

		serviceLinPed.delete(idLinPed);
		
	}
	
}
