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
		String sql = "Insert into Mesero (codigoMesero, codigoMesa) values(?,?)";
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
		int codigoMesero = InputTypes.readInt("Código del mesero: ", scanner);
		String sql = "delete from mesero where código = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoMesero);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExisteMesero {
		ResultSet resultSet;
		Mesero mesero;
		int codigoMesa;
		int codigoMesero = InputTypes.readInt("Código del Mesero: ", scanner);
		String sql = "select * from mesero where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMesero);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoMesero = resultSet.getInt("codigoMesero");
			codigoMesa = resultSet.getInt("codigoMesa");
			mesero = new Mesero(codigoMesero, codigoMesa);
		} else {
			throw new NoExisteMesero();
		}

		System.out.println(mesero);
		Menu.menúModificar(scanner, mesero);

		sql = "update producto set codigoMesero = ?, codigoMesa = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, mesero.getCodigoMesero());
		conexion.getSentencia().setInt(2, mesero.getCodigoMesa());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Mesero mesero;
		String sql = "select * from Mesero ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			mesero = new Mesero(resultSet.getInt("codigoMesa"), resultSet.getInt("codigoMesero"));
			System.out.println(mesero);
		}
	}

	public void listMesa() throws NoExisteMesero, SQLException, NoExisteMesa {
		ResultSet resultSet;
		Mesero mesero;
		int codigoMesero;
		int codigoMesa;
		int cuenta;
		int codigo = InputTypes.readInt("Código del Mesero: ", scanner);
		String sql = "select * from mesero where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoMesa = resultSet.getInt("codigoMesa");
			codigoMesero = resultSet.getInt("codigoMesero");
			mesero = new Mesero(codigoMesero, codigoMesa);
		} else {
			throw new NoExisteMesero();
		}
		System.out.println(mesero);

		Mesa mesa;

		sql = "select * from mesa where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoMesa = resultSet.getInt("codigoMesa");
			cuenta = resultSet.getInt("cuenta");
			mesa = new Mesa(codigoMesa, cuenta);
			System.out.println(mesa);
		} else {
			throw new NoExisteMesa();
		}

	}
}
