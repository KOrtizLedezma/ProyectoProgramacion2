package platoEspecial.view;

import java.util.Scanner;

import platoEspecial.entity.PlatoEspecial;

public class RegistroPlatoEspecial {

	public static PlatoEspecial ingresar(Scanner scanner) {
		
		int CodigoPlatoEspecial = InputTypes.readInt("Ingrese el codigo del plato especial: ", scanner);
		
		String NombrePlato = InputTypes.readString("Ingrese el nombre del plato especial: ", scanner);
	
		double PrecioPlato = InputTypes.readDouble("Ingrese el precio del plato especial: ", scanner);
	
		return new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlato);
	}
}
