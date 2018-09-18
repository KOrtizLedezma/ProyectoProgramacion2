package mesero.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;
import mesa.view.InputTypes;
import mesero.entity.Mesero;
import mesero.entity.NoExisteMesero;

public class RegistroMeseros {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroMeseros(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		Mesero mesero = RegistroMesero.ingresar(scanner);
		String sql = "Insert into mesero (CodigoMesero, CodigoMesa) values(?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, mesero.getCodigoMesero());
				conexion.getSentencia().setInt(2, mesero.getCodigoMesa());
				conexion.modificacion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void delete() {
		int CodigoMesero = InputTypes.readInt("Código del mesero: ", scanner);
		String sql = "delete from mesero where CodigoMesero = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoMesero);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExisteMesero {
		ResultSet resultSet;
		Mesero mesero;
		int CodigoMesa;
		int CodigoMesero = InputTypes.readInt("Código del Mesero: ", scanner);
		String sql = "select * from mesero where CodigoMesero = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesero);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMesero = resultSet.getInt("CodigoMesero");
			CodigoMesa = resultSet.getInt("CodigoMesa");
			mesero = new Mesero(CodigoMesero, CodigoMesa);
		} else {
			throw new NoExisteMesero();
		}

		System.out.println(mesero);
		Menu.menúModificar(scanner, mesero);

		sql = "update mesero set CodigoMesero = ?, CodigoMesa = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, mesero.getCodigoMesero());
		conexion.getSentencia().setInt(2, mesero.getCodigoMesa());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Mesero mesero;
		String sql = "select * from mesero ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			mesero = new Mesero(resultSet.getInt("CodigoMesa"), resultSet.getInt("CodigoMesero"));
			System.out.println(mesero);
		}
	}

	public void listMesa() throws NoExisteMesero, SQLException, NoExisteMesa {
		ResultSet resultSet;
		Mesero mesero;
		int CodigoMesa;
		int Cuenta;
		int CodigoMesero = InputTypes.readInt("Código del Mesero: ", scanner);
		String sql = "select * from mesero where CodigoMesero = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesero);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMesa = resultSet.getInt("CodigoMesa");
			CodigoMesero = resultSet.getInt("CodigoMesero");
			mesero = new Mesero(CodigoMesero, CodigoMesa);
		} else {
			throw new NoExisteMesero();
		}
		System.out.println(mesero);

		Mesa mesa;

		sql = "select * from mesa where CodigoMesa = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMesa = resultSet.getInt("CodigoMesa");
			Cuenta = resultSet.getInt("Cuenta");
			mesa = new Mesa(CodigoMesa, Cuenta);
			System.out.println(mesa);
		} else {
			throw new NoExisteMesa();
		}

	}
}
