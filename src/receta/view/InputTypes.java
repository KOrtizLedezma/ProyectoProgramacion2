package receta.view;


import java.util.Scanner;

public class InputTypes {

	public static int readInt (String msg, Scanner scanner) {
		int valor = 0;
		
		while(true) {
			try {
				System.out.print(msg);
				valor = scanner.nextInt();
				scanner.nextLine();
				break;
			}
			catch (java.util.InputMismatchException excepciones) { 
				System.out.println("Deben ser valores numericos");
				scanner.nextLine();
			}
		}
		return valor;
	}
	
	public static String readString (String msg, Scanner scanner) {
		String palabra = "          ";
		
		while(true) {
			try {
				System.out.print(msg);
				palabra = scanner.nextLine();
				break;
			}
			catch (java.util.InputMismatchException excepciones) { 
				System.out.println("Deben ser letras");
				scanner.nextLine();
			}
		}
		return palabra;
	}
	
	public static Double readDouble (String msg, Scanner scanner) {
		double valor = 0;
		
		while(true) {
			try {
				System.out.print(msg);
				valor = scanner.nextDouble();
				scanner.nextLine();
				break;
			}
			catch (java.util.InputMismatchException excepciones) { 
				System.out.println("Deben ser valores numericos");
				scanner.nextLine();
			}
		}
		return valor;
	}
	
}
