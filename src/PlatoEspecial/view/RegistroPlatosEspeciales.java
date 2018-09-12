package PlatoEspecial.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import entity.PlatoEspecial.PlatoEspecial;
import regist


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
		PlatoEspecial platoespecial = RegsitroPlatoEspecial.in(scanner);
		String sql = "Insert into Producto (nombre, precio, descripción, códigoCategoría) values(?,?,?,?)";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setString(1, producto.getNombre());
			conexión.getSentencia().setDouble(2, producto.getPrecio());
			conexión.getSentencia().setString(3, producto.getDescripción());
			conexión.getSentencia().setInt(4, producto.getCodCategoría());
			conexión.modificacion();
		} catch (SQLException e) {
			throw new NoExisteCategoría();
		}

	}

	/****************************
	 * Eliminar productos *
	 ****************************/

	public void delete() {
		int codProducto = InputTypes.readInt("Código de producto: ", scanner);
		String sql = "delete from producto where código = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, codProducto);
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

	public void update() throws NoExisteCategoría, SQLException, NoExisteProducto {
		ResultSet resultSet;
		Producto producto;
		String nombre;
		double precio;
		String descripción;
		int códigoCategoría;
		int código;
		int codProducto = InputTypes.readInt("Código de producto: ", scanner);
		String sql = "select * from producto where código = ?";
		conexión.consulta(sql);
		conexión.getSentencia().setInt(1, codProducto);
		resultSet = conexión.resultado();
		if (resultSet.next()) {
			nombre = resultSet.getString("nombre");
			precio = resultSet.getDouble("precio");
			descripción = resultSet.getString("descripción");
			códigoCategoría = resultSet.getInt("códigoCategoría");
			código = resultSet.getInt("código");
			producto = new Producto(código, nombre, precio, descripción, códigoCategoría);
		} else {
			throw new NoExisteProducto();
		}

		System.out.println(producto);
		Menú.menúModificar(scanner, producto);

		sql = "update producto set nombre = ?, precio = ?, descripción = ?, códigoCategoría = ?  where código = ?";

		conexión.consulta(sql);
		conexión.getSentencia().setString(1, producto.getNombre());
		conexión.getSentencia().setDouble(2, producto.getPrecio());
		conexión.getSentencia().setString(3, producto.getDescripción());
		conexión.getSentencia().setInt(4, producto.getCodCategoría());
		conexión.modificacion();
	}

	/****************************
	 * Listar productos 
	 * @throws SQLException *
	 ****************************/

	public void list() throws SQLException {
		Producto producto;
		String sql = "select * from producto ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			producto = new Producto(resultSet.getInt("código"), resultSet.getString("nombre"),
					resultSet.getDouble("precio"), resultSet.getString("descripción"),
					resultSet.getInt("CódigoCategoría"));
			System.out.println(producto);
		}
	}

	
}
