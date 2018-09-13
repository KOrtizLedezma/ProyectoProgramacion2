package mesero.entity;

public class Mesero {

	private int CodigoMesero;
	private int CodigoMesa;
	
	public Mesero(int codigoMesero, int codigoMesa) {
		
		this.CodigoMesero = codigoMesero;
		this.CodigoMesa = codigoMesa;
	}

	public int getCodigoMesero() {
		return CodigoMesero;
	}

	public void setCodigoMesero(int codigoMesero) {
		this.CodigoMesero = codigoMesero;
	}

	public int getCodigoMesa() {
		return CodigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.CodigoMesa = codigoMesa;
	}

	@Override
	public String toString() {
		return "Mesero [codigoMesero=" + CodigoMesero + ", codigoMesa=" + CodigoMesa + "]";
	}
	
}
