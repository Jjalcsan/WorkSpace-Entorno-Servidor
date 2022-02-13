package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Pedido;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.service.PedidoService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;

@Controller
public class CarritoController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UsuarioService serviceUsu;
	
	@Autowired
	private PedidoService servicePed;
	
	@Autowired
	private ProductoService serviceProd; 
	 
	private static String REDIRECTLOGIN = "redirect:/login";
	private static String USUARIOSTRING = "usuario";
	private static String LINPED = "lineaDePedidos";
	private static String LISTAPEDIDOS = "listaDePedidos";
	private static String PEDIDO = "pedido";
	private static String PEDIDOID = "idPed";
	
	/**
	 * Nos lleva al inicio del usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/inicio")
	public String inicio(Model model) {
			
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion
			return REDIRECTLOGIN;
				
		} else {

			Usuario usuario = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			model.addAttribute(USUARIOSTRING, usuario);
			
			return "/inicio";
			
		}
	}
	
	/**
	 * Metodo del controlador que nos lleva al catalogo cuando le damos a nuevo pedido
	 * @param model
	 * @return Nos lleva al catalogo si estamos en sesion o al login en caso contrario
	 */
	@GetMapping("/inicio/catalogo")
	public String newPedido(Model model) {
			 
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion	
			return REDIRECTLOGIN;
				
		} else {
				
			model.addAttribute("produ", new Producto());
			model.addAttribute("listaDeProductos", serviceProd.findAll());
			Usuario usuario = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			model.addAttribute("usuarioID", usuario.getNick());
			Pedido pedido = new Pedido();
			pedido.setUsuario(usuario);
			usuario.getPedidos().add(0, pedido);	
			servicePed.addPedido(pedido);
			model.addAttribute(PEDIDOID, pedido.getId());
				 
			return "catalogo";
				
		}
	}
		 
	/**
	 * Metodo para añadir una linea cada vez que añadimos un producto nuevo
	 * @param model
	 * @param prod
	 * @param unidades
	 * @param usuario
	 * @param idPed
	 * @return Nos deja en el catalogo para seguir añadiendo productos si estamos logeados o nos lleva al login en caso contrario
	 */
	@PostMapping("/inicio/catalogo")
	public String addProducto(Model model, @ModelAttribute("prod")Producto prod, @RequestParam(required=false,name="unidades") Integer unidades, @RequestParam(required=false,name="nickUsu") String usuario, @RequestParam(required=false,name="idPed") Integer idPed) {
			 
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion				
			return REDIRECTLOGIN;
				
		} else {
				
			model.addAttribute("prod", new Producto());
			model.addAttribute("listaDeProductos", serviceProd.findAll());
			model.addAttribute(PEDIDOID, idPed);
			model.addAttribute(USUARIOSTRING, usuario);	
			Pedido pedido = servicePed.findPedidoById(idPed);
			servicePed.addLinPed(pedido, prod.getId(), unidades);
				 
			return "catalogo";
				
		}
	}
	
	/**
	 * Metodo cuando terminamos de añadir los productos
	 * @param model
	 * @param idPed
	 * @param usuario
	 * @return Nos lleva al resumen si estamos logeados o al login en caso contrario
	 */
	@PostMapping("/catalogo/submit")
	public String postPedido(Model model, @RequestParam(required=false,name="idPed") Integer idPed, @RequestParam(required=false,name="nickUsu") String usuario) {
			
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion			
			return REDIRECTLOGIN;
			
		} else {
				
			Usuario usu = serviceUsu.findById(usuario);
			Pedido pedido = servicePed.findPedidoById(idPed);
			double precio = servicePed.precioTotal(pedido);
			
			pedido.setTotal(precio);
			servicePed.addPedido(pedido);
			model.addAttribute(LINPED, servicePed.findPedidoById(idPed).getLineas()); 
			model.addAttribute(USUARIOSTRING, usu);
			model.addAttribute(PEDIDO, pedido);
			model.addAttribute(PEDIDOID, idPed);	
					 
			return "/resumenPedido";
				
		}

	}
	
	/**
	 * Cuando seleccionamos el tipo de envio nos lleva de vuelta al inicio
	 * @param model
	 * @param envio
	 * @param idPed
	 * @return Nos devuelve al inicio si estamos logeados o al login en caso contrario
	 */
	@PostMapping("/catalogo/pedidos")
	public String endPedido(Model model, @RequestParam(required=false,name="envio") String envio, @RequestParam(required=false,name="idPed") Integer idPed) {
			 
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion				
			return REDIRECTLOGIN;
				
		} else {
				
			Usuario usuario = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			Pedido pedido = servicePed.findPedidoById(idPed);
				
			pedido.setTipoEnvio(envio);	
			servicePed.addPedido(pedido);	
			model.addAttribute(PEDIDOID, servicePed.findPedidoById(idPed));
			model.addAttribute(LISTAPEDIDOS, servicePed.pedidosUser(usuario.getNick()));
			model.addAttribute(USUARIOSTRING, usuario);
				
			return "redirect:/inicio";
			
		}
			
	}
	
	/**
	 * Nos muestra el listado de pedidos
	 * @param model
	 * @return Si estamos logeados nos lleva al listado, en caso contrario al login
	 */
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion				
			return REDIRECTLOGIN;
				
		} else {
				
			Usuario usu = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			model.addAttribute(USUARIOSTRING, usu);
			Pedido pedido = servicePed.getEmptyPedido(usu.getNick());
			servicePed.delPedidoBBDD(pedido);
			model.addAttribute(LISTAPEDIDOS, servicePed.pedidosUser(usu.getNick()));
			
			return "pedidos";
				
		}
			
	}
	
	/**
	 * Borra un pedido dependiendo de la ID que se le pase por argumento
	 * @param model
	 * @param id
	 * @return Borra el pedido si estamos logeados o nos lleva al login si no estamos logeados
	 */
	@GetMapping("/pedido/borrar/{id}")
	public String delPedido(Model model, @PathVariable Integer id) {
			
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion			
			return REDIRECTLOGIN;
			
		} else {
			
			Usuario usu = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));	
			Pedido pedido = servicePed.findPedidoById(id);
			
			servicePed.delPedido(pedido);
			servicePed.delPedidoBBDD(pedido);
			model.addAttribute(LISTAPEDIDOS, servicePed.pedidosUser(usu.getNick()));
							 
			return "redirect:/pedidos";
		}
		 
	}

	/**
	 * Accede a la pantalla de edicion de un pedido dependiendo de la ID
	 * @param model
	 * @param id
	 * @return Nos lleva al pedido o al login si no estamos logeados
	 */
	@GetMapping("/pedido/editar/{id}")
	public String editarPedido(Model model, @PathVariable Integer id) {
			
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion			
			return REDIRECTLOGIN;
			
		} else {
				
			Usuario usu = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			Pedido pedido = servicePed.findPedidoById(id);
				
			model.addAttribute(LINPED, pedido.getLineas());
			model.addAttribute(PEDIDO, pedido);
			model.addAttribute(USUARIOSTRING, usu);
				
			return "/editar";
			
		}
	}
	
	/**
	 * Metodo para confirmar los cambios del pedido
	 * @param id
	 * @param listaDeCantidades
	 * @param envio
	 * @param model
	 * @return Confirmara los cambios y nos devolvera al listado o al login en caso de no estar logeados
	 */
	@PostMapping("/editar/submit")
	public String editarPedidoSubmit(@RequestParam (required=false, value="id") Integer id, @RequestParam (required=false, value="cantidad") Integer [] listaDeCantidades, @RequestParam (required=false, value="envio") String envio, Model model) {
			 
		if(session.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion			
			return REDIRECTLOGIN;
				
		} else {
			
			Usuario usuario = serviceUsu.findById((String) session.getAttribute(USUARIOSTRING));
			Pedido pedido = servicePed.editPedido(id, listaDeCantidades, usuario);
			
			pedido.setTotal(servicePed.precioTotal(pedido));
			this.servicePed.addPedido(pedido);
			model.addAttribute(PEDIDO, servicePed.findPedidoById(id));
			model.addAttribute(USUARIOSTRING, usuario);
			model.addAttribute(LISTAPEDIDOS, servicePed.pedidosUser(usuario.getNick()));
				
			return "redirect:/pedidos";
			
		}
			 
	}
	
}
