package entity.PlatoEspecial;

public class PlatoEspecial {
 private int CodigoPlatoEspecial;
 private String NombrePlato;
 private double PrecioPlatoEspecial;
public PlatoEspecial(int codigoPlatoEspecial, String nombrePlato, double precioPlatoEspecial) {
	super();
	CodigoPlatoEspecial = codigoPlatoEspecial;
	NombrePlato = nombrePlato;
	PrecioPlatoEspecial = precioPlatoEspecial;
}
public int getCodigoPlatoEspecial() {
	return CodigoPlatoEspecial;
}
public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
	CodigoPlatoEspecial = codigoPlatoEspecial;
}
public String getNombrePlato() {
	return NombrePlato;
}
public void setNombrePlato(String nombrePlato) {
	NombrePlato = nombrePlato;
}
public double getPrecioPlatoEspecial() {
	return PrecioPlatoEspecial;
}
public void setPrecioPlatoEspecial(double precioPlatoEspecial) {
	PrecioPlatoEspecial = precioPlatoEspecial;
}
 
}
