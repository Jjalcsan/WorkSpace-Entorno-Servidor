package dwes;

import java.util.ArrayList;

public class registrados {

	private ArrayList<usuario> listaUsuarios;
	
	public registrados() {
		super();
		this.listaUsuarios = new ArrayList<>();
		
		usuario admin = new usuario();
		admin.setNombre("admin");
		admin.setContrasenia("admin");
		listaUsuarios.add(admin);
		
		usuario juanjo = new usuario();
		juanjo.setNombre("juanjo");
		juanjo.setContrasenia("daw2");
		listaUsuarios.add(juanjo);
		
		usuario usuario123 = new usuario();
		usuario123.setNombre("usuario123");
		usuario123.setContrasenia("contraseña321");
		listaUsuarios.add(usuario123);
		
		usuario nohacker = new usuario();
		nohacker.setNombre("nohacker");
		nohacker.setContrasenia("hackerino");
		listaUsuarios.add(nohacker);
	}

	public ArrayList<usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
