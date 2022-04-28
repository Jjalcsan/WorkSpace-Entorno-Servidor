package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.PedidoService;
import com.ejemplo.demo.service.ProductoService;
import com.ejemplo.demo.service.UsuarioService;
import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;

@Controller
public class CarritoController {

	@Autowired private HttpSession sesion;
	
	@Autowired private UsuarioService serviceUsu;
	
	@Autowired private PedidoService servicePed;
	
	@Autowired private ProductoService serviceProd;
	
	private static String REDIRECTLOGIN = "redirect:/login";
	private static String USUARIOSTRING = "usuario";
	
	/**
	 * Nos lleva al inicio del usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/inicio")
	public String inicio(Model model) {
			
		if(sesion.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion
			return REDIRECTLOGIN;
				
		} else {

			Usuario usuario = (Usuario) sesion.getAttribute(USUARIOSTRING);
			model.addAttribute(USUARIOSTRING, usuario);
			
			return "/inicio";
			
		}
	}
	
	/**
	 * Nos muestra el listado de pedidos
	 * @param model
	 * @return Si estamos logeados nos lleva al listado, en caso contrario al login
	 */
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		
		if(sesion.getAttribute("usuario") == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion
			return REDIRECTLOGIN;
				
		} else {
			
			Usuario usu = (Usuario) sesion.getAttribute("usuario");
			model.addAttribute("usuario", usu);
			
			if(servicePed.pedidosUser(usu.getNick()).size()==0) {
				
				String noPedidosAun = "Aun no has realizado ningún pedido";
				model.addAttribute("noPedidosAun", noPedidosAun);
				
			} else {
				
				model.addAttribute("listaDePedidos", servicePed.pedidosUser(usu.getNick()));
				
			}
			
			
			return "pedidos";
				
		}
			
	}
	
	/**
	 * Metodo del controlador que nos lleva al catalogo cuando le damos a nuevo pedido
	 * @param model
	 * @return Nos lleva al catalogo si estamos en sesion o al login en caso contrario
	 */
	@GetMapping("/inicio/catalogo")
	public String newPedido(Model model) {
			 
		if(sesion.getAttribute(USUARIOSTRING) == null) {
			//Comprobacion que se hace al principio de cada metodo para comprobar que el usuario esta en sesion	
			return REDIRECTLOGIN;
				
		} else {
				
			model.addAttribute("produ", new Producto());
			model.addAttribute("listaDeProductos", serviceProd.findAll());
			
			Usuario usuario = (Usuario) sesion.getAttribute(USUARIOSTRING);
			model.addAttribute("usuarioID", usuario.getNick());
			
			Pedido pedido = new Pedido();
			pedido.setUsuario(usuario);
			usuario.getPedidos().add(0, pedido);	
			servicePed.addPedido(pedido);
			
			model.addAttribute("idPed", pedido.getId());
				 
			return "catalogo";
				
		}
	}
	
}
