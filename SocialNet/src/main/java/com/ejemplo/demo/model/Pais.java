package com.ejemplo.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Usuario> residentes;


	public int getId() {
		return id;
	}
	

	public Pais() {}
	
	
	public Pais(int id, String nombre) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		
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


	public List<Usuario> getResidentes() {
		return residentes;
	}


	public void setResidentes(List<Usuario> residentes) {
		this.residentes = residentes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, residentes);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(residentes, other.residentes);
	}


	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", residentes=" + residentes + "]";
	}

}
