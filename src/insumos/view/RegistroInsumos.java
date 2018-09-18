package insumos.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import insumos.entity.Insumo;
import insumos.entity.NoExisteInsumo;
import receta.entity.NoExisteReceta;
import receta.entity.Receta;

public class RegistroInsumos {
 
	private Conexion conexion;
	private Scanner scanner;


	public RegistroInsumos(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		Insumo insumo = RegistroInsumo.Ingresar(scanner);
		String sql = "Insert into insumo (CodigoInsumo, CantidadInsumo, NombreInsumo) values(?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, insumo.getCodigoInsumo());
			conexion.getSentencia().setInt(2, insumo.getCantidadInsumo());
			conexion.getSentencia().setString(3, insumo.getNombreInsumo());
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		int CodigoInsumo = InputTypes.readInt("Código del Insumo: ", scanner);
		String sql = "delete from insumo where CodigoInsumo = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoInsumo);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExisteInsumo {
		ResultSet resultSet;
		Insumo insumo;
		String NombreInsumo;
		int CantidadInsumo;
		int CodigoInsumo = InputTypes.readInt("Código del Insumo: ", scanner);
		String sql = "select * from insumo where CodigoInsumo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoInsumo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoInsumo = resultSet.getInt("CodigoInsumo");
			CantidadInsumo = resultSet.getInt("CantidadInsumo");
			NombreInsumo = resultSet.getString("NombreInsumo");
			insumo = new Insumo(CodigoInsumo, CantidadInsumo, NombreInsumo);
		} else {
			throw new NoExisteInsumo();
		}

		System.out.println(insumo);
		Menu.menúModificar(scanner, insumo);

		sql = "update insumo set CodigoInsumo = ?, CantidadInsumo = ?, NombreInsumo = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, insumo.getCodigoInsumo());
		conexion.getSentencia().setInt(2, insumo.getCantidadInsumo());
		conexion.getSentencia().setString(3, insumo.getNombreInsumo());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Insumo insumo;
		String sql = "select * from insumo ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			insumo = new Insumo(resultSet.getInt("CodigoInsumo"), resultSet.getInt("CantidadInsumo"), 
					            resultSet.getString("NombreInsumo"));
			System.out.println(insumo);
		}
	}

	public void listReceta() throws NoExisteInsumo, SQLException, NoExisteReceta {
		ResultSet resultSet;
		Insumo insumo;
		int CantidadInsumo; int CodigoPlato;
		String NombreInsumo;
		int CodigoInsumo = InputTypes.readInt("Código de Insumo: ", scanner);
		String sql = "select * from insumo where CodigoInsumo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoInsumo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoInsumo = resultSet.getInt("CodigoInsumo");
			CantidadInsumo = resultSet.getInt("CantidadInsumo");
			NombreInsumo = resultSet.getString("NombreInsumo");
			insumo = new Insumo(CodigoInsumo, CantidadInsumo, NombreInsumo);
		} else {
			throw new NoExisteInsumo();
		}
		System.out.println(insumo);

		Receta receta;

		sql = "select * from receta where CodigoInsumo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoInsumo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			CodigoInsumo = resultSet.getInt("CodigoInsumo");
			CantidadInsumo = resultSet.getInt("CantidadInsumo");
			receta = new Receta(CodigoPlato, CodigoInsumo, CantidadInsumo);
			System.out.println(receta);
		} else {
			throw new NoExisteReceta();
		}

	}
}
