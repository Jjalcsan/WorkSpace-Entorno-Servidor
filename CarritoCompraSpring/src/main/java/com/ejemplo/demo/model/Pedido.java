package com.ejemplo.demo.model;

import java.util.ArrayList;
import java.util.Objects;

public class Pedido {
	
	private int id;
	private ArrayList<Producto> productos;
	private String metodoEnvio;
	private double total;
	
	public Pedido (int id, ArrayList<Producto> productos, String metodoEnvio, double total) {
		super();
		this.id=id;
		this.productos=new ArrayList<>();
		this.metodoEnvio=metodoEnvio;
		this.total=total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public String getMetodoEnvio() {
		return metodoEnvio;
	}

	public void setMetodoEnvio(String metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, metodoEnvio, productos, total);
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
				&& Objects.equals(productos, other.productos)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", productos=" + productos + ", metodoEnvio=" + metodoEnvio + ", total=" + total
				+ "]";
	}
	
}
