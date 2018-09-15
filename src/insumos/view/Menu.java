package insumos.view;

import java.sql.SQLException; 
import java.util.Scanner;

import cuenta.entity.NoExisteCuenta;
import insumos.entity.Insumo;
import insumos.entity.NoExisteInsumo;
import mesa.entity.NoExisteMesa;
import mesa.view.RegistroMesas;
import mesero.entity.NoExisteMesero;
import receta.entity.NoExisteReceta;
import receta.view.InputTypes;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Insumo");
			System.out.println("2. Listar Insumos ");
			System.out.println("3. Listar Insumos y entidades ");
			System.out.println("4. Eliminar Insumo ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroInsumos registroInsumos) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroInsumos.add();
				break;
			case 2:
				try {
					registroInsumos.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroInsumos.listReceta();
				} catch (NoExisteInsumo | SQLException | NoExisteReceta e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registroInsumos.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar Codigo del Insumo");
			System.out.println("2. Modificar Cantidad del Insumo ");
			System.out.println("3. Modificar Nombre del Insumo ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Insumo insumo) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				insumo.setCodigoInsumo(InputTypes.readInt("Ingrese el nuevo Codigo del Insumo: ", scanner));
				break;
			case 2:
				insumo.setCantidadInsumo(InputTypes.readInt("Ingrese el nuevo Cantidad del Insumo: ", scanner));
				break;
			case 3:
				insumo.setNombreInsumo(InputTypes.readString("Ingrese la nueva Nombre del Insumo: ", scanner));
				break;
			}
		}
	}

}
