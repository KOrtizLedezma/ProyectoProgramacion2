package detalleVenta.entity;

public class DetalleVenta {

	private int CodigoPlato;
	private int CodigoPlatoEspecial;
    private int CantidadPlato;
	 
	public DetalleVenta(int CodigoPlato,int CodigoPlatoEspecial , int CantidadPlato) {
		super();
		this.CodigoPlato = CodigoPlato;
		this.CodigoPlatoEspecial = CodigoPlatoEspecial;
		this.CantidadPlato = CantidadPlato;
	}
	public int getCodigoPlato() {
		return CodigoPlato;
	}
	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}
	public int getCodigoPlatoEspecial() {
		return CodigoPlatoEspecial;
	}
	public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
		this.CodigoPlatoEspecial = codigoPlatoEspecial;
	}
	public int getCantidadPlato() {
		return CantidadPlato;
	}
	public void setCantidadPlato(int cantidadPlato) {
		this.CantidadPlato = cantidadPlato;
	}
	@Override
	public String toString() {
		return "DetalleVenta [CodigoPlato=" + CodigoPlato + ", CodigoPlatoEspecial=" + CodigoPlatoEspecial
				+ ", CantidadPlato=" + CantidadPlato + "]";
	}
	
}
