package platoEspecial.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import menuComun.entity.MenuComun;
import menuComun.entity.NoExisteMenu;
import menuDia.entity.NoExisteMenuDia;
import plato.entity.NoExistePlato;
import plato.entity.Plato;
import platoEspecial.entity.NoExistePlatoEspecial;
import platoEspecial.entity.PlatoEspecial;
import receta.entity.NoExisteReceta;
import receta.entity.Receta;
import receta.view.InputTypes;

public class RegistroPlatosEspeciales {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroPlatosEspeciales(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		PlatoEspecial platoEspecial = RegistroPlatoEspecial.ingresar(scanner);
		String sql = "Insert into platoespecial (CodigoPlatoEspecial, NombrePlato, PrecioPlato) values(?,?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, platoEspecial.getCodigoPlatoEspecial());
				conexion.getSentencia().setString(2, platoEspecial.getNombrePlato());
				conexion.getSentencia().setDouble(3, platoEspecial.getPrecioPlato());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void delete() {
		int CodigoPlatoEspecial = InputTypes.readInt("Código del Plato Especial: ", scanner);
		String sql = "delete from platoespecial where CodigoPlatoEspecial = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoPlatoEspecial);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	
	public void update() throws SQLException, NoExistePlatoEspecial {
		ResultSet resultSet;
		PlatoEspecial platoEspecial;
		String NombrePlato;
		double PrecioPlato;
		int CodigoPlatoEspecial = InputTypes.readInt("Código del plato especial: ", scanner);
		String sql = "select * from platoespecial where CodigoPlatoEspecial = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlatoEspecial);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			platoEspecial = new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlato);
		} else {
			throw new NoExistePlatoEspecial();
		}

		System.out.println(platoEspecial);
		Menu.menúModificar(scanner, platoEspecial);

		sql = "update platoespecial set CodigoPlatoEspecial= ?, NombrePlato = ?, PrecioPlato = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, platoEspecial.getCodigoPlatoEspecial());
		conexion.getSentencia().setString(2, platoEspecial.getNombrePlato());
		conexion.getSentencia().setDouble(3, platoEspecial.getPrecioPlato());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		PlatoEspecial platoEspecial;
		String sql = "select * from platoespecial ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			platoEspecial = new PlatoEspecial(resultSet.getInt("CodigoPlatoEspecial"), resultSet.getString("NombrePlato"),
					resultSet.getDouble("PrecioPlato"));
			System.out.println(platoEspecial);
		}
	}
}
