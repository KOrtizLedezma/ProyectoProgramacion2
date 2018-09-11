package cuenta.view;

import java.util.Scanner;

import entity.cuenta.Cuenta;
import insumos.view.InputTypes;

public class RegistroCuenta {
	public static Cuenta Ingresar(Scanner scanner) 
	{
	 int NitCliente = InputTypes.readInt("Ingrese el NIT de cliente", scanner);
	 double PrecioPlato =InputTypes.readInt("Ingrese el  precio del plato:", scanner);
	 int CantidadPlatos = InputTypes.readInt("Ingrese la cantidad de platos", scanner);

	 return new Cuenta(NitCliente, PrecioPlato, CantidadPlatos);
	 }
}
