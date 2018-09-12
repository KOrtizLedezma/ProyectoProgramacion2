package cliente.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import control.Conexion;

public class RegistrarClientes {

	private Conexion conexion;
	private Scanner scanner;

	public RegistrarClientes(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void add()  {
		Cliente cliente = RegistrarCliente.ingresar(scanner);
		String sql = "Insert into Cliente (nitCliente, cantidadPlatos, codigoPlato, codigoPlatoEspecial, nombreNit) values(?,?,?,?,?";
			
			
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, cliente.getNitCliente());
				conexion.getSentencia().setInt(2, cliente.getCantidadPlatos());
				conexion.getSentencia().setInt(3, cliente.getCodigoPlato());
				conexion.getSentencia().setInt(4, cliente.getCodigoPlatoEspecial());
				conexion.getSentencia().setString(5, cliente.getNombreNit());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

	public void list() throws SQLException {
		Cliente cliente;
		String sql = "select * from Cliente ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			cliente = new Cliente(resultSet.getInt("nitCliente"), resultSet.getInt("cantidadPlatos"), 
					              resultSet.getInt("codigoPlato"),resultSet.getInt("codigoPlatoEspecial"),
					              resultSet.getString("nombreNit"));
			System.out.println(cliente);
		}
	}
}
