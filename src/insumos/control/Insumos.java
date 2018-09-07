package insumos.control;

import insumos.entity.Insumo;

public class Insumos {

	private Insumo [] insumos; 
	private int cantidad;
	private int ultimo;
	
	public Insumos (int tamaño) {
		insumos = new Insumo[tamaño];
		cantidad = 0;
		ultimo = -1;
	}
	
	public void ingresar(Insumo insumo) throws java.lang.ArrayIndexOutOfBoundsException {
		insumos[++ultimo] = insumo;
		cantidad++;
	}
	
	public void eliminar(int codigoInsumos) {
		int indice = buscar(codigoInsumos);
		
		if (indice >= 0) {
			if(indice != ultimo) {
				for(int i=indice; i<=ultimo; i++) {
					insumos[i]= insumos[i+1];
				}
			}
			ultimo--;
			cantidad--;
		}
	}
	
	private int buscar(int codigoInsumos) {
		int indice = -1;
		int i = 0;
		
		while ( i <= ultimo) {
			if (codigoInsumos == insumos[i].getCodigoInsumos()) {
				indice = i;
				break;
			}
			i++;
		}
		return indice;	
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public Insumo[] getInsumos() {
		return insumos;
	}
}
