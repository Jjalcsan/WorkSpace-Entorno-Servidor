package dwes;

public class Vivienda {

	private String nombre = null;
	private String direccion = null;
	private int habitaciones = 0;
	private String tipoPiso = null;
	
	public Vivienda() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getTipoPiso() {
		return tipoPiso;
	}

	public void setTipoPiso(String tipoPiso) {
		this.tipoPiso = tipoPiso;
	}
	
	
}
