package detalleVenta.view;

import java.util.Scanner;

import detalleVenta.entity.DetalleVenta;

public class RegistroDetalleVenta {
	
	public static DetalleVenta Ingresar(Scanner scanner) 
	{
		
	 int CodigoPlato = InputTypes.readInt("Ingrese el codigo de plato:", scanner);
	 
	 int CantidadPlato =InputTypes.readInt("Ingrese la cantidad de platos:", scanner);

	 return new DetalleVenta(CodigoPlato, CantidadPlato);
	 }
}
