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
		
		String sql = "Insert into detalleVenta (CodigoPlato, CodigoPlatoEspecial, CantidadPlato) values(?,?,?)";
			try {
				conexion.consulta(sql);
				conexion.getSentencia().setInt(1, detalleVenta.getCodigoPlato());
				conexion.getSentencia().setInt(2, detalleVenta.getCodigoPlatoEspecial());
				conexion.getSentencia().setInt(3, detalleVenta.getCantidadPlato());
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
			detalleVenta = new DetalleVenta(resultSet.getInt("CodigoPlato"),resultSet.getInt("CodigoPlatoEspecial"), 
					resultSet.getInt("CantidadPlato"));
			System.out.println(detalleVenta);
		}
	}
	
	public void listPlato() throws NoExistePlato, SQLException, NoExisteDetalleVenta{
		
		ResultSet resultSet;
		DetalleVenta detalleVenta;
		int CantidadPlatos; int CodigoPlatoEspecial;
		double PrecioPlato;
		String NombrePlato; String TamañoPlato;
		
		int CodigoPlato = InputTypes.readInt("Código del Detalle de Venta: ", scanner);
		String sql = "select * from detalleventa where CodigoPlato = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			CodigoPlatoEspecial = resultSet.getInt("CodigoPlatoEspecial");
			CantidadPlatos = resultSet.getInt("CantidadPlato");
			detalleVenta = new DetalleVenta(CodigoPlato, CodigoPlatoEspecial, CantidadPlatos);
		} else {
			throw new NoExisteDetalleVenta();
		}
		System.out.println(detalleVenta);

		Plato plato;

		sql = "select * from plato where CodigoPlato = ?";
		conexion.consulta(sql);
		conexion.getSentencia().setInt(1, CodigoPlato);
		resultSet = conexion.resultado();
		if (resultSet.next()) {
			CodigoPlato = resultSet.getInt("CodigoPlato");
			NombrePlato = resultSet.getString("NombrePlato");
			PrecioPlato = resultSet.getDouble("PrecioPlato");
			TamañoPlato = resultSet.getString("TamañoPlato");
			plato = new Plato(CodigoPlato, NombrePlato, PrecioPlato, TamañoPlato);
			System.out.println(plato);
		} else {
			throw new NoExistePlato();
		}
	}
}
