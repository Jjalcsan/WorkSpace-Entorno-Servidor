package com.ejemplo.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LineaPedido")
public class LineaPedido {
	
	private int contador = 1;
	
	@Id
	private int id;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private double cantidad;

	public LineaPedido() {
		
		this.id = contador;
		contador++;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, pedido, producto);
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
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad) && id == other.id
				&& Objects.equals(pedido, other.pedido) && Objects.equals(producto, other.producto);
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", cantidad=" + cantidad
				+ "]";
	}

}
