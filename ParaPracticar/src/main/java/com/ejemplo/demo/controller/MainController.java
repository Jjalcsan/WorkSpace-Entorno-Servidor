package com.ejemplo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping("/")
	public String indexPath(@PathVariable(name="index", required=false) String index, Model model) {
		model.addAttribute("index", index);
		return "index";
	}
	
	@GetMapping("/que")
	public String quePath(@PathVariable(name="que", required=false) String que, Model model) {
		model.addAttribute("que", que);
		return "que";
	}
	
	@GetMapping("/contacto")
	public String contactoPath(@PathVariable(name="contacto", required=false) String contacto, Model model) {
		model.addAttribute("contacto", contacto);
		return "contacto";
	}
	
	
}
