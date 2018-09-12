package PlatoEspecial.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import entity.PlatoEspecial.PlatoEspecial;
import regist


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
		PlatoEspecial platoespecial = RegsitroPlatoEspecial.in(scanner);
		String sql = "Insert into Producto (nombre, precio, descripci�n, c�digoCategor�a) values(?,?,?,?)";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setString(1, producto.getNombre());
			conexi�n.getSentencia().setDouble(2, producto.getPrecio());
			conexi�n.getSentencia().setString(3, producto.getDescripci�n());
			conexi�n.getSentencia().setInt(4, producto.getCodCategor�a());
			conexi�n.modificacion();
		} catch (SQLException e) {
			throw new NoExisteCategor�a();
		}

	}

	/****************************
	 * Eliminar productos *
	 ****************************/

	public void delete() {
		int codProducto = InputTypes.readInt("C�digo de producto: ", scanner);
		String sql = "delete from producto where c�digo = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, codProducto);
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

	public void update() throws NoExisteCategor�a, SQLException, NoExisteProducto {
		ResultSet resultSet;
		Producto producto;
		String nombre;
		double precio;
		String descripci�n;
		int c�digoCategor�a;
		int c�digo;
		int codProducto = InputTypes.readInt("C�digo de producto: ", scanner);
		String sql = "select * from producto where c�digo = ?";
		conexi�n.consulta(sql);
		conexi�n.getSentencia().setInt(1, codProducto);
		resultSet = conexi�n.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			precio = resultSet.getDouble("precio");
			descripci�n = resultSet.getString("descripci�n");
			c�digoCategor�a = resultSet.getInt("c�digoCategor�a");
			c�digo = resultSet.getInt("c�digo");
			producto = new Producto(c�digo, nombre, precio, descripci�n, c�digoCategor�a);
		} else {
			throw new NoExisteProducto();
		}

		System.out.println(producto);
		Men�.men�Modificar(scanner, producto);

		sql = "update producto set nombre = ?, precio = ?, descripci�n = ?, c�digoCategor�a = ?  where c�digo = ?";

		conexi�n.consulta(sql);
		conexi�n.getSentencia().setString(1, producto.getNombre());
		conexi�n.getSentencia().setDouble(2, producto.getPrecio());
		conexi�n.getSentencia().setString(3, producto.getDescripci�n());
		conexi�n.getSentencia().setInt(4, producto.getCodCategor�a());
		conexi�n.modificacion();
	}

	/****************************
	 * Listar productos 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Producto producto;
		String sql = "select * from producto ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			producto = new Producto(resultSet.getInt("c�digo"), resultSet.getString("nombre"),
					resultSet.getDouble("precio"), resultSet.getString("descripci�n"),
					resultSet.getInt("C�digoCategor�a"));
			System.out.println(producto);
		}
	}

	
}
