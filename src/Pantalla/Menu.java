package Pantalla;

import java.sql.SQLException;
import java.util.Scanner;

import cliente.view.RegistrarClientes;
import control.Conexion;
import cuenta.view.RegistroCuentas;
import detalleVenta.view.RegistroDetalleVentas;
import insumos.view.RegistroInsumos;
import menuComun.view.RegistroMenus;
import menuDia.view.RegistroMenusDia;
import mesa.entity.Mesa;
import mesa.view.RegistroMesas;
import mesero.view.RegistroMeseros;
import plato.view.RegistroPlatos;
import platoEspecial.view.RegistroPlatosEspeciales;
import receta.view.RegistrarRecetas;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Cliente");
			System.out.println("2. Cuenta");
			System.out.println("3. Detalle de Venta");
			System.out.println("4. Insumo");
			System.out.println("5. Menu Comun");
			System.out.println("6. Menu Dia");
			System.out.println("7. Mesa ");
			System.out.println("8. Mesero ");
			System.out.println("9. Plato ");
			System.out.println("10. Plato Especial");
			System.out.println("11. Receta ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("�Su opci�n? ", scanner);

			if (opcion >= 0 && opcion <= 11) {
				return opcion;
			}
		}
	}

	public static void men�(Scanner scanner) throws ClassNotFoundException, SQLException {
		boolean salir = false;
		
		Conexion conexion = new Conexion("root","","restaurant");
		RegistrarClientes registroCliente = new RegistrarClientes(conexion, scanner);
		RegistroCuentas registroCuentas = new RegistroCuentas(conexion, scanner);
		RegistroDetalleVentas registroDetalleVentas = new RegistroDetalleVentas(conexion, scanner);
		RegistroInsumos registroInsumos = new RegistroInsumos(conexion, scanner);
		RegistroMenus registroMenus = new RegistroMenus(conexion, scanner);
		RegistroMenusDia registroMenusDia = new RegistroMenusDia(conexion, scanner); 
		RegistroMesas registrarMesas = new RegistroMesas(conexion, scanner);
		RegistroMeseros registroMeseros = new RegistroMeseros(conexion, scanner);
		RegistroPlatos registrarPlatos = new RegistroPlatos(conexion, scanner);
		RegistroPlatosEspeciales registroPlatosEspeciales = new RegistroPlatosEspeciales(conexion, scanner);
		RegistrarRecetas registrarRecetas = new RegistrarRecetas(conexion, scanner);
		
		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				cliente.view.Menu.men�(scanner, registroCliente);
				break;
			case 2:
				cuenta.view.Menu.men�(scanner, registroCuentas);
				break;
			case 3:
				detalleVenta.view.Menu.men�(scanner, registroDetalleVentas);
				break;
			case 4:
				insumos.view.Menu.men�(scanner, registroInsumos);
				//Falta el modificar
				break;
			case 5:
				menuComun.view.Menu.men�(scanner, registroMenus);
				//Falta el modificar
				break;
			case 6:
				menuDia.view.Menu.men�(scanner, registroMenusDia);
				//Falta el modificar
				break;
			case 7:
				mesa.view.Menu.men�(scanner, registrarMesas);
				//Falta el modificar
				break;
			case 8:
				mesero.view.Menu.men�(scanner, registroMeseros);
				//Falta el modificar
				break;
			case 9:
				plato.view.Menu.men�(scanner, registrarPlatos);
				//Falta el modificar
				break;
			case 10:
				platoEspecial.view.Menu.men�(scanner, registroPlatosEspeciales);
				//Falta el modificar
				break;
			case 11:
				receta.view.Menu.men�(scanner, registrarRecetas);
				//Falta el modificar
				break;
			
		}
		conexion.close();
	}
}
}
