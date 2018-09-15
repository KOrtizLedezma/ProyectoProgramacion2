package menuDia.entity;

public class MenuDia {

	private int CodigoMenuEspecial;
	private String Fecha;
	private int CodigoPlatoEspecial;
	
	public MenuDia(int codigoMenuEspecial, String fecha, int codigoPlatoEspecial) {
		super();
		CodigoMenuEspecial = codigoMenuEspecial;
		Fecha = fecha;
		CodigoPlatoEspecial = codigoPlatoEspecial;
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
	public int getCodigoPlatoEspecial() {
		return CodigoPlatoEspecial;
	}
	public void setCodigoPlatoEspecial(int codigoPlatoEspecial) {
		CodigoPlatoEspecial = codigoPlatoEspecial;
	}
	
	 
}
