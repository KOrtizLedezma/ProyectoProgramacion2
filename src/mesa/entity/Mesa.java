package mesa.entity;

public class Mesa {

	private int cuenta;
	private int codigoMesa;
	
	public Mesa(int cuenta, int codigoMesa) {
		super();
		this.codigoMesa = codigoMesa;
		this.cuenta = cuenta;
	}

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		cuenta = cuenta;
	}
	
}
