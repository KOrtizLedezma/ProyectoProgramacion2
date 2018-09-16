package receta.entity;

public class Receta {

	private int CodigoPlato;
	private int CodigoInsumo;
	private int CantidadInsumo;
	
	public Receta(int CodigoPlato, int CodigoInsumo, int CantidadInsumo) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.CodigoInsumo = CodigoInsumo;
		this.CantidadInsumo = CantidadInsumo;
	}

	public int getCodigoPlato() {
		return CodigoPlato;
	}

	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}

	public int getCodigoInsumo() {
		return CodigoInsumo;
	}

	public void setCodigoInsumo(int codigoInsumo) {
		this.CodigoInsumo = codigoInsumo;
	}

	public int getCantidadInsumo() {
		return CantidadInsumo;
	}

	public void setCantidadInsumo(int cantidadInsumo) {
		this.CantidadInsumo = cantidadInsumo;
	}

	@Override
	public String toString() {
		return "Receta [CodigoPlato=" + CodigoPlato + ", CodigoInsumo=" + CodigoInsumo + ", CantidadInsumo="
				+ CantidadInsumo + "]";
	}
	
}
