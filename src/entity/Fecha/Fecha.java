package entity.Fecha;

public class Fecha {
 private String Fecha;
 private int codigoMenuEspecial;
public Fecha(String fecha, int codigoMenuEspecial) {
	super();
	Fecha = fecha;
	this.codigoMenuEspecial = codigoMenuEspecial;
	
}
public String getFecha() {
	return Fecha;
}
public void setFecha(String fecha) {
	Fecha = fecha;
}
public int getCodigoMenuEspecial() {
	return codigoMenuEspecial;
}
public void setCodigoMenuEspecial(int codigoMenuEspecial) {
	this.codigoMenuEspecial = codigoMenuEspecial;
}

}
