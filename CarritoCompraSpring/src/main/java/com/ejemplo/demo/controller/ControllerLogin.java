package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.ServicePedido;
import com.ejemplo.demo.service.ServiceProducto;
import com.ejemplo.demo.service.ServiceUsuario;

public class ControllerLogin {
	
	
	@Autowired
	private ServiceUsuario servicioUsuario;
	private ServiceProducto servicioProducto;
	private ServicePedido servicioPedido;
	private HttpSession session;
	
	@GetMapping({"/inicioAdmin"})
	public String listado(Model model) {
		
		model.addAttribute("listaUsuarios", servicioUsuario.listUsuarios());
		
		return "inicioAdmin";
	}
	
	@PostMapping("/login/newUsuario/submit")
	public String nuevoUsuarioSubmit(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
		
		
		
		return null;
		
	}
	
	
	

}
