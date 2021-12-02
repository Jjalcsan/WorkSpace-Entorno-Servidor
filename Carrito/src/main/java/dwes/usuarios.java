package dwes;

import java.util.HashMap;

public class usuarios {

	HashMap<String, String> listaUsuarios;
	
	public usuarios() {
		this.listaUsuarios = new HashMap<String, String>();
		listaUsuarios.put("admin", "admin");
		listaUsuarios.put("juanjo", "contraseña");
		listaUsuarios.put("usuario123", "contra1");
		listaUsuarios.put("unhacker", "nohackers");
	}

	public HashMap<String, String> getUsuarios() {
		return listaUsuarios;
	}

	public void setUsuarios(HashMap<String, String> usuarios) {
		this.listaUsuarios = usuarios;
	}
	
}
