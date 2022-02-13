package com.ejemplo.demo.model;

import java.util.List;
import java.util.Objects;

public class Grupo {
	
	private int id;
	
	
	private String nombre;
	
	
	private String descripcion;
	
	
	private List<Usuario> miembros;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Usuario> getMiembros() {
		return miembros;
	}


	public void setMiembros(List<Usuario> miembros) {
		this.miembros = miembros;
	}


	@Override
	public int hashCode() {
		return Objects.hash(descripcion, id, miembros, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(descripcion, other.descripcion) && id == other.id
				&& Objects.equals(miembros, other.miembros) && Objects.equals(nombre, other.nombre);
	}


	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", miembros=" + miembros
				+ "]";
	}

	
}
