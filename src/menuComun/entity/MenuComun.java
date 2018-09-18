package menuComun.entity;

public class MenuComun {

	private int CodigoMenu;
	private int CodigoPlato;
	private String NombrePlato;
	private String Fecha;
	 
	public MenuComun(int CodigoMenu, int CodigoPlato, String NombrePlato, String Fecha) {
		super();
		this.CodigoMenu = CodigoMenu;
		this.CodigoPlato = CodigoPlato;
		this.NombrePlato = NombrePlato;
		this.Fecha = Fecha;
	}
	public String getNombrePlato() {
		return NombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
		this.NombrePlato = nombrePlato;
	}
	public int getCodigoMenu() {
		return CodigoMenu;
	}
	public void setCodigoMenu(int codigoMenu) {
		this.CodigoMenu = codigoMenu;
	}
	public int getCodigoPlato() {
		return CodigoPlato;
	}
	public void setCodigoPlato(int codigoPlato) {
		this.CodigoPlato = codigoPlato;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		this.Fecha = fecha;
	}
	@Override
	public String toString() {
		return "MenuComun [CodigoMenu=" + CodigoMenu + ", CodigoPlato=" + CodigoPlato + ", NombrePlato=" + NombrePlato
				+ ", Fecha=" + Fecha + "]";
	}

}
