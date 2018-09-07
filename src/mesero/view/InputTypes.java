package mesero.view;


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
}
