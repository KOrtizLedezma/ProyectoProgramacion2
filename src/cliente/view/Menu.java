package cliente.view;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.NoExisteCliente;
import cuenta.entity.NoExisteCuenta;
import cuenta.view.InputTypes;
import detalleVenta.entity.NoExisteDetalleVenta;
import detalleVenta.view.RegistroDetalleVentas;
import plato.entity.NoExistePlato;
import platoEspecial.entity.NoExistePlatoEspecial;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Clliente");
			System.out.println("2. Listar Cliente ");
			System.out.println("3. Listar Clientes y entidades ");
			System.out.println("4. Eliminar Clientes ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 4) {
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
			case 3:
				try {
					registrarClientes.listCuenta();
				} catch (NoExisteCliente | SQLException | NoExistePlato | NoExistePlatoEspecial | NoExisteCuenta e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 4:
				registrarClientes.delete();

			}
		}
	}
}
