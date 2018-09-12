package mesa.view;

import java.util.Scanner;

import mesa.entity.Mesa;

public class RegistroMesa {

	public static Mesa ingresar (Scanner scanner){
		
		int cuenta = InputTypes.readInt("Ingrese la cuenta", scanner);
		
		return new Mesa (cuenta);
	}
}
