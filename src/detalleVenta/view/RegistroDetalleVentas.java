package detalleVenta.view;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

import cliente.view.InputTypes;
import control.Conexion;
import detalleVenta.entity.DetalleVenta;
import detalleVenta.entity.NoExisteDetalleVenta;
import plato.entity.NoExistePlato;
import plato.entity.Plato;

public class RegistroDetalleVentas {

	private Conexion conexion;
	private Scanner scanner;

	public RegistroDetalleVentas(Conexion conexion, Scanner scanner) {
		
		this.conexion = conexion;
		this.scanner = scanner;
	}

	public void add()  {
		DetalleVenta detalleVenta = RegistroDetalleVenta.Ingresar(scanner);
		
		String sql = "Insert into detalleventa (CodigoPlato, CantidadPlato) values(?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, detalleVenta.getCodigoPlato());
				conexion.getSentencia().setInt(2, detalleVenta.getCantidadPlato());
				conexion.modificacion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} 


	public void list() throws SQLException {
		DetalleVenta detalleVenta;
		String sql = "select * from detalleventa ";
		conexion.consulta(sql);
		ResultSet resultSet = conexion.resultado();
		while (resultSet.next()) {
			detalleVenta = new DetalleVenta(resultSet.getInt("CodigoPlato"), resultSet.getInt("CantidadPlato"));
			System.out.println(detalleVenta);
		}
	}
	
	public void listPlato() throws NoExistePlato, SQLException, NoExisteDetalleVenta{
		
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int CodigoPlato; int CantidadPlatos;
		double PrecioPlato;
		String NombrePlato; String Tama�oPlato;
		
		int c�digo = InputTypes.readInt("C�digo del Detalle de Venta: ", scanner);
		String sql = "select * from detalleventa where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, c�digo);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			CantidadPlatos = resultSet.getInt("CantidadPlato");
			detalleVenta = new DetalleVenta(CodigoPlato, CantidadPlatos);
		} else {
			throw new NoExisteDetalleVenta();
		}
		System.out.println(detalleVenta);

		Plato plato;

		sql = "select * from plato where c�digo = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			Tama�oPlato = resultSet.getString("Tama�oPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, Tama�oPlato);
			System.out.println(plato);
		} else {
			throw new NoExistePlato();
		}
	}
}
