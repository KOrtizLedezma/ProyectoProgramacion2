package cliente.entity;

public class Cliente {

	private int nitCliente;
	private int cantidadPlatos;
	private int codigoPlato;
	private int codigoPlatoEspecial;
	private String nombreNit;
	
	public Cliente(int nitCliente, int cantidadPlatos, int codigoPlato, int codigoPlatoEspecial, String nombreNit) {
		super();
		this.nitCliente = nitCliente;
		this.cantidadPlatos = cantidadPlatos;
		this.codigoPlato = codigoPlato;
		this.codigoPlatoEspecial = codigoPlatoEspecial;
		this.nombreNit = nombreNit;
	}

	public int getNitCliente() {
		return nitCliente;
	}

	public void setNitCliente(int nitCliente) {
		this.nitCliente = nitCliente;
	}

	public int getCantidadPlatos() {
		return cantidadPlatos;
	}

	public void setCantidadPlatos(int cantidadPlatos) {
		this.cantidadPlatos = cantidadPlatos;
	}

	public int getCodigoPlato() {
		return codigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.codigoPlato = codigoPlato;
	}

	public int getCodigoPlatoEspecial() {
		return codigoPlatoEspecial;
	}

	public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
		this.codigoPlatoEspecial = codigoPlatoEspecial;
	}

	public String getNombreNit() {
		return nombreNit;
	}

	public void setNombreNit(String nombreNit) {
		this.nombreNit = nombreNit;
	}

	@Override
	public String toString() {
		return "Cliente [nitCliente=" + nitCliente + ", cantidadPlatos=" + cantidadPlatos + ", codigoPlato="
				+ codigoPlato + ", codigoPlatoEspecial=" + codigoPlatoEspecial + ", nombreNit=" + nombreNit + "]";
	}
}
