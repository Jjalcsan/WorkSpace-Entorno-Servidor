package com.ejemplo.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ejemplo.demo.model.Usuario;

@Entity
@Table(name = "usuario")
public class Usuario {
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Propiedades
	
	@Id
	private String nick;
	
	@Column(name = "contra", nullable = false)
	private String contra;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	@OneToMany
	private List<Pedido> pedidos;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Constructores
	
	public Usuario() {}

	public Usuario(String nick, String contra, String nombre, String email, String direccion, String telefono) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
	
	}

	public Usuario(String nick, String contra) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Setters y Getters
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

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
		return Objects.hash(contra, direccion, email, nick, nombre, telefono);
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
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", contra=" + contra + ", nombre=" + nombre + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
}
