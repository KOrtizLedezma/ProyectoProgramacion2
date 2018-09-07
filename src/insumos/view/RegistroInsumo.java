package insumos.view;

import java.util.Scanner;

import insumos.entity.Insumo;

public class RegistroInsumo {

	public static Insumo ingresar (Scanner scanner) {
		
		int codigoInsumo = InputTypes.readInt("Ingrese el codigo del Insumo ", scanner);
		
		int cantidadInsumo = InputTypes.readInt("Ingrese la cantidad del Insumo ", scanner);
		
		String nombre = InputTypes.readString("Ingrese el nombre del Insumo", scanner);
		
		return new Insumo(codigoInsumo, cantidadInsumo, nombre) ;
	}
}
