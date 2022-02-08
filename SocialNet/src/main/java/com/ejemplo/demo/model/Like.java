package com.ejemplo.demo.model;

import java.util.Objects;

public class Like {

	private int id;
	
	
	private Usuario usuLike;
	
	
	private Post postLike;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Usuario getUsuLike() {
		return usuLike;
	}


	public void setUsuLike(Usuario usuLike) {
		this.usuLike = usuLike;
	}


	public Post getPostLike() {
		return postLike;
	}


	public void setPostLike(Post postLike) {
		this.postLike = postLike;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, postLike, usuLike);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Like other = (Like) obj;
		return id == other.id && Objects.equals(postLike, other.postLike) && Objects.equals(usuLike, other.usuLike);
	}


	@Override
	public String toString() {
		return "Like [id=" + id + ", usuLike=" + usuLike + ", postLike=" + postLike + "]";
	}
	
	
}
