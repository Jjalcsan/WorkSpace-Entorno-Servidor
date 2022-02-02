package com.ejemplo.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	private int contador = 1;
	
	@Id
	private int id;
	
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	
	@Column(name = "metodoEnvio", nullable = false)
	private String metodoEnvio;

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = true)
	private List<LineaPedido> lineasPedido;
	
	@Column(name = "total")
	private double total;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Pedido() {
		
		super();
		this.id = contador;
		this.lineasPedido = new ArrayList<>();
		contador++;
		
	}
	
	public Pedido(int id) {
		
		super();
		this.id = contador;
		this.lineasPedido = new ArrayList<>();
		contador++;
		
	}
	
	public Pedido (String metodoEnvio) {
		
		super();
		this.fecha = LocalDate.now();
		this.metodoEnvio = metodoEnvio;
		this.lineasPedido = new ArrayList<>();
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMetodoEnvio() {
		return metodoEnvio;
	}

	public void setMetodoEnvio(String metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	
	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, lineasPedido, metodoEnvio);
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
		return Objects.equals(fecha, other.fecha) && id == other.id && Objects.equals(lineasPedido, other.lineasPedido)
				&& Objects.equals(metodoEnvio, other.metodoEnvio);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", metodoEnvio=" + metodoEnvio + ", lineasPedido=" + lineasPedido + "]";
	}


}