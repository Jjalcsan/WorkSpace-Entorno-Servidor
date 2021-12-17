package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejemplo.demo.model.Usuario;
import com.ejemplo.demo.service.ServiceUsuario;

public class ControllerLogin {
	
	
	@Autowired
	private ServiceUsuario servicioUsuario;
	private HttpSession session;
	
	

	@GetMapping({"/", "/inicio"})
    public String home(){
        return "inicio";
    }
	

	/**
	 * Metodo para la comprobacion del login
	 * @param usuario validara los datos del modelo del usuario
	 * @param bindingresult validara los datos de la comprobacion del usuario
	 * @return
	 */
	@PostMapping({"/inicio/comprobar"})
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingresult) {
		if(servicioUsuario.login(usuario) && !bindingresult.hasErrors()) {
			
			String nicksession = usuario.getNick();
			session.setAttribute("usuarioSession", nicksession);
			return "inicioUsuario";
			
		} else {
			
			return "inicio";
			
		}
	}
	
	@PostMapping({"/inicio/inicioUsuario"})
	public String deslogeo() {
		
		session.removeAttribute("usuarioSession");
		
		return ("redirect:inicio");
	}
	
		
	
	
	//Terminar login
	
	
	
	
	

}
