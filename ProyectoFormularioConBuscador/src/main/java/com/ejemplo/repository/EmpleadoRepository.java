package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.model.Empleado;

public interface EmpleadoRepository 
	extends JpaRepository<Empleado, Long>{

}
