package cliente.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.entity.NoExisteCliente;
import control.Conexion;
import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;

public class RegistrarClientes {

	private Conexion conexion;
	private Scanner scanner;

	public RegistrarClientes(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void add()  {
		Cliente cliente = RegistrarCliente.ingresar(scanner);
		String sql = "Insert into cliente (NitCliente, CantidadPlatos, CodigoPlato, CodigoPlatoEspecial, NombreNit) values(?,?,?,?,?";
			
			
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
		String sql = "select * from cliente ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			cliente = new Cliente(resultSet.getInt("NitCliente"), resultSet.getInt("CantidadPlatos"), 
					              resultSet.getInt("CodigoPlato"),resultSet.getInt("CodigoPlatoEspecial"),
					              resultSet.getString("NombreNit"));
			System.out.println(cliente);
		}
	}
	
	public void listCuenta() throws NoExisteCliente, SQLException, NoExisteCuenta {
		ResultSet resultSet;
		Cliente cliente;
		int NitCliente;
		int CantidadPlatos;
		int CodigoPlato;
		int codigoPlatoEspecial;
		String NombrePlato;
		String NombreNit;
		double PrecioPlato;
		int CodigoMesa;
		int código = InputTypes.readInt("Código del Cliente: ", scanner);
		String sql = "select * from cliente where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, código);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			NitCliente = resultSet.getInt("NitCliente");
			CantidadPlatos = resultSet.getInt("CantidadPlatos");
			CodigoPlato = resultSet.getInt("CodigoPlato");
			codigoPlatoEspecial = resultSet.getInt("codigoPlatoEspecial");
			NombreNit = resultSet.getString("NombreNit");
			cliente = new Cliente(NitCliente, CantidadPlatos, CodigoPlato, codigoPlatoEspecial,NombreNit);
		} else {
			throw new NoExisteCliente();
		}
		System.out.println(cliente);

		Cuenta cuenta;

		sql = "select * from cuenta where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, NitCliente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			NitCliente = resultSet.getInt("NitCliente");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			CantidadPlatos = resultSet.getInt("CantidadPlatos");
			NombrePlato = resultSet.getString("NombrePlato");
			CodigoMesa = resultSet.getInt("CodigoMesa");
			cuenta = new Cuenta(NitCliente, PrecioPlato, CantidadPlatos, NombrePlato, CodigoMesa);
			System.out.println(cuenta);
		} else {
			throw new NoExisteCuenta();
		}

	}
}
