package plato.view;

import java.util.Scanner;
import plato.entity.Plato;

public class RegistroPlato {

	public static Plato ingresar (Scanner scanner) {
		
        int codigoPlato = InputTypes.readInt("Ingrese el codigo del Plato: ", scanner);
		
		String nombre = InputTypes.readString("Ingrese el nombre del Plato: ", scanner);
		
		double precio = InputTypes.readDouble("Ingrese el precio del Plato: ", scanner);
		
		String tama�o = InputTypes.readString("Ingrese el tama�o del Plato: ", scanner);
		
		
		return new Plato(codigoPlato, nombre, precio, tama�o) ;
	}
}
