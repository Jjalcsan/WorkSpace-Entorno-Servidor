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
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicio/inicioAdmin"})
	public String listarUsers(Model model) {
		
		model.addAttribute("listaUsuarios", servicioUsuario.listUsuarios());
		
		return "inicioAdmin";
	}
	
	/**
	 * 
	 * @param usuario
	 * @param bindingResult
	 * @return
	 */
	
	@PostMapping("/inicio/newUsuario/submit")
	public String nuevoUsuarioSubmit(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "formulario";
		} else {
			servicioUsuario.add(usuario);
			return "redirect:/login/newUsuario";
		}
		
	}
	

	
	@PostMapping({"/inicio/comprobar"})
	public String login(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingresult) {
		if(servicioUsuario.login(usuario)) {
			
			if(usuario.getNick().equalsIgnoreCase("admin") && !bindingresult.hasErrors()) {
				
				String nicksession = usuario.getNick();
				session.setAttribute("usuarioSession", nicksession);
				return "inicioAdmin";
			
			} else {
				
				String nicksession = usuario.getNick();
				session.setAttribute("usuarioSession", nicksession);
				return "inicioUser";
			
			}
			
		}else {
			
			return "inicio";
		}
	}
	
	
	//@PostMapping({"/inicio/inicioAdmin/listaUsuarios"})
	//public String delUser() {
	
 //}
	
	
	
	//Borrar usuario
	
	//Login
	
	//Terminar login
	
	
	
	
	

}
