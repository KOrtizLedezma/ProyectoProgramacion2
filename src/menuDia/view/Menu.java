package menuDia.view;

import java.sql.SQLException;
import java.util.Scanner;

import menuDia.entity.MenuDia;
import menuDia.entity.NoExisteMenuDia;
import platoEspecial.entity.NoExistePlatoEspecial;


public class Menu {
	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Menu Especial");
			System.out.println("2. Listar Menu Especiales ");
			System.out.println("3. Listar Menu Especial y sus entidades");
			System.out.println("4. Eliminar Menu Especial ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroMenusDia registroMenusDia) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroMenusDia.add();
				break;
			case 2:
				try {
					registroMenusDia.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroMenusDia.listPlatoEspecial();
				} catch (NoExisteMenuDia | SQLException | NoExistePlatoEspecial e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registroMenusDia.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo del Menu Especial");
			System.out.println("2. Modificar Codigo del plato dentro el menu Especial");
			System.out.println("3. Modificar la fecha del menu del menu Especial");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, MenuDia menuDia) {
		
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				menuDia.setCodigoMenuEspecial(InputTypes.readInt("Ingrese el nuevo Codigo del Menu Especial: ", scanner));
				break;
			case 2:
				menuDia.setCodigoPlatoEspecial(InputTypes.readInt("Ingrese el nuevo Codigo del plato dentro del Menu Especial: ", scanner));
				break;
			case 3:
				menuDia.setFecha(InputTypes.readString("Ingrese la nueva fecha del Menu Especial: ", scanner));
				break;
		}
	}

	}
}
