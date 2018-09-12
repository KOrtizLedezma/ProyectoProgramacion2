package cuenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import entity.cuenta.Cuenta;


public class RegistroCuentas {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistroCuentas(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add()  {
		Cuenta cuenta = RegistroCuenta.Ingresar(scanner);
		String sql = "Insert into Cuenta (NitCliente, PrecioPlato, CantidadPlatos) values(?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, cuenta.getNitCliente());
				conexi�n.getSentencia().setDouble(2, cuenta.getPrecioPlato());
				conexi�n.getSentencia().setInt(3, cuenta.getCantidadPlatos());
				conexi�n.modificacion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 


	public void list() throws SQLException {
		Cuenta cuenta;
		String sql = "select * from producto ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			cuenta = new Cuenta(resultSet.getInt("NIT"), resultSet.getDouble("precio"), resultSet.getInt("Cantidad"));
			System.out.println(cuenta);
		}
	}

	
}
