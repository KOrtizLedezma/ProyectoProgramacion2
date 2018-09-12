package mesa.entity;

public class Mesa {

	private int Cuenta;
	
	public Mesa(int cuenta) {
		super();
		//this.codigoMesa = codigoMesa;
		Cuenta = cuenta;
	}

	public int getCuenta() {
		return Cuenta;
	}

	public void setCuenta(int cuenta) {
		Cuenta = cuenta;
	}
	
}
