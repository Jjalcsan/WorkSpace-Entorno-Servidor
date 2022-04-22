package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired HttpSession sesion;
	@Autowired UsuarioService serviceUsu;
	
	
	@GetMapping({"/login", "/"})
	public String login() {
		
		return "login";
		
	}
	
	@PostMapping("/login/submit")
	public String inicioSesion(@ModelAttribute Usuario usuario, Model model) {
		
		if(!serviceUsu.loginUsuario(usuario.getNick(), usuario.getContra())) {
			
			String wrongLogin = "El usuario o contraseña introducidos no son validos";
			model.addAttribute("wrongLogin", wrongLogin);
			return "login";
			
		} else {
			
			Usuario usu = serviceUsu.findById(usuario.getNick());
			sesion.setAttribute("usuarioLogado", usu);
			model.addAttribute("usuario", usu);
			
			return "inicio";
			
		}
		
	}
}
