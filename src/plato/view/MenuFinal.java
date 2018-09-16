package plato.view;

import java.sql.SQLException;
import java.util.Scanner;

import insumos.entity.NoExisteInsumo;
import menuComun.entity.NoExisteMenu;
import menuDia.entity.NoExisteMenuDia;
import mesa.entity.NoExisteMesa;
import mesero.entity.NoExisteMesero;
import plato.entity.NoExistePlato;
import receta.view.InputTypes;

public class MenuFinal {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Platos ");
			System.out.println("2. Modificar Platos ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
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
				Menu.menú(scanner, registroPlatos);
				break;
			case 2:
				try {
					registroPlatos.update();
				} catch (SQLException | NoExistePlato e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
