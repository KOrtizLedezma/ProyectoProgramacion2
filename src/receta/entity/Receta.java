package receta.entity;

public class Receta {

	private int codigoPlato;
	private int codigoInsumo;
	private int cantidadInsumo;
	
	public Receta(int codigoPlato, int codigoInsumo, int cantidadInsumo) {
		super();
		this.codigoPlato = codigoPlato;
		this.codigoInsumo = codigoInsumo;
		this.cantidadInsumo = cantidadInsumo;
	}

	public int getCodigoPlato() {
		return codigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.codigoPlato = codigoPlato;
	}

	public int getCodigoInsumo() {
		return codigoInsumo;
	}

	public void setCodigoInsumo(int codigoInsumo) {
		this.codigoInsumo = codigoInsumo;
	}

	public int getCantidadInsumo() {
		return cantidadInsumo;
	}

	public void setCantidadInsumo(int cantidadInsumo) {
		this.cantidadInsumo = cantidadInsumo;
	}
}
