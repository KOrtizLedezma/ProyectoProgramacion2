package plato.view;

import java.sql.SQLException;
import java.util.Scanner;

import detalleVenta.entity.NoExisteDetalleVenta;
import menuComun.entity.NoExisteMenu;
import plato.entity.NoExistePlato;
import plato.entity.Plato;
import receta.entity.NoExisteReceta;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Plato");
			System.out.println("2. Listar Platos ");
			System.out.println("3. Listar Platos y sus entidades");
			System.out.println("4. Eliminar Plato ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroPlatos registroPlatos) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroPlatos.add();
				break;
			case 2:
				try {
					registroPlatos.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroPlatos.listRecetaMenuDetalle();
				} catch (NoExisteReceta | SQLException | NoExisteMenu | NoExisteDetalleVenta | NoExistePlato e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registroPlatos.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigo del Plato");
			System.out.println("2. Modificar nombre ");
			System.out.println("3. Modificar precio ");
			System.out.println("4. Modificar tamaño ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Plato plato) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				plato.setCodigoPlato(InputTypes.readInt("Ingrese el nuevo codigo del plato: ", scanner));
				break;
			case 2:
				plato.setNombre(InputTypes.readString("Ingrese el nuevo nombre: ", scanner));
				break;
			case 3:
				plato.setPrecio(InputTypes.readDouble("Ingrese el nuevo precio: ", scanner));
				break;
			case 4:
				plato.setTamaño(InputTypes.readString("Ingrese el nuevo tamaño: ", scanner));
				break;
			}
		}
	}
}
