package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UsuarioService ServiceUsu;
	
	private static final String USUARIOSTRING = "usuario";
	
	@GetMapping({"/", "/login"})
	public String newLoginUsuario(Model model) {
		 
		model.addAttribute(USUARIOSTRING, new Usuario());
		return "login";
		
	}
	
	
	
}
