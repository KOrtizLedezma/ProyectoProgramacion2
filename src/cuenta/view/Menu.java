package cuenta.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import cliente.view.RegistrarClientes;
import cuenta.entity.NoExisteCuenta;
import mesa.entity.NoExisteMesa;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Cuenta");
			System.out.println("2. Listar Cuentas ");
			System.out.println("3. Listar Cuentas y entidades ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroCuentas registroCuentas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroCuentas.add();
				break;
			case 2:
				try {
					registroCuentas.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroCuentas.listClienteMesa();
				} catch (NoExisteCliente | SQLException | NoExisteCuenta | NoExisteMesa e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
