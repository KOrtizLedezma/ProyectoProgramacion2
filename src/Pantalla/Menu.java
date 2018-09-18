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
		RegistroMesas registroMesas = new RegistroMesas(conexion, scanner);
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
				insumos.view.MenuFinal.men�(scanner, registroInsumos);
				break;
			case 5:
				menuComun.view.MenuFinal.men�(scanner, registroMenus);
				break;
			case 6:
				menuDia.view.MenuFinal.men�(scanner, registroMenusDia);
				break;
			case 7:
				mesa.view.MenuFinal.men�(scanner, registroMesas);
				break;
			case 8:
				mesero.view.MenuFinal.men�(scanner, registroMeseros);
				break;
			case 9:
				plato.view.MenuFinal.men�(scanner, registrarPlatos);
				break;
			case 10:
				platoEspecial.view.MenuFinal.men�(scanner, registroPlatosEspeciales);
				break;
			case 11:
				receta.view.MenuFinal.men�(scanner, registrarRecetas);
				break;
			
		}
		//conexion.close();
	}
}
}
