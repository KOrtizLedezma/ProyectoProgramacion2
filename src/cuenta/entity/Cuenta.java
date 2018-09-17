package cuenta.entity;

public class Cuenta {
	
	private int NitCliente;
	private double PrecioPlato;
    private int CantidadPlatos;
    private String NombrePlato;
    private int CodigoMesa;
    
	public Cuenta(int nitCliente, double precioPlato, int cantidadPlatos, String nombrePlato, int codigoMesa) {
		super();
		NitCliente = nitCliente;
		PrecioPlato = precioPlato;
		CantidadPlatos = cantidadPlatos;
		NombrePlato = nombrePlato;
		CodigoMesa = codigoMesa;
	}

	public int getNitCliente() {
		return NitCliente;
	}

	public void setNitCliente(int nitCliente) {
		NitCliente = nitCliente;
	}

	public double getPrecioPlato() {
		return PrecioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		PrecioPlato = precioPlato;
	}

	public int getCantidadPlatos() {
		return CantidadPlatos;
	}

	public void setCantidadPlatos(int cantidadPlatos) {
		CantidadPlatos = cantidadPlatos;
	}

	public String getNombrePlato() {
		return NombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		NombrePlato = nombrePlato;
	}

	public int getCodigoMesa() {
		return CodigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		CodigoMesa = codigoMesa;
	}

	@Override
	public String toString() {
		return "Cuenta [NitCliente=" + NitCliente + ", PrecioPlato=" + PrecioPlato + ", CantidadPlatos="
				+ CantidadPlatos + ", NombrePlato=" + NombrePlato + ", CodigoMesa=" + CodigoMesa + "]";
	}
	
	public String toStringCliente() {
		return "Cuenta [ PrecioPlato=" + PrecioPlato + ", CantidadPlatos="
				+ CantidadPlatos + ", CodigoMesa=" + CodigoMesa + "]";
	}
}
