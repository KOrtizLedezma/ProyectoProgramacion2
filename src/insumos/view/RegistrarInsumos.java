package insumos.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import control.Conexi�n;
import entity.insumos.Insumos;


public class RegistrarInsumos {
	private Conexi�n conexi�n;
	private Scanner scanner;

	/****************************
	 * Constructor *
	 ****************************/

	public RegistrarInsumos(Conexi�n conexi�n, Scanner scanner) {
		this.conexi�n = conexi�n;
		this.scanner = scanner;
	}

	/****************************
	 * Agregar productos
	 ****************************/

	public void add() {
		Insumos insumo = RegistroInsumo.Ingresar(scanner);
		String sql = "Insert into Insumo (CodigoInsumo, CantidadInsumo) values(?,?)";
			try {
				conexi�n.consulta(sql);
				conexi�n.getSentencia().setInt(1, insumo.getCodigoInsumo());
				conexi�n.getSentencia().setInt(4, insumo.getCantidadInsumo());
				conexi�n.modificacion();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void delete() {
		int CodInsumo = InputTypes.readInt("C�digo de insumo: ", scanner);
		String sql = "delete from insumos where c�digo = ?";
		try {
			conexi�n.consulta(sql);
			conexi�n.getSentencia().setInt(1, CodInsumo);
			conexi�n.modificacion();
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
*/


	public void list() throws SQLException {
		Insumos insumo;
		String sql = "select * from producto ";
		conexi�n.consulta(sql);
		ResultSet resultSet = conexi�n.resultado();
		while (resultSet.next()) {
			insumo = new Insumos(resultSet.getInt("c�digo"), resultSet.getInt("cantidad"));
			System.out.println(insumo);
		}
	}

}
