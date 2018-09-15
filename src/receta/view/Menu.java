package receta.view;

import java.sql.SQLException;
import java.util.Scanner;

import insumos.entity.NoExisteInsumo;
import mesero.entity.Mesero;
import plato.entity.NoExistePlato;
import receta.entity.NoExisteReceta;
import receta.entity.Receta;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Receta");
			System.out.println("2. Listar Recetas ");
			System.out.println("2. Listar Recetas y sus entidades");
			System.out.println("3. Eliminar Recetas ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistrarRecetas registrarRecetas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registrarRecetas.add();
				break;
			case 2:
				try {
					registrarRecetas.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registrarRecetas.listRecetasInsumo();
				} catch (NoExistePlato | SQLException | NoExisteReceta | NoExisteInsumo e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				registrarRecetas.delete();
				break;

			}
		}
	}

	private static int encabezadoModificar(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Modificar codigo del plato");
			System.out.println("2. Modificar codigo del insumo ");
			System.out.println("3. Modificar cantidad del insumo ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menúModificar(Scanner scanner, Receta receta) {
		boolean salir = false;

		while (!salir) {
			switch (encabezadoModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				receta.setCodigoPlato(InputTypes.readInt("Ingrese el nuevo codigo del plato: ", scanner));
				break;
			case 2:
				receta.setCodigoInsumo(InputTypes.readInt("Ingrese el nuevo codigo del insumo: ", scanner));
				break;
			case 3:
				receta.setCantidadInsumo(InputTypes.readInt("Ingrese la nueva cantidad de insumos: ", scanner));
				break;
			}
		}
	}

}
