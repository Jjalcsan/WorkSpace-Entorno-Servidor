package com.ejemplo.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Post {

	
	private int id;
	
	
	private String titulo;
	
	
	private String contenido;
	
	
	private Usuario creador;
	
	
	private LocalDate fechaCreacion;
	
	
	private List<Like> likes = new ArrayList<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public Usuario getCreador() {
		return creador;
	}


	public void setCreador(Usuario creador) {
		this.creador = creador;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public List<Like> getLikes() {
		return likes;
	}


	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}


	@Override
	public int hashCode() {
		return Objects.hash(contenido, creador, fechaCreacion, id, likes, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(contenido, other.contenido) && Objects.equals(creador, other.creador)
				&& Objects.equals(fechaCreacion, other.fechaCreacion) && id == other.id
				&& Objects.equals(likes, other.likes) && Objects.equals(titulo, other.titulo);
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", creador=" + creador
				+ ", fechaCreacion=" + fechaCreacion + ", likes=" + likes + "]";
	}
	
	
}
