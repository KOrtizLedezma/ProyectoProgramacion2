package DetalleVenta.view;

import java.util.Scanner;

import entity.DetalleVenta.DetalleVenta;
import insumos.view.InputTypes;

public class RegistroDetalleVenta {
	public static DetalleVenta Ingresar(Scanner scanner) 
	{
	 int codigoPlato = InputTypes.readInt("Ingrese el codigo de plato:", scanner);
	 int cantidadPlato =InputTypes.readInt("Ingrese la cantidad de platos:", scanner);

	 return new DetalleVenta(codigoPlato, cantidadPlato);
	 }
}
