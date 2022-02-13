package com.example.demo.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "pedido")
public class Pedido {

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Propiedades

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "tipoEnvio")
	private String tipoEnvio;
	
	@Column(name = "total")
	private double total;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	@OneToMany
	@NotFound(action=NotFoundAction.IGNORE)
	private List<LineaPedido> lineas = new ArrayList<>();
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Pedido() {
		this.fecha = new Date();
	}
	
	public Pedido(Integer id) {
		super();
		this.id = id;	
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	public String getGoodFecha() {
		return new SimpleDateFormat("dd-MM-yyyy").format(this.fecha);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LineaPedido> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaPedido> lineas) {
		this.lineas = lineas;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override
	
	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, lineas, tipoEnvio, total, usuario);
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
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(lineas, other.lineas) && Objects.equals(tipoEnvio, other.tipoEnvio)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", tipoEnvio=" + tipoEnvio + ", total=" + total + ", usuario="
				+ usuario + ", lineas=" + lineas + "]";
	}

}
