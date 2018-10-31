package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.ProductoVO;

public class ProductoDao {

	public String agregarPersona(ProductoVO miPersona) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		String consulta = "INSERT INTO producto (documento,nombre,descripcion,salario,tipo)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersona.getDocumento());
			preStatement.setString(2, miPersona.getNombre());
			preStatement.setString(3, miPersona.getDescripcion());
			preStatement.setString(4, miPersona.getSalario() + "");
			preStatement.setString(5, miPersona.getTipo());
			
			
			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registra la persona: " + e.getMessage());
			resultado = "No se pudo registrar";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}

	public ArrayList<ProductoVO> obtenerListaPersonas() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVO miProducto = new ProductoVO();
		ArrayList<ProductoVO> listaProducto = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM producto ";

		try {
			if (connection != null) {
				listaProducto = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miProducto = new ProductoVO();
					miProducto.setDocumento(result.getString("documento"));
					miProducto.setNombre(result.getString("nombre"));
					miProducto.setDescripcion(result.getString("descripcion"));
					miProducto.setSalario(Double.parseDouble(result.getString("salario")));
					miProducto.setTipo(result.getString("tipo"));
		
					
					listaProducto.add(miProducto);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaProducto;
	}

	public String editarPersona(ProductoVO producto) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE producto "
					+ " SET nombre = ? , descripcion= ? , salario= ? , tipo= ? "
					+ " WHERE documento= ? ";
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, producto.getNombre());
			preStatement.setString(2, producto.getDescripcion());
			preStatement.setString(3, producto.getSalario() + "");
			preStatement.setString(4, producto.getTipo());
			
			preStatement.setString(5, producto.getDocumento());
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado la persona satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar la persona";
		}
		return resultado;
	}

	public String eliminarPersona(ProductoVO producto) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();

		String resp = "";
		try {
			String sentencia = "DELETE FROM producto WHERE documento= ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, producto.getDocumento());

			statement.executeUpdate();

			resp = "Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar";
		}
		return resp;
	}
	
	

	public ProductoVO consultarPersonaIndividual(String documento) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		ProductoVO miProducto = null;
		System.out.println("Documento: "+documento);

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM producto where documento = "+documento;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				if (result.next() == true) {
					miProducto = new ProductoVO();
					miProducto.setDocumento(result.getString("documento"));
					miProducto.setNombre(result.getString("nombre"));
					miProducto.setDescripcion(result.getString("descripcion"));
					miProducto.setSalario(Double.parseDouble(result.getString("salario")));
					miProducto.setTipo(result.getString("tipo"));
					
					
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miProducto;
	}

}
