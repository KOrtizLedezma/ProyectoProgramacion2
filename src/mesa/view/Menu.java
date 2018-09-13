package mesa.view;

import java.sql.SQLException;
import java.util.Scanner;

import mesa.entity.Mesa;

public class Menu {

	/****************************
	 * Encabezado del men� *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Mesa");
			System.out.println("2. Listar Mesa ");
			System.out.println("3. Eliminar Mesa ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void men�(Scanner scanner, RegistroMesas registroMesas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroMesas.add();
				break;
			case 2:
				try {
					registroMesas.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				registroMesas.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigoMesa");
			System.out.println("2. Modificar cuenta ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void men�Modificar(Scanner scanner, Mesa mesa) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				mesa.setCodigoMesa(InputTypes.readInt("Ingrese el nuevo codigo de la mesa: ", scanner));
				break;
			case 2:
				mesa.setCuenta(InputTypes.readInt("Ingrese la nueva cuenta: ", scanner));
				break;
		}
	  }
	}

}
