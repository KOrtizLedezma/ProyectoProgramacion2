package detalleVenta.view;

import java.sql.SQLException;
import java.util.Scanner;

import cuenta.entity.NoExisteCuenta;
import cuenta.view.InputTypes;
import detalleVenta.entity.NoExisteDetalleVenta;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;
import mesa.view.RegistroMesas;
import mesero.entity.NoExisteMesero;
import plato.entity.NoExistePlato;

public class Menu {

	public static int encabezado(Scanner scanner) {
		int opcion;

		while (true) {
			System.out.println("Ingrese una opcion: ");
			System.out.println("------------------- ");
			System.out.println("1. Ingresar Detalle de Venta");
			System.out.println("2. Listar Detalles ");
			System.out.println("3. Listar Detalles y entidades ");
			System.out.println("0. Salir");
			System.out.println();

			opcion = InputTypes.readInt("¿Su opción? ", scanner);

			if (opcion >= 0 && opcion <= 3) {
				return opcion;
			}
		}
	}

	public static void menú(Scanner scanner, RegistroDetalleVentas registroDetalleVentas) {
		boolean salir = false;

		while (!salir) {
			switch (encabezado(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				registroDetalleVentas.add();
				break;
			case 2:
				try {
					registroDetalleVentas.list();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					registroDetalleVentas.listPlato();
				} catch (NoExistePlato | SQLException | NoExisteDetalleVenta e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			}
		}
	}
}
