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
			String sql = "Insert into Receta (CodigoPlato, CodigoInsumo, CantidadInsumo) values(?,?,?)";
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
			int CodigoPlato = InputTypes.readInt("Código de la receta: ", scanner);
			String sql = "delete from receta where código = ?";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, CodigoPlato);
				conexion.modificacion();
			} catch (SQLException e) {
				System.out.println(e.getSQLState());
			}
		}

		public void update() throws SQLException, NoExisteReceta {
			ResultSet resultSet;
			Receta receta;
			int CodigoInsumo;
			int CantidadInsumo;
			int CodigoPlato = InputTypes.readInt("Código del plato: ", scanner);
			String sql = "select * from receta where código = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoPlato);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				CodigoPlato = resultSet.getInt("CodigoPlato");
				CodigoInsumo = resultSet.getInt("CodigoInsumo");
				CantidadInsumo = resultSet.getInt("CantidadInsumo");
				receta = new Receta(CodigoPlato, CodigoInsumo, CantidadInsumo);
			} else {
				throw new NoExisteReceta();
			}

			System.out.println(receta);
			Menu.menúModificar(scanner, receta);

			sql = "update producto set CodigoPlato = ?, CodigoInsumo = ?, CantidadInsumo = ?";

			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, receta.getCodigoPlato());
			conexion.getSentencia().setInt(2, receta.getCodigoInsumo());
			conexion.getSentencia().setInt(3, receta.getCantidadInsumo());
			conexion.modificacion();
		}

		public void list() throws SQLException {
			Receta receta;
			String sql = "select * from receta ";
			conexion.consulta(sql);
			ResultSet resultSet = conexion.resultado();
			while (resultSet.next()) {
				receta = new Receta(resultSet.getInt("CodigoPlato"), resultSet.getInt("CodigoInsumo"), resultSet.getInt("CantidadInsumo"));
				System.out.println(receta);
			}
		}
		
		public void listRecetas() throws NoExistePlato, SQLException, NoExisteReceta {
			ResultSet resultSet;
			Receta receta;
			String NombrePlato;
			Double PrecioPlato;
			String TamañoPlato;
			int CodigoInsumo;
			int CantidadInsumo;
			int CodigoPlato;
			int Codigo = InputTypes.readInt("Código del Plato: ", scanner);
			String sql = "select * from receta where código = ?";
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, Codigo);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				CodigoPlato = resultSet.getInt("CodigoPlato");
				CodigoInsumo = resultSet.getInt("CodigoInsumo");
				CantidadInsumo = resultSet.getInt("CantidadInsumo");
				receta = new Receta(CodigoPlato, CodigoInsumo, CantidadInsumo);
			} else {
				throw new NoExisteReceta();
			}
			System.out.println(receta);

			Plato plato;

			sql = "select * from plato where código = ?"; 
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoPlato);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				CodigoPlato = resultSet.getInt("CodigoPlato");
				NombrePlato = resultSet.getString("NombrePlato");
				PrecioPlato = resultSet.getDouble("PrecioPlato");
				TamañoPlato = resultSet.getString("TamañoPlato");
				plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato);
				System.out.println(plato);
			} else {
				throw new NoExistePlato();
			}

		}
}
