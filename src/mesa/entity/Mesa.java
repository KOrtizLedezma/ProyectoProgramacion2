package mesa.entity;

public class Mesa {

	private int Cuenta;
	private int CodigoMesa;
	
	public Mesa(int Cuenta, int CodigoMesa) {
		super();
		this.CodigoMesa = CodigoMesa;
		this.Cuenta = Cuenta;
	}

	public int getCodigoMesa() {
		return CodigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.CodigoMesa = codigoMesa;
	}

	public int getCuenta() {
		return Cuenta;
	}

	public void setCuenta(int cuenta) {
		this.Cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Mesa [Cuenta=" + Cuenta + ", CodigoMesa=" + CodigoMesa + "]";
	}
	
}
