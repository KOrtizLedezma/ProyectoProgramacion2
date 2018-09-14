package Pantalla;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.view.RegistrarClientes;
import control.Conexion;
import mesa.entity.Mesa;
import mesa.view.RegistroMesas;
import mesero.view.RegistroMeseros;
import plato.view.RegistroPlatos;
import receta.view.RegistrarRecetas;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Cliente");
			System.out.println("2. Mesa ");
			System.out.println("3. Mesero ");
			System.out.println("4. Plato ");
			System.out.println("5. Receta ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 2) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexion = new Conexion("root","","restaurant");
		RegistrarClientes registroCliente = new RegistrarClientes(conexion, scanner);
		RegistroMesas registrarMesas = new RegistroMesas(conexion, scanner);
		RegistroMeseros registroMeseros = new RegistroMeseros(conexion, scanner);
		RegistroPlatos registrarPlatos = new RegistroPlatos(conexion, scanner);
		RegistrarRecetas registrarRecetas = new RegistrarRecetas(conexion, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				cliente.view.Menu.menú(scanner, registroCliente);
				break;
			case 2:
					mesa.view.Menu.menú(scanner, registrarMesas);
				break;
			case 3:
					mesero.view.Menu.menú(scanner, registroMeseros);
				break;
			
			case 4:
				    plato.view.Menu.menú(scanner, registrarPlatos);
				break;
			
			case 5:
					receta.view.Menu.menú(scanner, registrarRecetas);
				break;
			
		}
		conexion.close();
	}
}
}
