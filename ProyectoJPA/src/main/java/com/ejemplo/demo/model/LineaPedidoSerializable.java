package com.ejemplo.demo.model;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class LineaPedidoSerializable implements Serializable{

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Propiedades
	
	private Integer pedido;
	private Integer producto;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public LineaPedidoSerializable() {}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	
	@Override
	public int hashCode() {
		return Objects.hash(pedido, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaPedidoSerializable other = (LineaPedidoSerializable) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(producto, other.producto);
	}

	@Override
	public String toString() {
		return "LineaPedidoSerializable [pedido=" + pedido + ", producto=" + producto + "]";
	}

}
