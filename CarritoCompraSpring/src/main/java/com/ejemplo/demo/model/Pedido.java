package com.ejemplo.demo.model;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

import javax.validation.constraints.Min;

public class Pedido {
	
	@Min(1)
	private int id=1;
	private HashMap<Producto, Integer> productos;
	private String metodoEnvio;
	private Calendar fecha = Calendar.getInstance();
	private String fechaBonita;
	
	public Pedido (int id, HashMap<Producto, Integer> productos, String metodoEnvio) {
		super();
		this.id=id++;
		this.productos=new HashMap<>();
		this.metodoEnvio=metodoEnvio;
		this.fechaBonita = fecha.get(Calendar.YEAR)+"/"+ fecha.get(Calendar.MONTH)+ "/" + fecha.get(Calendar.DATE);
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

	public HashMap<Producto, Integer> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Producto, Integer> productos) {
		this.productos = productos;
	}

	public String getFechaBonita() {
		return fechaBonita;
	}

	public void setFechaBonita(String fechaBonita) {
		this.fechaBonita = fechaBonita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaBonita, id, metodoEnvio, productos);
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
		return Objects.equals(fechaBonita, other.fechaBonita) && id == other.id
				&& Objects.equals(metodoEnvio, other.metodoEnvio) && Objects.equals(productos, other.productos);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", productos=" + productos + ", metodoEnvio=" + metodoEnvio + ", fechaBonita="
				+ fechaBonita + "]";
	}
	
	

	


	
}
