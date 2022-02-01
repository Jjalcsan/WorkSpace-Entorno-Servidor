package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.ServiceUsuario;

@Controller
public class ControllerLogin {
	
	 @Autowired
	 private HttpSession session;
	 
	 @Autowired
	 private ServiceUsuario usuarioServicio;
	 
	 private static final String USUARIOSTRING = "usuario";

	 /**
	  * Metodo para entrar al login una vez lancemos la aplicacion
	  * @param model
	  * @return nos devolvera la pantalla de inicio
	  */
	 @GetMapping({"/", "/inicio"})
	 public String newLoginUsuario(Model model) {
		 
		model.addAttribute(USUARIOSTRING, new Usuario());
		return "inicio";
		
	 }
	 
	 /**
	  * Metodo para autenticar y quedar guardado en sesion
	  * @param usuario
	  * @param bindingResult
	  * @param model
	  * @return nos redirigira a la pantalla de usuario o nos dejara en el login si la informacion no es correcta
	  */
	 @PostMapping("/inicio/submit")
	 public String validarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
		 
		 if (!bindingResult.hasErrors() && usuarioServicio.existeUsuario(usuario.getNick(), usuario.getContra()) ) {
			 
			session.setAttribute(USUARIOSTRING, usuarioServicio.getByNick(usuario.getNick()));
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			return "/inicioUsuario";
		
		 } else {
			
			return "inicio";
				
			}
	 }
	 
	 /**
	  * Metodo para cerrar la sesion del usuario
	  * @return nos devuelve al login
	  */
	@GetMapping({"/terminate"})
	public String terminate() {
		
		this.session.invalidate();
		return "redirect:/inicio";
			
	}
	
}
