package PlatoEspecial.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import entity.PlatoEspecial.NoExistePlatoEspecial;
import entity.PlatoEspecial.PlatoEspecial;
import insumos.view.InputTypes;



public class RegistroPlatosEspeciales {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistroPlatosEspeciales(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add()  {
		PlatoEspecial platoespecial = RegistroPlatoEspecial.Ingresar(scanner);
		String sql = "Insert into PlatoEspecial (CodigoPlatoEspecial, NombrePlato, PrecioPlatoEspecial) values(?,?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, platoespecial.getCodigoPlatoEspecial());
				conexi�n.getSentencia().setString(2, platoespecial.getNombrePlato());
				conexi�n.getSentencia().setDouble(3, platoespecial.getPrecioPlatoEspecial());
				conexi�n.modificacion();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	/****************************
	 * Eliminar productos *
	 ****************************/

	public void delete() {
		int codPlatoEspecial = InputTypes.readInt("C�digo de platoespecial: ", scanner);
		String sql = "delete from platoespecial where c�digo = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codPlatoEspecial);
			conexi�n.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	/****************************
	 * Modificar categor�as
	 * 
	 * @throws SQLException
	 * @throws NoExisteProducto *
	 ****************************/

	public void update() throws SQLException, NoExistePlatoEspecial {
		ResultSet resultSet;
		PlatoEspecial platoEspecial;
		String NombrePlato;
		double PrecioPlatoEspecial;
		int CodigoPlatoEspecial = InputTypes.readInt("C�digo de platoespecial: ", scanner);
		String sql = "select * from producto where CodigoPlatoEspecial = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, CodigoPlatoEspecial);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlatoEspecial = resultSet.getDouble("PrecioPlatoEspecial");
			platoEspecial = new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlatoEspecial);
		} else {
			throw new NoExistePlatoEspecial();
		}

		System.out.println(platoEspecial);
		Men�.men�Modificar(scanner, platoEspecial);

		sql = "update platoEspecial set NombrePlato = ?, PrecioPlatoEspecial = ? where  CodigoPlatoEspecial = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, platoEspecial.getNombrePlato());
		conexi�n.getSentencia().setDouble(2, platoEspecial.getPrecioPlatoEspecial());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar productos 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		PlatoEspecial platoEspecial;
		String sql = "select * from platoEspecial ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			platoEspecial = new PlatoEspecial(resultSet.getInt("CodigoPlatoEspecial"), resultSet.getString("NombrePlatoEspecial"),
					resultSet.getDouble("PrecioPlatoEspecial"));
			System.out.println(platoEspecial);
		}
	}

	
}
