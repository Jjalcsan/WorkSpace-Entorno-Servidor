package com.ejemplo.demo.model;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Min;

public class LineaPedido {
	
	@Min(1)
	private int id;
	private List<Producto> proYCan;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public LineaPedido() {}
	
	public LineaPedido(List<Producto> proYCan) {
		
		this.proYCan = proYCan;
		
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters

	public List<Producto> getProYCan() {
		return proYCan;
	}

	public void setProYCan(List<Producto> proYCan) {
		this.proYCan = proYCan;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override	
	
	@Override
	public int hashCode() {
		return Objects.hash(proYCan, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedido other = (LineaPedido) obj;
		return Objects.equals(proYCan, other.proYCan) && id == other.id;
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", ProYCan=" + proYCan + "]";
	}
	
	

}
