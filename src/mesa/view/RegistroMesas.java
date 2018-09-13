package mesa.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;

public class RegistroMesas {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroMesas(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		Mesa mesa = RegistroMesa.ingresar(scanner);
		String sql = "Insert into Producto (codigoMesa, cuenta) values(?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, mesa.getCodigoMesa());
				conexion.getSentencia().setInt(2, mesa.getCuenta());
				conexion.modificacion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void delete() {
		int codigoMesa = InputTypes.readInt("Código de la Mesa: ", scanner);
		String sql = "delete from producto where código = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoMesa);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExisteMesa {
		ResultSet resultSet;
		Mesa mesa;
		int cuenta;
		int codigoMesa = InputTypes.readInt("Código de la Mesa: ", scanner);
		String sql = "select * from mesa where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cuenta = resultSet.getInt("cuenta");
			codigoMesa = resultSet.getInt("codigoMesa");
			mesa = new Mesa(cuenta, codigoMesa);
		} else {
			throw new NoExisteMesa();
		}

		System.out.println(mesa);
		Menu.menúModificar(scanner, mesa);

		sql = "update producto set nombre = ?, precio = ?, descripción = ?, códigoCategoría = ?  where código = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, mesa.getCuenta());
		conexion.getSentencia().setInt(2, mesa.getCodigoMesa());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Mesa mesa;
		String sql = "select * from producto ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			mesa = new Mesa(resultSet.getInt("cuenta"), resultSet.getInt("codigoMesa"));
			System.out.println(mesa);
		}
	}

	public void listCatogories() throws NoExisteMesa, SQLException {
		ResultSet resultSet;
		Mesa mesa;
		int cuenta;
		int codigoMesa = InputTypes.readInt("Código de la Mesa: ", scanner);
		String sql = "select * from producto where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cuenta = resultSet.getInt("Cuenta");
			codigoMesa = resultSet.getInt("códigoMesa");
			mesa = new Mesa(cuenta,codigoMesa);
		} else {
			throw new NoExisteMesa();
		}
		System.out.println(mesa);

	}
}
