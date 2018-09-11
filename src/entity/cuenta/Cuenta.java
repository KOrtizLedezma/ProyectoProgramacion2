package entity.cuenta;

public class Cuenta {
 private int NitCliente;
 private double PrecioPlato;
 private int CantidadPlatos;
public Cuenta(int nitCliente, double precioPlato, int cantidadPlatos) {
	super();
	NitCliente = nitCliente;
	PrecioPlato = precioPlato;
	CantidadPlatos = cantidadPlatos;
}
public int getNitCliente() {
	return NitCliente;
}
public void setNitCliente(int nitCliente) {
	NitCliente = nitCliente;
}
public double getPrecioPlato() {
	return PrecioPlato;
}
public void setPrecioPlato(double precioPlato) {
	PrecioPlato = precioPlato;
}
public int getCantidadPlatos() {
	return CantidadPlatos;
}
public void setCantidadPlatos(int cantidadPlatos) {
	CantidadPlatos = cantidadPlatos;
}
 
}
