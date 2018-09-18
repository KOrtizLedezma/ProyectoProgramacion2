package mesero.view;

import java.sql.SQLException;
import java.util.Scanner;

import mesa.entity.NoExisteMesa;
import mesero.entity.Mesero;
import mesero.entity.NoExisteMesero;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Mesero");
			System.out.println("2. Listar Meseros ");
			System.out.println("3. Listar Meseros y sus entidades");
			System.out.println("4. Eliminar Mesero ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroMeseros registroMeseros) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroMeseros.add();
				break;
			case 2:
				try {
					registroMeseros.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroMeseros.listMesa();
				} catch (NoExisteMesero | SQLException | NoExisteMesa e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registroMeseros.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigo del mesero");
			System.out.println("2. Modificar codigo de la mesa ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Mesero mesero) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				mesero.setCodigoMesero(InputTypes.readInt("Ingrese el nuevo codigo del mesero: ", scanner));
				break;
			case 2:
				mesero.setCodigoMesa(InputTypes.readInt("Ingrese el nuevo codigo de la mesa: ", scanner));
				break;
			}
		}
	}

}
