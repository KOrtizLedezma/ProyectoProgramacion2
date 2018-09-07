package mesero.entity;

public class Mesero {

	private int codigoMesero;
	private int codigoMesa;
	
	public Mesero(int codigoMesero, int codigoMesa) {
		
		this.codigoMesero = codigoMesero;
		this.codigoMesa = codigoMesa;
	}

	public int getCodigoMesero() {
		return codigoMesero;
	}

	public void setCodigoMesero(int codigoMesero) {
		this.codigoMesero = codigoMesero;
	}

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	@Override
	public String toString() {
		return "Mesero [codigoMesero=" + codigoMesero + ", codigoMesa=" + codigoMesa + "]";
	}
	
}
