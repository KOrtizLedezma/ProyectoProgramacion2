package cuenta.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import cliente.entity.Cliente;
import cliente.entity.NoExisteCliente;
import cliente.view.InputTypes;
import control.Conexion;
import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;

public class RegistroCuentas {
	
	private Conexion conexion;
	private Scanner scanner;

	public RegistroCuentas(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add()  {
		Cuenta cuenta = RegistroCuenta.Ingresar(scanner);
		String sql = "Insert into cuenta (NitCliente, PrecioPlato, CantidadPlatos, NombrePlato, CodigoMesa) values(?,?,?,?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, cuenta.getNitCliente());
				conexion.getSentencia().setDouble(2, cuenta.getPrecioPlato());
				conexion.getSentencia().setInt(3, cuenta.getCantidadPlatos());
				conexion.getSentencia().setString(4, cuenta.getNombrePlato());
				conexion.getSentencia().setInt(5, cuenta.getCodigoMesa());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 


	public void list() throws SQLException {
		Cuenta cuenta;
		String sql = "select * from cuenta ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			cuenta = new Cuenta(resultSet.getInt("NitCliente"), resultSet.getDouble("PrecioPlato"), 
					 resultSet.getInt("CantidadPlatos"), resultSet.getString("NombrePlato"),
					 resultSet.getInt("CodigoMesa"));
			System.out.println(cuenta);
		}
	}
	
	public void listClienteMesa() throws NoExisteCliente, SQLException, NoExisteCuenta, NoExisteMesa{
		ResultSet resultSet;
		Cuenta cuenta;
		int CantidadPlatos; int CodigoMesa; int CodigoPlato; int CodigoPlatoEspecial; int Cuenta;;
		double PrecioPlato;
		String NombrePlato; String NombreNit;
		
		int NitCliente = InputTypes.readInt("Nit del Cliente: ", scanner);
		String sql = "select * from cuenta where NitCliente = ?";
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
		} else {
			throw new NoExisteCuenta();
		}
		System.out.println(cuenta);

		Cliente cliente;

		sql = "select * from cliente where NitCliente = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, NitCliente);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			NitCliente = resultSet.getInt("NitCliente");
			CantidadPlatos = resultSet.getInt("CantidadPlatos");
			CodigoPlato = resultSet.getInt("CodigoPlato");
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			NombreNit = resultSet.getString("NombreNit");
			cliente = new Cliente(NitCliente, CantidadPlatos, CodigoPlato, CodigoPlatoEspecial, NombreNit);
			System.out.println(cliente);
		} else {
			throw new NoExisteCliente();
		}
		
		Mesa mesa;

		sql = "select * from mesa where CodigoMesa = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoMesa = resultSet.getInt("CodigoMesa");
			Cuenta = resultSet.getInt("Cuenta");
			
			mesa = new Mesa(CodigoMesa, Cuenta);
			System.out.println(mesa);
		} else {
			throw new NoExisteMesa();
		}

	}
}
