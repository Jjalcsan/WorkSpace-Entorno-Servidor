package com.ejemplo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.model.Empleado;

@Primary
@Service("empleadoServiceDB")
public class EmpleadoServiceDB {
	
	@Autowired
	private EmpleadoRepository repositorio;
	
	@Override
	public Empleado add(Empleado e) {
		return repositorio.save(e);
	}

}
