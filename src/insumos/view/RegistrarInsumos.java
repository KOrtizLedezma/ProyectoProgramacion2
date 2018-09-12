package insumos.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexión;
import entity.insumos.Insumos;


public class RegistrarInsumos {
	private Conexión conexión;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistrarInsumos(Conexión conexión, Scanner scanner) {
		this.conexión = conexión;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add() {
		Insumos insumo = RegistroInsumo.Ingresar(scanner);
		String sql = "Insert into Insumo (CodigoInsumo, CantidadInsumo) values(?,?)";
			try {
				conexión.consulta(sql);
				conexión.getSentencia().setInt(1, insumo.getCodigoInsumo());
				conexión.getSentencia().setInt(4, insumo.getCantidadInsumo());
				conexión.modificacion();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void delete() {
		int CodInsumo = InputTypes.readInt("Código de insumo: ", scanner);
		String sql = "delete from insumos where código = ?";
		try {
			conexión.consulta(sql);
			conexión.getSentencia().setInt(1, CodInsumo);
			conexión.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

// Update insumos fix despues

/*	public void update()  {
		ResultSet resultSet;
		Insumos insumo;
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
*/


	public void list() throws SQLException {
		Insumos insumo;
		String sql = "select * from producto ";
		conexión.consulta(sql);
		ResultSet resultSet = conexión.resultado();
		while (resultSet.next()) {
			insumo = new Insumos(resultSet.getInt("código"), resultSet.getInt("cantidad"));
			System.out.println(insumo);
		}
	}

}
