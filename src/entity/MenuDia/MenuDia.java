package entity.MenuDia;

public class MenuDia {
 private int CodigoMenuEspecial;
 private String Fecha;
public MenuDia(int codigoMenuEspecial, String fecha) {
	super();
	CodigoMenuEspecial = codigoMenuEspecial;
	Fecha = fecha;
}
public int getCodigoMenuEspecial() {
	return CodigoMenuEspecial;
}
public void setCodigoMenuEspecial(int codigoMenuEspecial) {
	CodigoMenuEspecial = codigoMenuEspecial;
}
public String getFecha() {
	return Fecha;
}
public void setFecha(String fecha) {
	Fecha = fecha;
}
 
}
