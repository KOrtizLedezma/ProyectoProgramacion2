package receta.view;

import java.util.Scanner; 

import receta.entity.Receta;

public class registrarReceta {

	public static Receta ingresar (Scanner scanner) {
		
		int CodigoPlato = InputTypes.readInt("Ingresar el codigo del plato: ", scanner);
		
		int CodigoInsumo = InputTypes.readInt("Ingresar el codigo del insumo: ", scanner);
		
		int CantidadInsumo = InputTypes.readInt("Ingresar la cantidad del insumo: ", scanner);
		 
		return new Receta(CodigoPlato, CodigoInsumo, CantidadInsumo); 
		
		
	}
}
