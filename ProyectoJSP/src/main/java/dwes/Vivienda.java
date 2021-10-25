package dwes;

public class Vivienda {

	/**
	 * Especificamos los atributos de la clase en private
	 */
	private String nombre;
	private String direccion;
	private int habitaciones;
	private String tipoPiso;
	
	/**
	 * Como requiere el Bean creamos un constructor vacio para la clase
	 */
	public Vivienda() {
		super();
	}
	
	/**
	 * Metodo Get para el atributo nombre
	 * @return Nos dara el nombre del objeto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo Set para el atributo nombre
	 * @param nombre cambiara el nombre del atributo al nuevo introducido
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo Get para el atributo direccion
	 * @return Nos dara la direccion del objeto
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo Set para el atributo direccion
	 * @param direccion cambiara la direccion a la nueva introducida
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo Get para el atributo habitaciones
	 * @return Nos dara el numero de habitaciones del objeto
	 */
	public int getHabitaciones() {
		return habitaciones;
	}

	/**
	 * Metodo Set para el atributo habitaciones
	 * @param habitaciones cambiara el numero de habitaciones al nuevo numero introducido
	 */
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	/**
	 * Metodo Get para el atributo tipoPiso
	 * @return Nos dara el tipo de vivienda del objeto
	 */
	public String getTipoPiso() {
		return tipoPiso;
	}

	/**
	 * Metodo Set para el atributo tipoPiso
	 * @param tipoPiso cambiara el tipo de la vivienda al nuevo introducido
	 */
	public void setTipoPiso(String tipoPiso) {
		this.tipoPiso = tipoPiso;
	}
	
	
}
