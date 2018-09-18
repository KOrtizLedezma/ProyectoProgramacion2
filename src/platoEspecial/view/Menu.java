package platoEspecial.view;

import java.sql.SQLException;
import java.util.Scanner;

import platoEspecial.entity.PlatoEspecial;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Plato Especial");
			System.out.println("2. Listar Platos Especiales");
			System.out.println("3. Eliminar Plato Especial");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroPlatosEspeciales registroPlatosEspeciales) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroPlatosEspeciales.add();
				break;
			case 2:
				try {
					registroPlatosEspeciales.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				registroPlatosEspeciales.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigo del Plato Especial");
			System.out.println("2. Modificar nombre del Plato Especial");
			System.out.println("3. Modificar precio del Plato Especial");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, PlatoEspecial platoEspecial) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				platoEspecial.setCodigoPlatoEspecial(InputTypes.readInt("Ingrese el nuevo codigo del plato: ", scanner));
				break;
			case 2:
				platoEspecial.setNombrePlato(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				platoEspecial.setPrecioPlato(InputTypes.readDouble("Ingrese el nuevo precio: ", scanner));
				break;
			}
		}
	}
}
