package mesero.view;

import java.util.Scanner;

import mesero.entity.Mesero;

public class RegistroMesero {

	public static Mesero ingresar(Scanner scanner) {
		
		int codigoMesero = InputTypes.readInt("Ingrese el codigo del mesero: ", scanner);
		
		int codigoMesa = InputTypes.readInt("Ingrese el codigo de la mesa: ", scanner);
		
		return new Mesero(codigoMesero, codigoMesa) ;
	}
}
