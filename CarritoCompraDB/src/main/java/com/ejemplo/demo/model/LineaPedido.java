package com.ejemplo.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lineaPedido")
public class LineaPedido {
	
	@Id
	@ManyToOne
	private Producto producto;
	@Id
	@ManyToOne
	private Pedido pedido;
	@Column(name = "cantidad")
	private int cantidad;

	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public LineaPedido() {}

	public LineaPedido(int cantidad, Producto producto, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override	
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, pedido, producto);
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
		return cantidad == other.cantidad && Objects.equals(pedido, other.pedido)
				&& Objects.equals(producto, other.producto);
	}

	@Override
	public String toString() {
		return "LineaPedido [cantidad=" + cantidad + ", producto=" + producto + ", pedido=" + pedido
				+ "]";
	}
	
}
