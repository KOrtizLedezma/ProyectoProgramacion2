package menuComun.view;

import java.sql.SQLException;
import java.util.Scanner;

import menuComun.entity.NoExisteMenu;
import plato.entity.NoExistePlato;


public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Menu ");
			System.out.println("2. Listar Menus ");
			System.out.println("3. Listar Menus y sus entidades ");
			System.out.println("4. Eliminar Menus ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroMenus registroMenus) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroMenus.add();
				break;
			case 2:
				try {
					registroMenus.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroMenus.listPlato();
				} catch (NoExisteMenu | SQLException | NoExistePlato e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registroMenus.delete();
			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo del Menu");
			System.out.println("2. Modificar Codigo del plato dentro el menu ");
			System.out.println("3. Modificar Nombre del plato dentro el menu ");
			System.out.println("4. Modificar la fecha del menu del menu");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, menuComun.entity.MenuComun menu) {
		
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				menu.setCodigoMenu(InputTypes.readInt("Ingrese el nuevo Codigo del Menu: ", scanner));
				break;
			case 2:
				menu.setCodigoPlato(InputTypes.readInt("Ingrese el nuevo Codigo del plato dentro del Menu: ", scanner));
				break;
			case 3:
				menu.setNombrePlato(InputTypes.readString("Ingrese la nueva Nombre del plato dentro del Menu: ", scanner));
				break;
			case 4:
				menu.setFecha(InputTypes.readString("Ingrese la nueva Fecha del Menu: ", scanner));
			}
		}
	}

}
