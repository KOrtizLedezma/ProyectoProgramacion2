package cliente.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.entity.NoExisteCliente;
import control.Conexion;
import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;
import insumos.view.InputTypes;
import plato.entity.NoExistePlato;
import plato.entity.Plato;
import platoEspecial.entity.NoExistePlatoEspecial;
import platoEspecial.entity.PlatoEspecial;

public class RegistrarClientes {

	private Conexion conexion;
	private Scanner scanner;

	public RegistrarClientes(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}
	public void add()  {
		Cliente cliente = RegistrarCliente.ingresar(scanner);
		String sql = "Insert into cliente (NitCliente, CantidadPlatos, CodigoPlato, CodigoPlatoEspecial, NombreNit) values(?,?,?,?,?)";
			
			
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
	
	public void delete() {
		int NitCliente = InputTypes.readInt("Nit del Cliente: ", scanner);
		String sql = "delete from cliente where NitCliente = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, NitCliente);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}
	
	public void listCuenta() throws NoExistePlatoEspecial, NoExistePlato, NoExisteCliente, SQLException, NoExisteCuenta {
		ResultSet resultSet;
		Cliente cliente;
		int CantidadPlatos; int CodigoPlato; int codigoPlatoEspecial; int CodigoMesa; 
		String NombrePlato; String NombreNit; String TamañoPlato;
		double PrecioPlato;
		int NitCliente = InputTypes.readInt("Nit del Cliente: ", scanner);
		String sql = "select * from cliente where NitCliente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, NitCliente);
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

		sql = "select * from cuenta where NitCliente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, NitCliente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			CantidadPlatos = resultSet.getInt("CantidadPlatos");
			NombrePlato = resultSet.getString("NombrePlato");
			CodigoMesa = resultSet.getInt("CodigoMesa");
			cuenta = new Cuenta(NitCliente, PrecioPlato, CantidadPlatos, NombrePlato, CodigoMesa);
			System.out.println(cuenta.toStringCliente());
		} else {
			throw new NoExisteCuenta();
		}
		
		Plato plato;

		sql = "select * from plato where CodigoPlato = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			TamañoPlato = resultSet.getString("TamañoPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato);
			System.out.println(plato.toStringPlato());
		} else {
			throw new NoExistePlato();
		}
		
		PlatoEspecial platoEspecial;

		sql = "select * from platoespecial where CodigoPlatoEspecial = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, codigoPlatoEspecial);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			codigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			platoEspecial = new PlatoEspecial(codigoPlatoEspecial, NombrePlato, PrecioPlato);
			System.out.println(platoEspecial.toStringCliente());
		} else {
			throw new NoExistePlatoEspecial();
		}

	}
}
