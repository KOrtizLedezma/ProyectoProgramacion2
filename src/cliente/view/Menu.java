package cliente.view;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Cliente");
			System.out.println("2. Listar Clientes ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistrarClientes registrarClientes) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
			    registrarClientes.add();
				break;
			case 2:
				try {
					registrarClientes.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
