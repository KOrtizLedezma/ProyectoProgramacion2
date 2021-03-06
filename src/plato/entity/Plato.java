package plato.entity;

public class Plato {

	private int CodigoPlato;
	private String NombrePlato;
	private double PrecioPlato;
	private String TamaņoPlato;
	
	public Plato(int CodigoPlato, String NombrePlato, double PrecioPlato, String TamaņoPlato) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.NombrePlato = NombrePlato;
		this.PrecioPlato = PrecioPlato;
		this.TamaņoPlato = TamaņoPlato;
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

	public String getTamaņo() {
		return TamaņoPlato;
	}

	public void setTamaņo(String tamaņo) {
		this.TamaņoPlato = tamaņo;
	}

	@Override
	public String toString() {
		return "Plato [codigoPlato=" + CodigoPlato + ", nombre=" + NombrePlato + ", precio=" + PrecioPlato + ", tamaņo=" + TamaņoPlato
				+ "]";
	}
	
	public String toStringPlato() {
		return "Plato [ nombre=" + NombrePlato + ", tamaņo=" + TamaņoPlato+ "]";
	}
	
	
	
}
