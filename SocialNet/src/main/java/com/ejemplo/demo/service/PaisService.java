package com.ejemplo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Pais;
import com.ejemplo.demo.repository.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repoPais;
	
	public List<Pais> findAll() {
		
		return repoPais.findAll();
		
	}
	
	public Pais findById(int id) {
		
		return repoPais.findById(id).orElse(null);
		
	}
	
	
	
}
