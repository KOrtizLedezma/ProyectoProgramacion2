package detalleVenta.entity;

public class DetalleVenta {

	private int CodigoPlato;
    private int CantidadPlato;
	 
	public DetalleVenta(int CodigoPlato, int CantidadPlato) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.CantidadPlato = CantidadPlato;
	}
	public int getCodigoPlato() {
		return CodigoPlato;
	}
	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}
	public int getCantidadPlato() {
		return CantidadPlato;
	}
	public void setCantidadPlato(int cantidadPlato) {
		this.CantidadPlato = cantidadPlato;
	}
}
