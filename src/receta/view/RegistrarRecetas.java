package receta.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import plato.entity.NoExistePlato;
import plato.entity.Plato;
import receta.entity.NoExisteReceta;
import receta.entity.Receta;
public class RegistrarRecetas {

		private Conexion conexion;
		private Scanner scanner;


		public RegistrarRecetas(Conexion conexion, Scanner scanner) {
			this.conexion = conexion;
			this.scanner = scanner;
		}

		public void add() {
			Receta receta = RegistrarReceta.ingresar(scanner);
			String sql = "Insert into Receta (codigoPlato, codigoInsumo, cantidadInsumo) values(?,?,?)";
				try {
					conexion.consulta(sql);
					conexion.getSentencia().setInt(1, receta.getCodigoPlato());
					conexion.getSentencia().setInt(2, receta.getCodigoInsumo());
					conexion.getSentencia().setInt(3, receta.getCantidadInsumo());
					conexion.modificacion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		public void delete() {
			int codigoPlato = InputTypes.readInt("Código de la receta: ", scanner);
			String sql = "delete from receta where código = ?";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, codigoPlato);
				conexion.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
		}

		public void update() throws SQLException, NoExisteReceta {
			ResultSet resultSet;
			Receta receta;
			int codigoInsumo;
			int cantidadInsumo;
			int codigoPlato = InputTypes.readInt("Código del plato: ", scanner);
			String sql = "select * from receta where código = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoPlato);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				codigoPlato = resultSet.getInt("codigoPlato");
				codigoInsumo = resultSet.getInt("codigoInsumo");
				cantidadInsumo = resultSet.getInt("cantidadInsumo");
				receta = new Receta(codigoPlato, codigoInsumo, cantidadInsumo);
			} else {
				throw new NoExisteReceta();
			}

			System.out.println(receta);
			Menu.menúModificar(scanner, receta);

			sql = "update producto set codigoPlato = ?, codigoInsumo = ?, cantidadInsumo = ?";

			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, receta.getCodigoPlato());
			conexion.getSentencia().setInt(2, receta.getCodigoInsumo());
			conexion.getSentencia().setInt(3, receta.getCantidadInsumo());
			conexion.modificacion();
		}

		public void list() throws SQLException {
			Receta receta;
			String sql = "select * from Receta ";
			conexion.consulta(sql);
			ResultSet resultSet = conexion.resultado();
			while (resultSet.next()) {
				receta = new Receta(resultSet.getInt("codigoPlato"), resultSet.getInt("codigoInsumo"), resultSet.getInt("cantidadInsumo"));
				System.out.println(receta);
			}
		}
		
		public void listRecetas() throws NoExistePlato, SQLException, NoExisteReceta {
			ResultSet resultSet;
			Receta receta;
			String nombre;
			Double precio;
			String tamaño;
			int codigoInsumo;
			int cantidadInsumo;
			int codigoPlato;
			int codigoReceta;
			int codigo = InputTypes.readInt("Código del Plato: ", scanner);
			String sql = "select * from receta where código = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigo);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				codigoPlato = resultSet.getInt("codigoPlato");
				codigoInsumo = resultSet.getInt("codigoInsumo");
				cantidadInsumo = resultSet.getInt("cantidadInsumo");
				receta = new Receta(codigoPlato, codigoInsumo, cantidadInsumo);
			} else {
				throw new NoExisteReceta();
			}
			System.out.println(receta);

			Plato plato;

			sql = "select * from Plato where código = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, codigoPlato);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				codigoPlato = resultSet.getInt("codigoPlato");
				nombre = resultSet.getString("nombre");
				precio = resultSet.getDouble("precio");
				tamaño = resultSet.getString("tamaño");
				plato = new Plato(codigoPlato, nombre, precio, tamaño);
				System.out.println(plato);
			} else {
				throw new NoExistePlato();
			}

		}
}
