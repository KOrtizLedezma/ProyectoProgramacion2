package Pantalla;

import java.sql.ResultSet;
import java.sql.SQLException;

import control.Conexion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		ResultSet resultSet;
		
		try {
			Conexion conexion = new Conexion("root", "", "neptuno");
			conexion.consulta("SELECT PRODUCTO, PRECIO_UNIDAD FROM PRODUCTOS");
			resultSet = conexion.resultado();
			while(resultSet.next()) {
				System.out.print(resultSet.getString("PRODUCTO"));
				System.out.print("\t");
				System.out.println(resultSet.getDouble("PRECIO_UNIDAD"));
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
