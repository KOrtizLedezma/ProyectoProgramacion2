package plato.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import plato.entity.NoExistePlato;
import plato.entity.Plato;
import receta.entity.NoExisteReceta;
import receta.entity.Receta;
import receta.view.InputTypes;


public class RegistroPlatos {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroPlatos(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		Plato plato = RegistroPlato.ingresar(scanner);
		String sql = "Insert into Plato (CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato) values(?,?,?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, plato.getCodigoPlato());
				conexion.getSentencia().setString(2, plato.getNombre());
				conexion.getSentencia().setDouble(3, plato.getPrecio());
				conexion.getSentencia().setString(4, plato.getTamaño());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void delete() {
		int CodigoPlato = InputTypes.readInt("Código del Plato: ", scanner);
		String sql = "delete from Plato where código = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoPlato);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExistePlato {
		ResultSet resultSet;
		Plato plato;
		String TamañoPlato;
		String NombrePlato;
		double PrecioPlato;
		int CodigoPlato = InputTypes.readInt("Código del plato: ", scanner);
		String sql = "select * from plato where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			TamañoPlato = resultSet.getString("TamañoPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato);
		} else {
			throw new NoExistePlato();
		}

		System.out.println(plato);
		Menu.menúModificar(scanner, plato);

		sql = "update plato set CodigoPlato= ?, NombrePlato = ?, PrecioPlato = ?, TamañoPlato = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, plato.getCodigoPlato());
		conexion.getSentencia().setString(2, plato.getNombre());
		conexion.getSentencia().setDouble(3, plato.getPrecio());
		conexion.getSentencia().setString(4, plato.getTamaño());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Plato plato;
		String sql = "select * from plato ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			plato = new Plato(resultSet.getInt("CodigoPlato"), resultSet.getString("NombrePlato"),
					resultSet.getDouble("PrecioPlato"), resultSet.getString("TamañoPlato"));
			System.out.println(plato);
		}
	}
	
	public void listRecetas() throws NoExistePlato, SQLException, NoExisteReceta {
		
		ResultSet resultSet;
		Plato plato;
		int CodigoPlato;
		String NombrePlato;
		Double PrecioPlato;
		String TamañoPlato;
		int CodigoInsumo;
		int CantidadInsumo;
		int CodigoReceta;
		int Codigo = InputTypes.readInt("Código del Plato: ", scanner);
		String sql = "select * from plato where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, Codigo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			TamañoPlato = resultSet.getString("TamañoPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato);
		} else {
			throw new NoExistePlato();
		}
		System.out.println(plato);

		Receta receta;

		sql = "select * from receta where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
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
