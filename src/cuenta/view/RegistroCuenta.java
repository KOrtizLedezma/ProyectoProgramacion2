package cuenta.view;

import java.util.Scanner;

import cuenta.entity.Cuenta;

public class RegistroCuenta {
	
	public static Cuenta Ingresar(Scanner scanner) {
		
    int NitCliente = InputTypes.readInt("Ingrese el NIT de cliente: ", scanner);
    
    double PrecioPlato =InputTypes.readInt("Ingrese el  precio del plato: ", scanner);
    
	int CantidadPlatos = InputTypes.readInt("Ingrese la cantidad de platos: ", scanner);
	
	String NombrePlato = InputTypes.readString("Ingrese el nombre del Plato: ", scanner);
	
	int CodigoMesa = InputTypes.readInt("Ingrese el codigo de la mesa: ", scanner);

	return new Cuenta(NitCliente, PrecioPlato, CantidadPlatos, NombrePlato, CodigoMesa);
	}

}
