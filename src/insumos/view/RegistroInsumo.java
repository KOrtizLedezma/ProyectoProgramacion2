package insumos.view;

import java.util.Scanner;

import insumos.entity.Insumos;

public class RegistroInsumo {

	public static Insumos ingresar (Scanner scanner) {
		
		int codigoInsumo = InputTypes.readInt("Ingrese el codigo del Insumo ", scanner);
		
		int cantidadInsumo = InputTypes.readInt("Ingrese la cantidad del Insumo ", scanner);
		
		String nombre = InputTypes.readString("Ingrese el nombre del Insumo", scanner);
		
		return new Insumos(codigoInsumo, cantidadInsumo, nombre) ;
	}
}
