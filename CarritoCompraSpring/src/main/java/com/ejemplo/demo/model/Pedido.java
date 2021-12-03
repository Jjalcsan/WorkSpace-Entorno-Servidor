package com.ejemplo.demo.model;

import java.util.HashMap;
import java.util.Objects;

import javax.validation.constraints.Min;

public class Pedido {
	
	@Min(1)
	private int id=1;
	private HashMap<Producto, Double> productos;
	private String metodoEnvio;
	
	public Pedido (int id, HashMap<Producto, Double> productos, String metodoEnvio) {
		super();
		this.id=id++;
		this.productos=new HashMap<Producto, Double>();
		this.metodoEnvio=metodoEnvio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getMetodoEnvio() {
		return metodoEnvio;
	}

	public void setMetodoEnvio(String metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}

	public HashMap<Producto, Double> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Producto, Double> productos) {
		this.productos = productos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, metodoEnvio, productos);
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
		return id == other.id && Objects.equals(metodoEnvio, other.metodoEnvio)
				&& Objects.equals(productos, other.productos);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", productos=" + productos + ", metodoEnvio=" + metodoEnvio + "]";
	}


	
}
