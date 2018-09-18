package mesa.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import cliente.view.InputTypes;
import control.Conexion;
import cuenta.entity.Cuenta;
import cuenta.entity.NoExisteCuenta;
import mesa.entity.Mesa;
import mesa.entity.NoExisteMesa;
import mesero.entity.Mesero;
import mesero.entity.NoExisteMesero;

public class RegistroMesas {

	private Conexion conexion;
	private Scanner scanner;


	public RegistroMesas(Conexion conexion, Scanner scanner) {
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add() {
		Mesa mesa = RegistroMesa.ingresar(scanner);
		String sql = "Insert into mesa (CodigoMesa, Cuenta) values(?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, mesa.getCodigoMesa());
				conexion.getSentencia().setInt(2, mesa.getCuenta());
				conexion.modificacion();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void delete() {
		int CodigoMesa = InputTypes.readInt("Código de la Mesa: ", scanner);
		String sql = "delete from mesa where CodigoMesa = ?";
		try {
			conexion.consulta(sql);
			conexion.getSentencia().setInt(1, CodigoMesa);
			conexion.modificacion();
		} catch (SQLException e) {
			System.out.println(e.getSQLState());
		}
	}

	public void update() throws SQLException, NoExisteMesa {
		ResultSet resultSet;
		Mesa mesa;
		int cuenta;
		int CodigoMesa = InputTypes.readInt("Código de la Mesa: ", scanner);
		String sql = "select * from mesa where CodigoMesa = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			cuenta = resultSet.getInt("Cuenta");
			CodigoMesa = resultSet.getInt("CodigoMesa");
			mesa = new Mesa(cuenta, CodigoMesa);
		} else {
			throw new NoExisteMesa();
		}

		System.out.println(mesa);
		Menu.menúModificar(scanner, mesa);

		sql = "update Mesa set CodigoMesa = ?, Cuenta = ?";

		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, mesa.getCuenta());
		conexion.getSentencia().setInt(2, mesa.getCodigoMesa());
		conexion.modificacion();
	}

	public void list() throws SQLException {
		Mesa mesa;
		String sql = "select * from mesa ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			mesa = new Mesa(resultSet.getInt("Cuenta"), resultSet.getInt("CodigoMesa"));
			System.out.println(mesa);
		}
	}

	public void listCuentaMesero() throws NoExisteMesa, SQLException, NoExisteMesero, NoExisteCuenta {
		
		ResultSet resultSet;
		Mesa mesa;
		int NitCliente; int CantidadPlatos; int CodigoMesa; int CodigoPlato; int CodigoPlatoEspecial; int Cuenta; int CodigoMesero;
		double PrecioPlato;
		String NombrePlato;
		
		int código = InputTypes.readInt("Código de la Cuenta: ", scanner);
		String sql = "select * from mesa where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, código);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			
			CodigoMesa = resultSet.getInt("CodigoMesa");
			Cuenta = resultSet.getInt("Cuenta");
			
			mesa = new Mesa(CodigoMesa, Cuenta);
		} else {
			throw new NoExisteMesa();
		}
		System.out.println(mesa);

		Cuenta cuenta;

		sql = "select * from cuenta where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesa);
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
		
		Mesero mesero;

		sql = "select * from mesero where código = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoMesa);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			
			CodigoMesero = resultSet.getInt("CodigoMesero");
			CodigoMesa = resultSet.getInt("CodigoMesa");
			
			mesero = new Mesero(CodigoMesero, CodigoMesa);
			System.out.println(mesero);
		} else {
			throw new NoExisteMesero();
		}

	}
}
