package plato.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexion;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import menuComun.entity.MenuComun;
import menuComun.entity.NoExisteMenu;
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
		String sql = "Insert into Plato (CodigoPlato, NombrePlato, PrecioPlato, Tama�oPlato) values(?,?,?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, plato.getCodigoPlato());
				conexion.getSentencia().setString(2, plato.getNombre());
				conexion.getSentencia().setDouble(3, plato.getPrecio());
				conexion.getSentencia().setString(4, plato.getTama�o());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void delete() {
		int CodigoPlato = InputTypes.readInt("C�digo del Plato: ", scanner);
		String sql = "delete from Plato where c�digo = ?";
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
		String Tama�oPlato;
		String NombrePlato;
		double PrecioPlato;
		int CodigoPlato = InputTypes.readInt("C�digo del plato: ", scanner);
		String sql = "select * from plato where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			Tama�oPlato = resultSet.getString("Tama�oPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, Tama�oPlato);
		} else {
			throw new NoExistePlato();
		}

		System.out.println(plato);
		Menu.men�Modificar(scanner, plato);

		sql = "update plato set CodigoPlato= ?, NombrePlato = ?, PrecioPlato = ?, Tama�oPlato = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, plato.getCodigoPlato());
		conexion.getSentencia().setString(2, plato.getNombre());
		conexion.getSentencia().setDouble(3, plato.getPrecio());
		conexion.getSentencia().setString(4, plato.getTama�o());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Plato plato;
		String sql = "select * from plato ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			plato = new Plato(resultSet.getInt("CodigoPlato"), resultSet.getString("NombrePlato"),
					resultSet.getDouble("PrecioPlato"), resultSet.getString("Tama�oPlato"));
			System.out.println(plato);
		}
	}
	
    public void listRecetaMenuDetalle() throws NoExisteReceta, SQLException, NoExisteMenu, NoExisteDetalleVenta, NoExistePlato {
		
		ResultSet resultSet;
		Plato plato;
		
		int CantidadPlatos; int CodigoPlato; int CodigoInsumo; int CantidadInsumo; int CodigoMenu;
		double PrecioPlato;
		String NombrePlato; String Tama�oPlato; String Fecha;
		
		int c�digo = InputTypes.readInt("C�digo del Plato: ", scanner);
		String sql = "select * from plato where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, c�digo);
		resultSet = conexion.resultado();
		
		if (resultSet.next()) {
			
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			Tama�oPlato = resultSet.getString("Tama�oPlato");
			
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, Tama�oPlato);
		} else {
			throw new NoExistePlato();
		}
		System.out.println(plato);

		MenuComun menu;

		sql = "select * from menu where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			
			CodigoMenu = resultSet.getInt("CodigoMenu");
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			Fecha = resultSet.getString("Fecha");
			
			menu = new MenuComun(CodigoMenu, CodigoPlato, NombrePlato, Fecha);
			System.out.println(menu);
		} else {
			throw new NoExisteMenu();
		}
		
		DetalleVenta detalleVenta;

		sql = "select * from detalleventa where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			
			CodigoPlato = resultSet.getInt("CodigoPlato");
			CantidadPlatos = resultSet.getInt("CantidadPlatos");
			
			detalleVenta = new DetalleVenta(CodigoPlato, CantidadPlatos);
			System.out.println(detalleVenta);
		} else {
			throw new NoExisteDetalleVenta();
		}
		
		Receta receta;

		sql = "select * from receta where c�digo = ?";
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
