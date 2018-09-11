package DetalleVenta.view;

import java.util.Scanner;

import entity.DetalleVenta.DetalleVenta;
import insumos.view.InputTypes;

public class RegistroDetalleVenta {
	public static DetalleVenta Ingresar(Scanner scanner) 
	{
	 int codigoPlato = InputTypes.readInt("Ingrese el NIT de cliente", scanner);
	 int cantidadPlato =InputTypes.readInt("Ingrese el  precio del plato:", scanner);

	 return new DetalleVenta(codigoPlato, cantidadPlato);
	 }
}
