package plato.entity;

public class Plato {

	private int CodigoPlato;
	private String NombrePlato;
	private double PrecioPlato;
	private String Tama�oPlato;
	
	public Plato(int CodigoPlato, String NombrePlato, double PrecioPlato, String Tama�oPlato) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.NombrePlato = NombrePlato;
		this.PrecioPlato = PrecioPlato;
		this.Tama�oPlato = Tama�oPlato;
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

	public String getTama�o() {
		return Tama�oPlato;
	}

	public void setTama�o(String tama�o) {
		this.Tama�oPlato = tama�o;
	}

	@Override
	public String toString() {
		return "Plato [codigoPlato=" + CodigoPlato + ", nombre=" + NombrePlato + ", precio=" + PrecioPlato + ", tama�o=" + Tama�oPlato
				+ "]";
	}
	
	public String toStringPlato() {
		return "Plato [ nombre=" + NombrePlato + ", tama�o=" + Tama�oPlato+ "]";
	}
	
	
	
}
