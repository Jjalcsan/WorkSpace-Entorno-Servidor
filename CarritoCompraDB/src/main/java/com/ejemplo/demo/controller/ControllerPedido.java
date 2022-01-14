package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.ServicePedidoMemory;
import com.ejemplo.demo.service.ServiceProductoMemory;
import com.ejemplo.demo.service.ServiceUsuarioMemory;

@Controller
public class ControllerPedido{
	
	@Autowired
	private HttpSession session;
	 
	@Autowired
	private ServiceUsuarioMemory usuarioService;
	
	@Autowired
	private ServicePedidoMemory pedidoService;
	
	@Autowired
	private ServiceProductoMemory productoService;
	
	
	private static final String USUARIOSTRING = "usuario";
	private static final String LISTAPEDIDOSSTRING = "listaDePedidos";
	private static final String NOLOGADO = "redirect:/inicio";
	private static final String INICIO = "redirect:/inicioUsuario";
	
	/**
	 * Metodo que mostrara todos los pedidos del usuario con el que nos hayamos autenticado
	 * @param model
	 * @return nos mostrara la pagina del usuario o nos llevara al login si no estamos autenticados
	 */
	@GetMapping("/inicioUsuario")
	public String listarPedidos(Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			 
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			 
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			model.addAttribute(LISTAPEDIDOSSTRING, pedidoService.findPedidoUsuario(usuarioLogado));
			 
			return "inicioUsuario";
			 
			 
		} else {
			return NOLOGADO;
			 
		}
	}
	
	/**
	 * Metodo cuando entremos a un nuevo pedido que nos mostrara la lista de productos disponibles
	 * @param model
	 * @return Nos devolvera el catalogo de productos o nos llevara al login si no estamos autenticados
	 */
	@GetMapping("/inicioUsuario/catalogo")
	public String nuevoPedido(Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			
			model.addAttribute("catalogo", productoService.findAll());
			return "/catalogo";
		 
		} else {

			return NOLOGADO;
			 
		}
	}
	

	/**
	 * Metodo que nos llevara al resumen una vez finalicemos la compra de productos
	 * @param model
	 * @param listaCantidades
	 * @return nos devolvera al login si no estamos en sesion o en caso contrario al resumen del pedido
	 */
	@PostMapping("/catalogo/submit")
	public String mostrarPedido(Model model, @RequestParam(required=false,name="unidades") Integer [] listaCantidades) {
		
		int i = 0;
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			 
			for(int j =0; j<listaCantidades.length; j++) {
				if(listaCantidades[i] == null) {
					return "redirect:/inicioUsuario/catalogo";
				}else if(listaCantidades[j]>0) {
					i++;
				}
			}
			if(i>0) {
				this.pedidoService.addProducto(listaCantidades);
				Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
				model.addAttribute("mapAux", pedidoService.getAll());
				model.addAttribute(USUARIOSTRING, usuarioLogado);
				 
				return "/resumen";
			}
		}else {
			
			return NOLOGADO;
		}
			
		return NOLOGADO;
				
	}
	

	/**
	 * Una vez finalicemos el pedido nos llevara de vuelta a la pantalla del usuario para ver su listado
	 * @param model
	 * @param metodoEnvio
	 * @return nos llevara a la pantalla de usuario o nos llevara al login si no estamos autenticados
	 */
	@PostMapping("/catalogo/inicioUsuario")
	public String volverInicio(Model model, @RequestParam(required=false,value="metodoEnvio") String metodoEnvio) {
		 
		if(session.getAttribute(USUARIOSTRING) != null){
			
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			usuarioService.addPedido(usuarioLogado, pedidoService.getAll(), metodoEnvio);

			model.addAttribute(LISTAPEDIDOSSTRING, pedidoService.findPedidoUsuario(usuarioLogado));
			 
		 return INICIO;
			
			 
		} else {
			 
			return NOLOGADO;
			
		}
		 
	}
	
	/**
	 * Metodo para editar un pedido accediendo por su id
	 * @param model
	 * @param id
	 * @return Accederemos a la pantalla de modificar el pedido o nos llevara al login si no estamos autenticados
	 */
	@GetMapping("/pedido/editarPedido/{id}")
	public String editarPedido(Model model, @PathVariable int id) {
		if(session.getAttribute(USUARIOSTRING) != null){
			
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			Pedido pedido = usuarioService.getPedidoById(id, usuarioLogado);
			
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			model.addAttribute("pedido", pedido);
			model.addAttribute("ProYCan", pedido.getProductos());
			
			return "/editarPedido";
			
			
		}else {
			
			return NOLOGADO;
			
		}
	}
	
	/**
	 * Una vez finalizado nos llevara de vuelta al inicio del usuario
	 * @param id
	 * @param listaDeCantidades
	 * @param metodoEnvio
	 * @param model
	 * @return volveremos al inicio o nos llevara al login si no estamos autenticados
	 */
	@PostMapping("/editarPedido/submit")
	public String finalizarPedido(@RequestParam (required=false, value="id") int id, @RequestParam (required=false, value="cantidad") Integer [] listaDeCantidades,
			@RequestParam (required=false, value="metodoEnvio") String metodoEnvio, Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null){
			
			Usuario usuario = (Usuario) session.getAttribute(USUARIOSTRING);
			pedidoService.editarPedido(id, listaDeCantidades, metodoEnvio, usuario);
			Pedido pedido = usuarioService.getPedidoById(id, usuario);
			model.addAttribute(USUARIOSTRING, usuario);
			model.addAttribute("pedido", pedido);
			model.addAttribute("ProYCan", pedido.getProductos());
			 
			return INICIO;
			
		}else if(listaDeCantidades.length==0){
			
			return INICIO;
			
		}else {
			
			return NOLOGADO;
			
		}
	}
	
	/**
	 * Metodo para borrar un pedido identificandolo por su ID
	 * @param model
	 * @param id
	 * @return Borrara el pedido o nos llevara al login si no estamos autenticados
	 */
	@GetMapping("/pedido/borrar/{id}")
	public String borrarPedido(Model model, @PathVariable int id) {
		 
		if(session.getAttribute(USUARIOSTRING) != null){
			
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			 
			Pedido pedido = usuarioService.getPedidoById(id, usuarioLogado);
			this.usuarioService.delPedido(pedido, usuarioLogado);
			 
			model.addAttribute(LISTAPEDIDOSSTRING, pedidoService.findPedidoUsuario(usuarioLogado));
			 
			return INICIO;
			
		}else {
			
			return NOLOGADO;
		} 
	}
	 
	 
}