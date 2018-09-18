package plato.view;

import java.util.Scanner;
import plato.entity.Plato;

public class RegistroPlato {

	public static Plato ingresar (Scanner scanner) {
		
        int codigoPlato = InputTypes.readInt("Ingrese el codigo del Plato: ", scanner);
		
		String nombre = InputTypes.readString("Ingrese el nombre del Plato: ", scanner);
		
		double precio = InputTypes.readDouble("Ingrese el precio del Plato: ", scanner);
		
		String tamaño = InputTypes.readString("Ingrese el tamaño del Plato: ", scanner);
		
		
		return new Plato(codigoPlato, nombre, precio, tamaño) ;
	}
}
