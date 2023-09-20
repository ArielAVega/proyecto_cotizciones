package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConexionMySQLDB;
import dao.DAO;
import model.domain.Prenda;
import model.domain.Vendedor;

public class VendedorDAOImp implements DAO<Vendedor, Integer>, ConexionMySQLDB{

	@Override
	public Vendedor buscarPorId(Integer key) {
		Vendedor vendedorBuscado =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM vendedores  WHERE ven_codigo = ?";
		try {
			PreparedStatement objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setInt(1, key);
			ResultSet resultado = objetoSentenciaSQL.executeQuery();
			while(resultado.next()) {
				int codigo = resultado.getInt("ven_codigo");
				String nombres = resultado.getString("ven_nombres");
				String apellidos = resultado.getString("ven_apellidos");
				vendedorBuscado = new Vendedor(codigo, nombres, apellidos);
			}
			objetoSentenciaSQL.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendedorBuscado;
	}

	@Override
	public List<Vendedor> obtenerTodos() {
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM vendedores";
		Statement objetoSentenciaSQL = null;
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			while(resultado.next()) {
				int codigo = resultado.getInt("ven_codigo");
				String nombres = resultado.getString("ven_nombres");
				String apellidos = resultado.getString("ven_apellidos");
				Vendedor vendedor = new Vendedor(codigo, nombres, apellidos);
				vendedores.add(vendedor);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objetoSentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return vendedores;
	}

	@Override
	public boolean insertar(Vendedor entidad) {
		boolean isInsert = false;
		Connection conexion = getConexion();
		String sentenciaSQL = "INSERT INTO vendedores (ven_nombres, ven_apellidos) VALUES (?, ?)";
			
		try {
			PreparedStatement objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setString(1, entidad.getNombres());
			objetoSentenciaSQL.setString(2, entidad.getApellidos());
			int result = objetoSentenciaSQL.executeUpdate();
			if(result==1) {
				isInsert=true;
			}
			objetoSentenciaSQL.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return isInsert;
	}

	@Override
	public void actualizar(Vendedor entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "UPDATE vendedores SET ven_nombres=?, ven_apellidos=? WHERE ven_codigo=?";
			
		try {
			PreparedStatement objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setString(1, entidad.getNombres());
			objetoSentenciaSQL.setString(2, entidad.getApellidos());
			objetoSentenciaSQL.setInt(3, entidad.getCodigo());
			int result = objetoSentenciaSQL.executeUpdate();
			
			objetoSentenciaSQL.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	public void eliminar(Vendedor entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "DELETE FROM vendedores WHERE ven_codigo=?";
			
		try {
			PreparedStatement objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setInt(1, entidad.getCodigo());
			objetoSentenciaSQL.executeUpdate();
			
			objetoSentenciaSQL.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
