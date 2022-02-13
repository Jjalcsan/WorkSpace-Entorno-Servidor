package com.example.demo.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.LineaPedido;
import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.LineaPedidoRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class PedidoService {
	
	@Autowired
	private ProductoRepository repoProd;
	
	@Autowired
	private PedidoRepository repoPed;
	
	@Autowired
	private LineaPedidoRepository repoLinPed;
	
	@Autowired
	private UsuarioRepository repoUsu;

	/**
	 * Busca todos los pedidos de la BBDD
	 * @return Nos devuelve la lista de pedidos
	 */
	public List<Pedido> findAll() {
		
		return repoPed.findAll();
		
	}
	
	/**
	 * Busca un pedido por su ID que le pasamos por parametros
	 * @param pedidoID
	 * @return Nos devuelve el pedido o null si no lo encuentra
	 */
	public Pedido findPedidoById(Integer pedidoID) {
		
		return this.repoPed.findById(pedidoID).orElse(null);
		
	}
	
	/**
	 * Añade un pedido a la BBDD
	 * @param pedido
	 * @return Nos devuelve el pedido que hemos añadido
	 */
	@Transactional
	public Pedido addPedido(Pedido pedido) {
		
		return this.repoPed.save(pedido);
		
	}

	/**
	 * Borra todas las lineas del pedido que le pasamos por parametros y despues lo borra de la BBDD
	 * @param pedido
	 */
	@Transactional
	public void delPedidoBBDD(Pedido pedido) {

		Iterator<LineaPedido> it = pedido.getLineas().iterator();
		
		while(it.hasNext()) {
			
			LineaPedido linea = it.next();
			this.repoLinPed.delete(linea);
			
		}
		
		this.repoPed.delete(pedido);
		
	}
	
	/**
	 * Borra un pedido de la lista de pedidos de un usuario
	 * @param pedido
	 */
	public void delPedido(Pedido pedido) {
		
		Usuario usu = pedido.getUsuario();
		usu.getPedidos().remove(pedido);
		
	}

	/**
	 * Busca todos los pedidos de un usuario
	 * @param nick
	 * @return Nos devuelve la lista de pedidos
	 */
	public List<Pedido> pedidosUser(String nick){
		
		Usuario usu = repoUsu.findById(nick).orElse(null);
		return usu.getPedidos();
		
	}
	
	/**
	 * Calcula el precio total de un pedido
	 * @param pedido
	 * @return nos devuelve un valor double del total de pedido
	 */
	public double precioTotal(Pedido pedido) {
		
		double total = 0;
		List<LineaPedido> lineas  = pedido.getLineas();
		
		for( LineaPedido linea: lineas) {
			
			total+=linea.getProducto().getPrecio()*linea.getCantidad();
		}
		
		return total;
		
	}
	
	/**
	 * Añade una lidea al pedido
	 * @param pedido
	 * @param idProd
	 * @param cantidad
	 */
	public void addLinPed(Pedido pedido, Integer idProd, Integer cantidad) {

		Producto producto = this.repoProd.findAll().get(idProd);
		LineaPedido newLinPed = new LineaPedido(pedido, producto);

		if(pedido.getLineas().contains(newLinPed)) {
			
			Integer posicionLineaPedido = pedido.getLineas().indexOf(newLinPed);
			Integer cantidadAntigua = pedido.getLineas().get(posicionLineaPedido).getCantidad();
			pedido.getLineas().get(posicionLineaPedido).setCantidad(cantidadAntigua+cantidad);
			
		} else {
			
			newLinPed.setCantidad(cantidad);
			pedido.getLineas().add(newLinPed);
			this.repoLinPed.save(newLinPed);
			
		}
		
	}
	
	/**
	 * Editamos un pedido y sus cantidades
	 * @param id
	 * @param listaDeCantidades
	 * @param usuario
	 * @return Nos devuelve el pedido editado
	 */
	@Transactional
	public Pedido editPedido(Integer id, Integer[] listaDeCantidades, Usuario usuario) {
		
		Pedido pedido = this.repoPed.findById(id).orElse(null);

		for(int i=0; i<pedido.getLineas().size(); i++){
			if(listaDeCantidades[i]>=0) {
				
				pedido.getLineas().get(i).setCantidad(listaDeCantidades[i]);
				
			} else if( listaDeCantidades[i]==0) {
				
				delEmptyLinea(pedido);
				
			}
		}
		
		this.repoPed.save(pedido);
		return pedido;
		
	}

	/**
	 * Busca un pedido sin lineas
	 * @param nick
	 * @return Nos devuelve el pedido vacio
	 */
	public Pedido getEmptyPedido(String nick) {
		
		Pedido pedido = new Pedido();
		 
		for (int i = 0; i< pedidosUser(nick).size(); i++) {
			if(pedidosUser(nick).get(i).getLineas().size() == 0) {
				
				pedido = pedidosUser(nick).get(i);
				
			}
			 
		}
		 
		return pedido;
		
	}

	/**
	 * Borra las lineas del pedido que se pasa por parametros
	 * @param pedido
	 */
	@Transactional
	public void delEmptyLinea(Pedido pedido) {
		
		Iterator<LineaPedido> iterator = pedido.getLineas().iterator();
		
		while(iterator.hasNext()) {
			
			LineaPedido linea = iterator.next();
			
			if(linea.getCantidad()==0) {
				
				this.repoLinPed.delete(linea);
				
			}
		}
	}

}