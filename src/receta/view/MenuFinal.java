package receta.view;

import java.sql.SQLException;
import java.util.Scanner;

import insumos.entity.NoExisteInsumo;
import menuComun.entity.NoExisteMenu;
import menuDia.entity.NoExisteMenuDia;
import mesa.entity.NoExisteMesa;
import mesero.entity.NoExisteMesero;
import plato.entity.NoExistePlato;
import platoEspecial.entity.NoExistePlatoEspecial;
import receta.entity.NoExisteReceta;
import receta.view.InputTypes;

public class MenuFinal {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Recetas ");
			System.out.println("2. Modificar Recetas ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void men�(Scanner scanner, RegistrarRecetas registrarRecetas) {
		boolean salir = false;
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				Menu.men�(scanner, registrarRecetas);
				break;
			case 2:
				try {
					registrarRecetas.update();
				} catch (SQLException | NoExisteReceta e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
