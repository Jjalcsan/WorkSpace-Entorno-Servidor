package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplo.demo.service.ServiceProducto;

@Controller
public class ControllerPedido {

	@Autowired
	private ServiceProducto catalogo;
	
	@GetMapping({"/inicioUsuario/catalogo"})
	public String listado(Model model) {
		model.addAttribute("catalogo", catalogo.getAll());
		return "catalogo";
	}


}
