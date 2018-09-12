package insumos.view;

import java.util.Scanner;

import entity.insumos.Insumos;

public class RegistroInsumo {
 public static Insumos Ingresar (Scanner scanner)
 {
	 int cantidadInsumo = InputTypes.readInt("Ingrese la cantidad del insumo", scanner);
	return new Insumos(cantidadInsumo, cantidadInsumo);
 }
}
