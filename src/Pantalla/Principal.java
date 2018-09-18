package Pantalla;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);

			try {
				Pantalla.Menu.menú(scanner);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			scanner.close(); 
		}
	//Tiene que dar
	//Esto solo es una prueba
	
	
}
