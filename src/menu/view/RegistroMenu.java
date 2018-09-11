package menu.view;

import java.util.Scanner;

import entity.menu.Menu;
import insumos.view.InputTypes;

public class RegistroMenu {
public static Menu Ingresar(Scanner scanner) 
{
 int codigoMenu = InputTypes.readInt("Ingrese el codigo de Menu:", scanner);
 int codigoPlato =InputTypes.readInt("Ingrese el codigo Plato:", scanner);
 String nombrePlato = InputTypes.readString("Ingrese el nombre del Plato", scanner);
 return new Menu(codigoMenu, codigoPlato, nombrePlato);
		 }
}
