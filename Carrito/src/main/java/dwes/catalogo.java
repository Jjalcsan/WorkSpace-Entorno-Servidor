package dwes;

import java.util.HashMap;

public class catalogo {
	
	HashMap<String, Double> catalogoProductos;
	
	public catalogo() {
		this.catalogoProductos = new HashMap<String, Double>();
		catalogoProductos.put("Leche", 1.2);
		catalogoProductos.put("Huevos", 3.0);
		catalogoProductos.put("Pan", 1.5);
		catalogoProductos.put("Carne", 5.0);
		catalogoProductos.put("Pescado", 7.0);
		catalogoProductos.put("Patatas", 2.5);
		catalogoProductos.put("Manzanas", 1.5);
		catalogoProductos.put("Pizza", 4.3);
		catalogoProductos.put("Azucar", 2.8);
	}

	public HashMap<String, Double> getCatalogoProductos() {
		return catalogoProductos;
	}

	public void setCatalogoProductos(HashMap<String, Double> catalogoProductos) {
		this.catalogoProductos = catalogoProductos;
	}

}
