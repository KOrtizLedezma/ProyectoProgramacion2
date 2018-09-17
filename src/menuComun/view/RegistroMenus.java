package menuComun.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import menuComun.entity.MenuComun;
import menuComun.entity.NoExisteMenu;
import plato.entity.NoExistePlato;
import plato.entity.Plato;

public class RegistroMenus {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroMenus(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		MenuComun menu = RegistroMenu.Ingresar(scanner);
		String sql = "Insert into menu (CodigoMenu, CodigoPlato, NombrePlato, Fecha) values(?,?,?,?)";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, menu.getCodigoMenu());
			conexion.getSentencia().setInt(2, menu.getCodigoPlato());
			conexion.getSentencia().setString(3, menu.getNombrePlato());
			conexion.getSentencia().setString(4, menu.getFecha());
			conexion.modificacion();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		int CodigoMenu = InputTypes.readInt("Código del Menu: ", scanner);
		String sql = "delete from menu where CodigoMenu = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoMenu);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void update() throws SQLException, NoExisteMenu {
		ResultSet resultSet;
		MenuComun menu;
		int CodigoPlato;
		String NombrePlato; String Fecha;
		int CodigoMenu = InputTypes.readInt("Código del Menu: ", scanner);
		String sql = "select * from menu where CodigoMenu = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMenu);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMenu = resultSet.getInt("CodigoMenu");
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			Fecha = resultSet.getString("Fecha");
			menu = new MenuComun(CodigoMenu, CodigoPlato, NombrePlato, Fecha );
		} else {
			throw new NoExisteMenu();
		}

		System.out.println(menu);
        menuComun.view.Menu.menúModificar(scanner, menu);

		sql = "update menu set CodigoMenu = ?, CodigoPlato = ?, NombrePlato = ?, Fecha = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, menu.getCodigoMenu());
		conexion.getSentencia().setInt(2, menu.getCodigoPlato());
		conexion.getSentencia().setString(3, menu.getNombrePlato());
		conexion.getSentencia().setString(3, menu.getFecha());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		MenuComun menu;
		String sql = "select * from menu ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			menu = new MenuComun(resultSet.getInt("CodigoMenu"), resultSet.getInt("CodigoPlato"), 
					            resultSet.getString("NombrePlato"), resultSet.getString("Fecha"));
			System.out.println(menu);
		}
	}

	public void listPlato() throws NoExisteMenu, SQLException, NoExistePlato {
		ResultSet resultSet;
		MenuComun menu;
		int CodigoMenu;
		String Fecha;
		double PrecioPlato;
		String NombrePlato;
		String TamañoPlato;
		int CodigoPlato = InputTypes.readInt("Código de Menu: ", scanner);
		String sql = "select * from menu where CodigoPlato = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMenu = resultSet.getInt("CodigoMenu");
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			Fecha = resultSet.getString("Fecha");
			menu = new MenuComun(CodigoMenu, CodigoPlato, NombrePlato, Fecha);
		} else {
			throw new NoExisteMenu();
		}
		System.out.println(menu);

		Plato plato;

		sql = "select * from plato where CodigoPlato = ?";
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
