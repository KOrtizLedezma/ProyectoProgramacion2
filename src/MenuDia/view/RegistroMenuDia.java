package MenuDia.view;

import java.util.Scanner;

import entity.MenuDia.MenuDia;
import insumos.view.InputTypes;

public class RegistroMenuDia {
	public static MenuDia Ingresar(Scanner scanner) 
	{
	 int CodigoMenuEspecial = InputTypes.readInt("Ingrese el codigo de Menu Especial", scanner);
	 String Fecha =InputTypes.readString("Ingrese la Fecha:", scanner);

	 return new MenuDia(CodigoMenuEspecial, Fecha);
	 }
}
