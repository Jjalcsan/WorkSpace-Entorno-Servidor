package com.ejemplo.demo.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Min;

public class Pedido {
	
	private static int contador = 1;
	
	@Min(1)
	private int id;
	private Date fecha;
	private Map<Producto, Integer> productos = new HashMap<>();
	private String metodoEnvio;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Pedido() {}
	
	public Pedido(int id) {
		
		super();
		this.id= id;
		
	}
	
	public Pedido( Map<Producto, Integer> productos, String metodoEnvio) {
		
		super();
		this.id = contador++;
		this.fecha = new Date();
		this.productos = productos;
		this.metodoEnvio=metodoEnvio;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Map<Producto, Integer> getProductos() {
		return productos;
	}

	public void setProductos(Map<Producto, Integer> productos) {
		this.productos = productos;
	}

	public String getMetodoEnvio() {
		return metodoEnvio;
	}

	public void setMetodoEnvio(String metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	
	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, metodoEnvio, productos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(fecha, other.fecha) && id == other.id
				&& Objects.equals(metodoEnvio, other.metodoEnvio) && Objects.equals(productos, other.productos);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", productos=" + productos + ", metodoEnvio=" + metodoEnvio + "]";
	}

	
	

}