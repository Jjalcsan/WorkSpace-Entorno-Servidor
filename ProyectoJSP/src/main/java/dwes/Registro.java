package dwes;

import java.util.HashSet;

public class Registro {

	private HashSet<Vivienda> listado;
	
	public Registro () {
		super();	
		this.listado = new HashSet<>();

	}

	public HashSet<Vivienda> getListado() {
		return listado;
	}

	public void setListado(HashSet<Vivienda> listado) {
		this.listado = listado;
	}
	

	
}
