package PlatoEspecial.view;

import java.util.Scanner;

import entity.PlatoEspecial.PlatoEspecial;
import insumos.view.InputTypes;

public class RegistroPlatoEspecial {
public static PlatoEspecial Ingresar (Scanner scanner)
{
 int CodigoPlatoEspecial = InputTypes.readInt("Ingrese el codigo del plato", scanner)	;
 String NombrePlato = InputTypes.readString("Ingrese el nombre del palto", scanner);
 double PrecioPlatoEspecial = InputTypes.readDouble("Ingrese el precio del plato", scanner);

return new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlatoEspecial);
}
}
