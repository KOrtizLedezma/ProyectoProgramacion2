package receta.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import insumos.entity.Insumo;
import insumos.entity.NoExisteInsumo;
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
			String sql = "Insert into receta (CodigoPlato, CodigoInsumo, CantidadInsumo) values(?,?,?)";
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
			int CodigoPlato = InputTypes.readInt("C�digo de la receta: ", scanner);
			String sql = "delete from receta where CodigoPlato = ?";
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
			int CodigoPlato = InputTypes.readInt("C�digo del plato: ", scanner);
			String sql = "select * from receta where CodigoPlato = ?";
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
			Menu.men�Modificar(scanner, receta);

			sql = "update receta set CodigoPlato = ?, CodigoInsumo = ?, CantidadInsumo = ?";

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
		
		public void listRecetasInsumo() throws NoExistePlato, SQLException, NoExisteReceta, NoExisteInsumo {
			ResultSet resultSet;
			Receta receta;
			String NombrePlato; String Tama�oPlato; String NombreInsumo;
			Double PrecioPlato;
			int CodigoInsumo; int CantidadInsumo;
			int CodigoPlato = InputTypes.readInt("C�digo del Plato: ", scanner);
			String sql = "select * from receta where CodigoPlato = ?";
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

			Plato plato;

			sql = "select * from plato where CodigoPlato = ?"; 
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoPlato);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				CodigoPlato = resultSet.getInt("CodigoPlato");
				NombrePlato = resultSet.getString("NombrePlato");
				PrecioPlato = resultSet.getDouble("PrecioPlato");
				Tama�oPlato = resultSet.getString("Tama�oPlato");
				plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, Tama�oPlato);
				System.out.println(plato);
			} else {
				throw new NoExistePlato();
			}
			
			Insumo insumo;

			sql = "select * from insumo where CodigoInsumo = ?"; 
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoInsumo);
			resultSet = conexion.resultado();
			if (resultSet.next()) {
				CodigoInsumo = resultSet.getInt("CodigoInsumo");
				CantidadInsumo = resultSet.getInt("CantidadInsumo");
				NombreInsumo = resultSet.getString("NombreInsumo");
				insumo = new Insumo(CodigoInsumo, CantidadInsumo, NombreInsumo);
				System.out.println(insumo);
			} else {
				throw new NoExisteInsumo();
			}

		}
}
