package com.ejemplo.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;
	@Column(name = "lineasPedido", nullable = false)
	private List<LineaPedido> lineasPedido;
	@Column(name = "metodoEnvio", nullable = false)
	private String metodoEnvio;
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Pedido() {}
	
	public Pedido (List<LineaPedido> lineasPedido, String metodoEnvio) {
		
		super();
		this.fecha = LocalDate.now();
		this.lineasPedido = lineasPedido;
		this.metodoEnvio = metodoEnvio;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	
	public String getMetodoEnvio() {
		return metodoEnvio;
	}

	public void setMetodoEnvio(String metodoEnvio) {
		this.metodoEnvio = metodoEnvio;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	




}