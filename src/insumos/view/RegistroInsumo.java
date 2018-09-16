package insumos.view;

import java.util.Scanner;

import insumos.entity.Insumo;

public class RegistroInsumo {

	public static Insumo Ingresar (Scanner scanner)
	 {
		int CodigoInsumo = InputTypes.readInt("Ingrese el codigo del Insumo: ", scanner);
		
		int CantidadInsumo = InputTypes.readInt("Ingrese la cantidad del Insumo: ", scanner);
		
		String NombreInsumo = InputTypes.readString("Ingrese el nombre del Insumo: ", scanner);
		
		return new Insumo(CodigoInsumo, CantidadInsumo, NombreInsumo);
	 }
}
