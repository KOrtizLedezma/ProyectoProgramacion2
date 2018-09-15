package menuDia.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import menuComun.view.InputTypes;
import menuDia.entity.MenuDia;
import menuDia.entity.NoExisteMenuDia;
import platoEspecial.entity.NoExistePlatoEspecial;
import platoEspecial.entity.PlatoEspecial;;

public class RegistroMenusDia {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroMenusDia(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		MenuDia menuDia = RegistroMenuDia.Ingresar(scanner);
		String sql = "Insert into insumo (CodigoMenuEspecial, Fecha, CodigoPlatoEspecial) values(?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, menuDia.getCodigoMenuEspecial());
			conexion.getSentencia().setString(2, menuDia.getFecha());
			conexion.getSentencia().setInt(3, menuDia.getCodigoPlatoEspecial());
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		int CodigoMenuEspecial = InputTypes.readInt("Código del Menu Especial: ", scanner);
		String sql = "delete from menudia where código = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoMenuEspecial);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException, NoExisteMenuDia {
		ResultSet resultSet;
		MenuDia menuDia;
		int CodigoPlatoEspecial;
		String Fecha;
		int CodigoMenuEspecial = InputTypes.readInt("Código del Menu Especial: ", scanner);
		String sql = "select * from menudia where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMenuEspecial);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMenuEspecial = resultSet.getInt("CodigoMenuEspecial");
			Fecha = resultSet.getString("Fecha");
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			
			menuDia = new MenuDia(CodigoMenuEspecial, Fecha, CodigoPlatoEspecial);
		} else {
			throw new NoExisteMenuDia();
		}

		System.out.println(menuDia);
        Menu.menúModificar(scanner, menuDia);

		sql = "update menudia set CodigoMenuEspecial = ?, Fecha = ?, CodigoPlatoEspecial = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, menuDia.getCodigoPlatoEspecial());
		conexion.getSentencia().setString(2, menuDia.getFecha());
		conexion.getSentencia().setInt(3, menuDia.getCodigoPlatoEspecial());

		conexion.modificacion();
	}

	public void list() throws SQLException {
		MenuDia menuDia;
		String sql = "select * from menudia ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			menuDia = new MenuDia(resultSet.getInt("CodigoMenuEspecial"), resultSet.getString("Fecha"), 
					resultSet.getInt("CodigoPlatoEspecial"));
			System.out.println(menuDia);
		}
	}
	
	public void listPlatoEspecial() throws NoExisteMenuDia, SQLException, NoExistePlatoEspecial {
		ResultSet resultSet;
		MenuDia menuDia;
		int CodigoMenuEspecial; int CodigoPlatoEspecial; 
		String Fecha; String NombrePlato;
		double PrecioPlato;
		int código = InputTypes.readInt("Código de Menu: ", scanner);
		String sql = "select * from menudia where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, código);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMenuEspecial = resultSet.getInt("CodigoMenuEspecial");
			Fecha = resultSet.getString("Fecha");
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			menuDia = new MenuDia(CodigoMenuEspecial, Fecha, CodigoPlatoEspecial);
		} else {
			throw new NoExisteMenuDia();
		}
		System.out.println(menuDia);

		PlatoEspecial platoEspecial;

		sql = "select * from platoespecial where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlatoEspecial);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			platoEspecial = new PlatoEspecial(CodigoPlatoEspecial, NombrePlato, PrecioPlato);
			System.out.println(platoEspecial);
		} else {
			throw new NoExistePlatoEspecial();
		}

	}
}
