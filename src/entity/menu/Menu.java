package entity.menu;

public class Menu {
 private int codigoMenu;
 private int codigoPlato;
 private String nombrePlato;
 private String fecha;
public Menu(int codigoMenu, int codigoPlato, String nombrePlato, String fecha) {
	super();
	this.codigoMenu = codigoMenu;
	this.codigoPlato = codigoPlato;
	this.nombrePlato = nombrePlato;
	this.fecha = fecha;
}
public String getNombrePlato() {
	return nombrePlato;
}
public void setNombrePlato(String nombrePlato) {
	this.nombrePlato = nombrePlato;
}
public int getCodigoMenu() {
	return codigoMenu;
}
public void setCodigoMenu(int codigoMenu) {
	this.codigoMenu = codigoMenu;
}
public int getCodigoPlato() {
	return codigoPlato;
}
public void setCodigoPlato(int codigoPlato) {
	this.codigoPlato = codigoPlato;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
 
 
}
