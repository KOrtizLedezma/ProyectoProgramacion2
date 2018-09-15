package mesa.view;

import java.sql.SQLException;
import java.util.Scanner;

import cuenta.entity.NoExisteCuenta;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;
import mesero.entity.NoExisteMesero;

public class Menu {

	/****************************
	 * Encabezado del menú *
	 ****************************/

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Mesa");
			System.out.println("2. Listar Mesa ");
			System.out.println("3. Listar Mesa y entidades ");
			System.out.println("4. Eliminar Mesa ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroMesas registroMesas) {
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
				try {
					registroMesas.listCuentaMesero();
				} catch (NoExisteMesa | SQLException | NoExisteMesero | NoExisteCuenta e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
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

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Mesa mesa) {
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
