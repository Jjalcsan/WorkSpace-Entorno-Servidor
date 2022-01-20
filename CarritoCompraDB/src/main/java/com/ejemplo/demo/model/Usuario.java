package com.ejemplo.demo.model;

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
@Table(name = "usuario")
public class Usuario {

	
	@Column(name = "nombre", nullable =  false)
	private String nombre;
	@Id
	private String nick;
	@Column(name = "contra", nullable =  false)
	private String contra;
	@Column(name = "email", nullable =  false)
	private String email;
	@Column(name = "telefono", nullable =  false)
	private String telefono;
	@Column(name = "direccion", nullable =  false)
	private String direccion;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<>();
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores

	public Usuario() {}
	
	public Usuario( String nick) {
		
		this.nick = nick;
		
	}

	public Usuario(String nick, String contra) {
		
		this.nick = nick;
		this.contra = contra;
		
	}
	
	
	public Usuario(String nombre,String nick, String contra, String email, String telefono, String direccion) {
		
		super();
		this.nombre = nombre;
		this.nick = nick;
		this.contra = contra;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Column(name = "contra", nullable = false)
	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telefono", nullable = false)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "pedidos", nullable = true)
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	//Metodos Override	
	
	@Override
	public int hashCode() {
		return Objects.hash(contra, direccion, email, nick, nombre, pedidos, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contra, other.contra) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(email, other.email) && Objects.equals(nick, other.nick)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(pedidos, other.pedidos)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", nick=" + nick + ", contra=" + contra + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", pedidos=" + pedidos + "]";
	}



	
	
	
	
}