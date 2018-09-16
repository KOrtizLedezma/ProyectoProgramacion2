package insumos.entity;

public class Insumo {

	private int CodigoInsumo;
	private int CantidadInsumo;
	private String NombreInsumo;
	 
	public Insumo(int CodigoInsumo, int CantidadInsumo, String NombreInsumo) {
		super();
		this.CantidadInsumo = CantidadInsumo;
		this.CodigoInsumo = CodigoInsumo;
		this.NombreInsumo = NombreInsumo;
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
	public String getNombreInsumo() {
		return NombreInsumo;
	}
	public void setNombreInsumo(String nombreInsumo) {
		NombreInsumo = nombreInsumo;
	}
	@Override
	public String toString() {
		return "Insumo [CodigoInsumo=" + CodigoInsumo + ", CantidadInsumo=" + CantidadInsumo + ", NombreInsumo="
				+ NombreInsumo + "]";
	}
	
}
