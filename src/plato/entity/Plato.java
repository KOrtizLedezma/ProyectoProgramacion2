package plato.entity;

public class Plato {

	private int codigoPlato;
	private String nombre;
	private double precio;
	private String tamaño;
	
	public Plato(int codigoPlato, String nombre, double precio, String tamaño) {
		super();
		this.codigoPlato = codigoPlato;
		this.nombre = nombre;
		this.precio = precio;
		this.tamaño = tamaño;
	}

	public int getCodigoPlato() {
		return codigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.codigoPlato = codigoPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	@Override
	public String toString() {
		return "Plato [codigoPlato=" + codigoPlato + ", nombre=" + nombre + ", precio=" + precio + ", tamaño=" + tamaño
				+ "]";
	}
	
	
	
}
