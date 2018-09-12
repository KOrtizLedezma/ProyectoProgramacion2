package entity.insumos;

public class Insumos {
 private int codigoInsumo;
 private int cantidadInsumo;
public Insumos(int codigoInsumo, int cantidadInsumo) {
	super();
	this.cantidadInsumo = cantidadInsumo;
	this.codigoInsumo = codigoInsumo;
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