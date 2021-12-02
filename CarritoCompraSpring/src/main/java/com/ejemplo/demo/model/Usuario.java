package com.ejemplo.demo.model;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Usuario {

	@Min(1)
	private int id;
	@NotEmpty
	private String nombreUs;
	@Email
	private String email;
	@NotEmpty
	private String contra;
	
	public Usuario(int id, String nombreUs, String email, String contra) {
		this.id=id;
		this.nombreUs=nombreUs;
		this.email=email;
		this.contra=contra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUs() {
		return nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contra, email, id, nombreUs);
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
		return Objects.equals(contra, other.contra) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nombreUs, other.nombreUs);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUs=" + nombreUs + ", email=" + email + ", contra=" + contra + "]";
	}

	
	
	
	
	
	
}
