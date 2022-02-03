package com.ejemplo.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@PostMapping("/login/submit")
	public String validarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
		 
		if (!bindingResult.hasErrors() && ServiceUsu.existeUsuario(usuario.getNick(), usuario.getContra()) ) {
			 
			Usuario usuarioLogado = (Usuario) session.getAttribute(USUARIOSTRING);
			model.addAttribute(USUARIOSTRING, usuarioLogado);
			return "/inicioUsuario";
		
		} else {
			
			return "inicio";
				
		}
	}
	
	@GetMapping("/terminate")
	public String terminate() {
		
		this.session.invalidate();
		return "redirect:/inicio";
		
	}
	
	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public ResponseEntity<Usuario> comprobacion(@Valid @RequestBody Usuario usuario){
		
		boolean encontrado = ServiceUsu.existeUsuario(usuario.getNick(), usuario.getContra());
		return new ResponseEntity(encontrado, HttpStatus.ACCEPTED);
		
	}
	
	
	
}
