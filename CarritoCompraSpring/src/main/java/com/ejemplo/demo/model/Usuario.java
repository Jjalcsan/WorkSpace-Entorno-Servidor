package com.ejemplo.demo.model;

import java.util.ArrayList;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Usuario {

	@NotEmpty
	private String nick;
	@NotEmpty
	private String nombre;
	@Email
	private String email;
	private String tlfn;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String contra;
	private ArrayList<Pedido> pedidos;

	
	

	public Usuario(@NotEmpty String nick, @NotEmpty String nombre, @Email String email, String tlfn,
			@NotEmpty String direccion, @NotEmpty String contra) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.email = email;
		this.tlfn = tlfn;
		this.direccion = direccion;
		this.contra = contra;
		this.pedidos = new ArrayList<>();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contra, direccion, email, nick, nombre, pedidos, tlfn);
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
				&& Objects.equals(tlfn, other.tlfn);
	}

	@Override
	public String toString() {
		return "Nick: " + nick + ", Nombre completo: " + nombre + ", Email: " + email + ", Teléfono: " + tlfn + ", Dirección: "
				+ direccion + ", Listado de pedidos=" + pedidos + ".";
	}

	

	
	
	
	
	
	
}
