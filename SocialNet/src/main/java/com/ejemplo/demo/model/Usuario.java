package com.ejemplo.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
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
	
	@Column(name = "imagenPerf", nullable = false)
	private String imagenPerf;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = true)
	private Pais pais;
	
	
	private List<Post> posts = new ArrayList<>();
	
	
	private List<Usuario> seguidos = new ArrayList<>();
	
	
	private List<Like> likesDados = new ArrayList<>();
	
	
	private List<Grupo> grupos = new ArrayList<>();
	
	
	public Usuario() {}
	
	
	public Usuario(String nick, String contra, String nombre, String apellidos, String telefono, String email, String direccion, String imagen) {
		
		super();
		this.nick = nick;
		this.contra = contra;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.imagenPerf = imagen;
		//this.pais = pais;
		
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


	public Pais getPais() {
		return pais;
	}


	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public List<Post> getPosts() {
		return posts;
	}


	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	public List<Usuario> getSeguidos() {
		return seguidos;
	}


	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}


	public List<Like> getLikesDados() {
		return likesDados;
	}


	public void setLikesDados(List<Like> likesDados) {
		this.likesDados = likesDados;
	}


	public List<Grupo> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public String getImagenPerf() {
		return imagenPerf;
	}

	public void setImagenPerf(String imagenPerf) {
		this.imagenPerf = imagenPerf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, contra, direccion, email, grupos, imagenPerf, likesDados, nick, nombre, pais,
				posts, seguidos, telefono);
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
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(grupos, other.grupos)
				&& Objects.equals(imagenPerf, other.imagenPerf) && Objects.equals(likesDados, other.likesDados)
				&& Objects.equals(nick, other.nick) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(pais, other.pais) && Objects.equals(posts, other.posts)
				&& Objects.equals(seguidos, other.seguidos) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", contra=" + contra + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", pais="
				+ pais + ", imagenPerf=" + imagenPerf + ", posts=" + posts + ", seguidos=" + seguidos + ", likesDados="
				+ likesDados + ", grupos=" + grupos + "]";
	}
	
}
