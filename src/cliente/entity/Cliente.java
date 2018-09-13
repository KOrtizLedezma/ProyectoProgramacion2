package cliente.entity;

public class Cliente {

	private int NitCliente;
	private int CantidadPlatos;
	private int CodigoPlato;
	private int CodigoPlatoEspecial;
	private String NombreNit;
	
	public Cliente(int NitCliente, int CantidadPlatos, int CodigoPlato, int CodigoPlatoEspecial, String NombreNit) {
		super();
		this.NitCliente = NitCliente;
		this.CantidadPlatos = CantidadPlatos;
		this.CodigoPlato = CodigoPlato;
		this.CodigoPlatoEspecial = CodigoPlatoEspecial;
		this.NombreNit = NombreNit;
	}

	public int getNitCliente() {
		return NitCliente;
	}

	public void setNitCliente(int nitCliente) {
		this.NitCliente = nitCliente;
	}

	public int getCantidadPlatos() {
		return CantidadPlatos;
	}

	public void setCantidadPlatos(int cantidadPlatos) {
		this.CantidadPlatos = cantidadPlatos;
	}

	public int getCodigoPlato() {
		return CodigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}

	public int getCodigoPlatoEspecial() {
		return CodigoPlatoEspecial;
	}

	public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
		this.CodigoPlatoEspecial = codigoPlatoEspecial;
	}

	public String getNombreNit() {
		return NombreNit;
	}

	public void setNombreNit(String nombreNit) {
		this.NombreNit = nombreNit;
	}

	@Override
	public String toString() {
		return "Cliente [nitCliente=" + NitCliente + ", cantidadPlatos=" + CantidadPlatos + ", codigoPlato="
				+ CodigoPlato + ", codigoPlatoEspecial=" + CodigoPlatoEspecial + ", nombreNit=" + NombreNit + "]";
	}
}
