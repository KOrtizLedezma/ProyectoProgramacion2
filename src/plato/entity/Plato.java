package plato.entity;

public class Plato {

	private int CodigoPlato;
	private String NombrePlato;
	private double PrecioPlato;
	private String TamañoPlato;
	
	public Plato(int CodigoPlato, String NombrePlato, double PrecioPlato, String TamañoPlato) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.NombrePlato = NombrePlato;
		this.PrecioPlato = PrecioPlato;
		this.TamañoPlato = TamañoPlato;
	}

	public int getCodigoPlato() {
		return CodigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}

	public String getNombre() {
		return NombrePlato;
	}

	public void setNombre(String nombre) {
		this.NombrePlato = nombre;
	}

	public double getPrecio() {
		return PrecioPlato;
	}

	public void setPrecio(double precio) {
		this.PrecioPlato = precio;
	}

	public String getTamaño() {
		return TamañoPlato;
	}

	public void setTamaño(String tamaño) {
		this.TamañoPlato = tamaño;
	}

	@Override
	public String toString() {
		return "Plato [codigoPlato=" + CodigoPlato + ", nombre=" + NombrePlato + ", precio=" + PrecioPlato + ", tamaño=" + TamañoPlato
				+ "]";
	}
	
	public String toStringPlato() {
		return "Plato [ nombre=" + NombrePlato + ", tamaño=" + TamañoPlato+ "]";
	}
	
	
	
}
