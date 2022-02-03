package com.ejemplo.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.PedidoService;
import com.ejemplo.demo.service.ProductoService;
import com.ejemplo.demo.service.UsuarioService;

public class CarritoController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UsuarioService ServiceUsu;
	
	@Autowired
	private PedidoService ServicePed;
	
	@Autowired
	private ProductoService ServiceProd;
	
	private static final String USUARIOSTRING = "usuario";
	private static final String LISTAPEDIDOSSTRING = "listaDePedidos";
	private static final String NOLOGADO = "redirect:/inicio";


	
	@GetMapping("/inicioUsuario")
	public String inicioUsuario(Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			 
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			return "inicioUsuario";
			 
		} else {
			
			return NOLOGADO;
			 
		}
	}
	
	@GetMapping("/inicioUsuario")
	public String listarPedidos(Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			 
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			model.addAttribute(LISTAPEDIDOSSTRING, usuarioLogado.getPedidos());
			return "inicioUsuario";
			 
			 
		} else {
			return NOLOGADO;
			 
		}
	}
	
	@GetMapping("/inicioUsuario/catalogo")
	public String nuevoPedido(Model model) {
		 
		if(session.getAttribute(USUARIOSTRING) != null) {
			
			model.addAttribute("catalogo", ServiceProd.findAll());
			return "/catalogo";
		 
		} else {

			return NOLOGADO;
			 
		}
	}

	@RequestMapping(value = "/pedidos", method = RequestMethod.GET)
	public ResponseEntity<Pedido> listado(){
		
		List<Pedido> pedidos = ServicePed.findAll();
		return new ResponseEntity(pedidos, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/catalogo", method = RequestMethod.GET)
	public ResponseEntity<Producto> catalogo(){
		
		List<Producto> catalogo = ServiceProd.findAll();
		return new ResponseEntity(catalogo, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/resumen", method = RequestMethod.GET)
	public ResponseEntity<Pedido> resumen(@Valid @RequestBody Pedido pedido){
		
		List<LineaPedido> resumen = ServicePed.
		
	}
	
}
