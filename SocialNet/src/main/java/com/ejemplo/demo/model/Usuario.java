package com.ejemplo.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nick", nullable = false)
	private String nick;
	
	@Column(name = "contra", nullable = false)
	private String contra;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "edad", nullable = false)
	private int edad;
	
	@Column(name = "imagenPerf", nullable = true)
	private String imagenPerf;
	
	//private Pais pais;
	
	
	public Usuario() {}
	
	
	public Usuario(String nick, String contra, String nombre, String apellidos, String telefono, String email, String direccion, int edad) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.edad = edad;
		
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/*
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	*/
	public String getImagenPerf() {
		return imagenPerf;
	}

	public void setImagenPerf(String imagenPerf) {
		this.imagenPerf = imagenPerf;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidos, contra, direccion, edad, email, id, imagenPerf, nick, nombre, telefono);
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
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(contra, other.contra)
				&& Objects.equals(direccion, other.direccion) && edad == other.edad
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(imagenPerf, other.imagenPerf) && Objects.equals(nick, other.nick)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nick=" + nick + ", contra=" + contra + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", edad="
				+ edad + ", imagenPerf=" + imagenPerf + "]";
	}
	
	
	
}
