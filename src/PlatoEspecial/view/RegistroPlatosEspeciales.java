package PlatoEspecial.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import entity.PlatoEspecial.NoExistePlatoEspecial;
import entity.PlatoEspecial.PlatoEspecial;
import insumos.view.InputTypes;



public class RegistroPlatosEspeciales {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistroPlatosEspeciales(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add()  {
		PlatoEspecial platoespecial = RegistroPlatoEspecial.Ingresar(scanner);
		String sql = "Insert into PlatoEspecial (CodigoPlatoEspecial, NombrePlato, PrecioPlatoEspecial) values(?,?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, platoespecial.getCodigoPlatoEspecial());
				conexión.getSentencia().setString(2, platoespecial.getNombrePlato());
				conexión.getSentencia().setDouble(3, platoespecial.getPrecioPlatoEspecial());
				conexión.modificacion();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	/****************************
	 * Eliminar productos *
	 ****************************/

	public void delete() {
		int codPlatoEspecial = InputTypes.readInt("Código de platoespecial: ", scanner);
		String sql = "delete from platoespecial where código = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codPlatoEspecial);
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Modificar categorías
	 * 
	 * @throws SQLException
	 * @throws NoExisteProducto *
	 ****************************/

	public void update() throws SQLException, NoExistePlatoEspecial {
		ResultSet resultSet;
		PlatoEspecial platoEspecial;
		String NombrePlato;
		double PrecioPlatoEspecial;
		int CodigoPlatoEspecial = InputTypes.readInt("Código de platoespecial: ", scanner);
		String sql = "select * from producto where CodigoPlatoEspecial = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, CodigoPlatoEspecial);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlatoEspecial = resultSet.getDouble("PrecioPlatoEspecial");
			platoEspecial = new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlatoEspecial);
		} else {
			throw new NoExistePlatoEspecial();
		}

		System.out.println(platoEspecial);
		Menú.menúModificar(scanner, platoEspecial);

		sql = "update platoEspecial set NombrePlato = ?, PrecioPlatoEspecial = ? where  CodigoPlatoEspecial = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, platoEspecial.getNombrePlato());
		conexión.getSentencia().setDouble(2, platoEspecial.getPrecioPlatoEspecial());
		conexión.modificacion();
	}

	/****************************
	 * Listar productos 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		PlatoEspecial platoEspecial;
		String sql = "select * from platoEspecial ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			platoEspecial = new PlatoEspecial(resultSet.getInt("CodigoPlatoEspecial"), resultSet.getString("NombrePlatoEspecial"),
					resultSet.getDouble("PrecioPlatoEspecial"));
			System.out.println(platoEspecial);
		}
	}

	
}
