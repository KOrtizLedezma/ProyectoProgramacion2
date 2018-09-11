package entity.DetalleVenta;

public class DetalleVenta {
 private int codigoPlato;
 private int cantidadPlato;
public DetalleVenta(int codigoPlato, int cantidadPlato) {
	super();
	this.codigoPlato = codigoPlato;
	this.cantidadPlato = cantidadPlato;
}
public int getCodigoPlato() {
	return codigoPlato;
}
public void setCodigoPlato(int codigoPlato) {
	this.codigoPlato = codigoPlato;
}
public int getCantidadPlato() {
	return cantidadPlato;
}
public void setCantidadPlato(int cantidadPlato) {
	this.cantidadPlato = cantidadPlato;
}
 
}
