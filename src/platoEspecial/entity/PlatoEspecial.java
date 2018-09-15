package platoEspecial.entity;

public class PlatoEspecial {

	private int codigoPlatoEspecial;
	private String NombrePlato;
	private double PrecioPlato;
	
	public PlatoEspecial(int codigoPlatoEspecial, String nombrePlato, double precioPlato) {
		super();
		this.codigoPlatoEspecial = codigoPlatoEspecial;
		NombrePlato = nombrePlato;
		PrecioPlato = precioPlato;
	}

	public int getCodigoPlatoEspecial() {
		return codigoPlatoEspecial;
	}

	public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
		this.codigoPlatoEspecial = codigoPlatoEspecial;
	}

	public String getNombrePlato() {
		return NombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		NombrePlato = nombrePlato;
	}

	public double getPrecioPlato() {
		return PrecioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		PrecioPlato = precioPlato;
	}
	
	
}
