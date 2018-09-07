package insumos.entity;

public class Insumos {

	private int codigoInsumos;
	private int cantidadInsumos;
	private String nombre;
	
	public Insumos(int codigoInsumos, int cantidadInsumos, String nombre) {
		super();
		this.codigoInsumos = codigoInsumos;
		this.cantidadInsumos = cantidadInsumos;
		this.nombre = nombre;
	}

	public int getCodigoInsumos() {
		return codigoInsumos;
	}

	public void setCodigoInsumos(int codigoInsumos) {
		this.codigoInsumos = codigoInsumos;
	}

	public int getCantidadInsumos() {
		return cantidadInsumos;
	}

	public void setCantidadInsumos(int cantidadInsumos) {
		this.cantidadInsumos = cantidadInsumos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Insumos [codigoInsumos=" + codigoInsumos + ", cantidadInsumos=" + cantidadInsumos + ", nombre=" + nombre
				+ "]";
	}
	
}
