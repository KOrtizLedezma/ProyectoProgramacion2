package cliente.view;

import java.util.Scanner;

import cliente.entity.Cliente;

public class RegistrarCliente {

	public static Cliente ingresar (Scanner scanner){
		
		int nitCliente = InputTypes.readInt("Ingrese el NIT del cliente ", scanner);
		
		int cantidadPlatos = InputTypes.readInt("Ingrese la cantidad de Platos ", scanner);
		
		int codigoPlato = InputTypes.readInt("Ingrese el codigo del Plato ", scanner);
		
		int codigoPlatoEspecial = InputTypes.readInt("Ingrese el codigo delplato Especial ", scanner);
		
		String nombreNit = InputTypes.readString("Ingrese el nombre del NIT ", scanner);
		
		return new Cliente(nitCliente, cantidadPlatos, codigoPlato, codigoPlatoEspecial, nombreNit);
	}
}
