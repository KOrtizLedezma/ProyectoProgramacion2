package plato.entity;

public class Plato {

	private int codigoPlato;
	private String nombre;
	private double precio;
	private String tama�o;
	
	public Plato(int codigoPlato, String nombre, double precio, String tama�o) {
		super();
		this.codigoPlato = codigoPlato;
		this.nombre = nombre;
		this.precio = precio;
		this.tama�o = tama�o;
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

	public String getTama�o() {
		return tama�o;
	}

	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}

	@Override
	public String toString() {
		return "Plato [codigoPlato=" + codigoPlato + ", nombre=" + nombre + ", precio=" + precio + ", tama�o=" + tama�o
				+ "]";
	}
	
	
	
}
