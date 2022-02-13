package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class LoginController {
	
	 @Autowired
	 private HttpSession session;
	 
	 @Autowired
	 private UsuarioService serviceUsu;
	 
	 private static String REDIRECTLOGIN = "redirect:/login";
	 private static String USUARIOSTRING = "usuario";
	 
	 /**
	  * Nos muestra el login al acceder a la aplicacion
	  * @param model
	  * @return nos devuelve al login
	  */
	@GetMapping({"/", "/login"})
	public String login(Model model) {
		
		model.addAttribute(USUARIOSTRING, new Usuario());
		return "login";
		 
	}
	
	/**
	 * Comprueba que el usuario que se ha introducido en el login es correcto
	 * @param usuario
	 * @param model
	 * @return Si el usuario existe pasara al inicio de usuario, si no, le devolvera al login
	 */
	@PostMapping("/login/submit")
	public String existeUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		
		if(!this.serviceUsu.existeUsuario(usuario.getNick(), usuario.getNick())) {
			 
			return "login";
			
		} else {
			
			Usuario usu = serviceUsu.findById(usuario.getNick());
			session.setAttribute(USUARIOSTRING, usu.getNick());
			model.addAttribute(USUARIOSTRING, usu);
			//Setteo el usuario en la sesion para guardarlo y añado el usuario al modelo
			
			return "/inicio";
			
		}
		  
	}
	
	/**
	 * Invalida la sesion actual
	 * @return Nos devuelve al login
	 */
	@GetMapping({"/terminate"})
	public String terminate() {
	
		session.invalidate();
		return REDIRECTLOGIN;
		
	}
	
	/**
	 * Si ocurre algun error nos llevará al login
	 * @return Nos devuelve al login
	 */
	@GetMapping({"/error"})
	public String error() {
		
		session.invalidate();
		return REDIRECTLOGIN;
		
	}
	 
}
