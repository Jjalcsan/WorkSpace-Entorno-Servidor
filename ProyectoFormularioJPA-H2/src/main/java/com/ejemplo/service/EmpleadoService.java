package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.Empleado;

public interface EmpleadoService {
	
	public Empleado add(Empleado e);	
	public List<Empleado> findAll();	
	public Empleado findById(long id);	
	public Empleado edit(Empleado e);
	public List<Empleado> buscador(String cadena);

}
