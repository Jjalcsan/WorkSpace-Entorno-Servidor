package com.ejemplo.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ejemplo.demo.model.Producto;

@Entity
@Table(name="producto")
public class Producto {
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Propiedades

	@Id
	private Integer id;
	private static int contador = 1;
		
	@Column(name = "nombre")
	private String nombre;
		
	@Column(name = "precio")
	private double precio;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Producto() {
		
		super();
		this.id = contador;
		contador++;
		
	}
		
	public Producto(String nombre, double precio) {
		
		super();
		this.id = contador;
		this.nombre = nombre;
		this.precio = precio;
		contador++;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
}
