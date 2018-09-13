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
		String sql = "Insert into Plato (codigoPlato, nombre, precio, tamaño) values(?,?,?,?)";
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
		int codigoPlato = InputTypes.readInt("Código del plato: ", scanner);
		String sql = "delete from plato where código = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoPlato);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExistePlato {
		ResultSet resultSet;
		Plato plato;
		String tamaño;
		String nombre;
		double precio;
		int codigoPlato = InputTypes.readInt("Código del plato: ", scanner);
		String sql = "select * from plato where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoPlato = resultSet.getInt("codigoPlato");
			nombre = resultSet.getString("nombre");
			precio = resultSet.getDouble("precio");
			tamaño = resultSet.getString("Tamaño");
			plato = new Plato(codigoPlato, nombre, precio, tamaño);
		} else {
			throw new NoExistePlato();
		}

		System.out.println(plato);
		Menu.menúModificar(scanner, plato);

		sql = "update producto set codigoPlato= ?, nombre = ?, precio = ?, tamaño = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, plato.getCodigoPlato());
		conexion.getSentencia().setString(2, plato.getNombre());
		conexion.getSentencia().setDouble(3, plato.getPrecio());
		conexion.getSentencia().setString(4, plato.getTamaño());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Plato plato;
		String sql = "select * from Plato ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			plato = new Plato(resultSet.getInt("codigoPlato"), resultSet.getString("nombre"),
					resultSet.getDouble("precio"), resultSet.getString("tamaño"));
			System.out.println(plato);
		}
	}
	
	public void listRecetas() throws NoExistePlato, SQLException, NoExisteReceta {
		
		ResultSet resultSet;
		Plato plato;
		int codigoPlato;
		String nombre;
		Double precio;
		String tamaño;
		int codigoInsumo;
		int cantidadInsumo;
		int codigoReceta;
		int codigo = InputTypes.readInt("Código del Plato: ", scanner);
		String sql = "select * from plato where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoPlato = resultSet.getInt("codigoPlato");
			nombre = resultSet.getString("nombre");
			precio = resultSet.getDouble("precio");
			tamaño = resultSet.getString("tamaño");
			plato = new Plato(codigoPlato, nombre, precio, tamaño);
		} else {
			throw new NoExistePlato();
		}
		System.out.println(plato);

		Receta receta;

		sql = "select * from receta where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoPlato = resultSet.getInt("codigoPlato");
			codigoInsumo = resultSet.getInt("codigoInsumo");
			cantidadInsumo = resultSet.getInt("cantidadInsumo");
			receta = new Receta(codigoPlato, codigoInsumo, cantidadInsumo);
			System.out.println(receta);
		} else {
			throw new NoExisteReceta();
		}

	}
}
