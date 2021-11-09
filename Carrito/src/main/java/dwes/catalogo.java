package dwes;

import java.util.ArrayList;

public class catalogo {
	
	private ArrayList<producto> listaProductos;
	
	public catalogo() {
		super();
		this.listaProductos = new ArrayList<>();
		
		producto huevos = new producto();
		huevos.setNombre("Huevos");
		huevos.setPrecio(1.5);
		listaProductos.add(huevos);
		
		producto leche = new producto();
		leche.setNombre("Leche");
		leche.setPrecio(1.0);
		listaProductos.add(leche);
		
		producto carne = new producto();
		carne.setNombre("Carne");
		carne.setPrecio(5.0);
		listaProductos.add(carne);
		
		producto pescado = new producto();
		pescado.setNombre("Pescado");
		pescado.setPrecio(4.3);
		listaProductos.add(pescado);
		
		producto pan = new producto();
		pan.setNombre("Pan");
		pan.setPrecio(0.5);
		listaProductos.add(pan);
	}

	public ArrayList<producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	

}
