package cuenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import entity.cuenta.Cuenta;


public class RegistroCuentas {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistroCuentas(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add()  {
		Cuenta cuenta = RegistroCuenta.Ingresar(scanner);
		String sql = "Insert into Cuenta (NitCliente, PrecioPlato, CantidadPlatos) values(?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, cuenta.getNitCliente());
				conexión.getSentencia().setDouble(2, cuenta.getPrecioPlato());
				conexión.getSentencia().setInt(3, cuenta.getCantidadPlatos());
				conexión.modificacion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 


	public void list() throws SQLException {
		Cuenta cuenta;
		String sql = "select * from producto ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			cuenta = new Cuenta(resultSet.getInt("NIT"), resultSet.getDouble("precio"), resultSet.getInt("Cantidad"));
			System.out.println(cuenta);
		}
	}

	
}
