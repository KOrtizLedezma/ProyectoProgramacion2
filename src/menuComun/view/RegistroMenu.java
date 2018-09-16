package menuComun.view;

import java.util.Scanner;

import menuComun.entity.MenuComun;

public class RegistroMenu {

	public static MenuComun Ingresar(Scanner scanner) 
	{
	 int CodigoMenu = InputTypes.readInt("Ingrese el codigo de Menu: ", scanner);
	 
	 int codigoPlato =InputTypes.readInt("Ingrese el codigo Plato: ", scanner);
	 
	 String NombrePlato = InputTypes.readString("Ingrese el nombre del Plato: ", scanner);
	 
	 String Fecha = InputTypes.readString("Ingrese la Fecha: ", scanner);
	 
	 return new MenuComun(CodigoMenu, codigoPlato, NombrePlato, Fecha);
	 }

}
