package menuDia.view;

import java.util.Scanner;

import menuDia.entity.MenuDia;

public class RegistroMenuDia {

	public static MenuDia Ingresar(Scanner scanner) 
	{
	 int CodigoMenuEspecial = InputTypes.readInt("Ingrese el codigo del Menu Especial: ", scanner);
	 
	 int CodigoPlatoEspecial =InputTypes.readInt("Ingrese el codigo del Plato Especial: ", scanner);
	 
	 String Fecha = InputTypes.readString("Ingrese la fecha", scanner);
	 
	 return new MenuDia(CodigoMenuEspecial, Fecha, CodigoPlatoEspecial);
	 }
}
