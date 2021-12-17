package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.demo.model.Pedido;
import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.ServicePedido;
import com.ejemplo.demo.service.ServiceProducto;
import com.ejemplo.demo.service.ServiceUsuario;

@Controller
public class ControllerPedido {

	@Autowired
	private ServiceProducto catalogo;
	private ServiceUsuario registrados;
	private ServicePedido pedidos;
	
	
	
	/**
	 * metodo para listar todos los productos en el html de catalogo
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicioUsuario/catalogo"})
	public String listadoProducto(Model model) {
		model.addAttribute("catalogo", catalogo.getAll());
		return "catalogo";
	}
	
	/**
	 * metodo para listar todos los pedidos de un usuario
	 * @param model
	 * @param usuario
	 * @return
	 */
	@GetMapping({"/inicioUsuario"})
	public String listadoPedido(Model model, Usuario usuario) {
		
		model.addAttribute("pedido", registrados.getAllPedidos(usuario));
		
		return "inicioUsuario";
	}
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping({"/inicioUsuario/editarPedido"})
	public String editarPed(Model model, int id) {
		
		model.addAttribute("pedido", pedidos.getById(id));
		
		return "editarPedido";
		
	}
	
	/**
	 * 
	 * @param model
	 * @param idPro
	 * @param canti
	 * @param pedido
	 * @return
	 */
	@PostMapping({"/inicioUsuarios/editarPedido"})
	public String addProductoPed(Model model, int idPro, int canti, Pedido pedido) {
		
		model.addAttribute(pedidos.addProduct(pedido, idPro, canti));
		
		return "editarPedido";
		
	}
	
	/**
	 * 
	 * @param model
	 * @param pedido
	 * @return
	 */
	@PostMapping({"/inicioUsuarios/catalogo/resumen"})
	public String addPedido(Model model, Pedido pedido){
		
		model.addAttribute(registrados.addPedido(null, pedido));
		
		return "redirect:inicioUsuario";
	}
	
	/*
	@GetMapping({"/inicioUsuarios/editarPedido"})
	public String delProductoPed() {
		
		return "";
		
	}
	
	
	@GetMapping({"/inicioUsuario/catalogo/resumen"})
	public String verResumen() {
		
		
		return "";
	}
	*/
	
	
	


}
