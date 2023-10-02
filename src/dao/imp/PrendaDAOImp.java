package dao.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
import model.util.GestorArchivos;

public class PrendaDAOImp implements ConexionMySQLDB, DAO<Prenda, Integer>{

	@Override
	public Prenda buscarPorId(Integer key) {
		Prenda prendaBuscada =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM prendas WHERE pre_codigo = "+key;
		Statement objetoSentenciaSQL = null;
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			while(resultado.next()) {
				int codigo = resultado.getInt("pre_codigo");
				String nombrePrenda = resultado.getString("pre_nombre");
				double precio = resultado.getDouble("pre_precio_lista");
				Blob imagen = resultado.getBlob("pre_imagen");
				InputStream inputStream = imagen.getBinaryStream();
				File archivoImagen = new File("D:" + File.separator + "Ficheros" + File.separator+"camisa.jpg");
				GestorArchivos.copyInputStreamToFile(inputStream, archivoImagen);
				prendaBuscada = new Prenda(codigo, nombrePrenda, precio,archivoImagen);
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
		
		return prendaBuscada;
	}

	@Override
	public boolean insertar(Prenda entidad) {
		boolean isInsert = false;
		Connection conexion = getConexion();
		String sentenciaSQL = "INSERT INTO prendas (pre_nombre, pre_precio_lista, pre_imagen) VALUES (?, ?, ?)";
			
		try (PreparedStatement objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL);
			 InputStream inputStream = new FileInputStream(entidad.getImagen());){
			
			objetoSentenciaSQL.setString(1, entidad.getNombrePrenda());
			objetoSentenciaSQL.setDouble(2, entidad.getPrecioLista());
			objetoSentenciaSQL.setBlob(3, inputStream);
			int result = objetoSentenciaSQL.executeUpdate();
			if(result==1) {
				isInsert=true;
			}
			//objetoSentenciaSQL.close();
			//conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return isInsert;
	}

	@Override
	public List<Prenda> obtenerTodos() {
		List<Prenda> prendas = new ArrayList<Prenda>();
		
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM prendas";
		Statement objetoSentenciaSQL = null;
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			while(resultado.next()) {
				int codigo = resultado.getInt("pre_codigo");
				String nombrePrenda = resultado.getString("pre_nombre");
				double precio = resultado.getDouble("pre_precio_lista");
				Prenda prendaBuscada = new Prenda(codigo, nombrePrenda, precio);
				prendas.add(prendaBuscada);
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
		
		return prendas;
	}

	@Override
	public void actualizar(Prenda entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "UPDATE prendas SET pre_nombre='"+entidad.getNombrePrenda()+"', pre_precio_lista="+entidad.getPrecioLista() +" WHERE pre_codigo="+entidad.getCodigo();
		Statement objetoSentenciaSQL=null;
		try {
			
			objetoSentenciaSQL = conexion.createStatement();
			objetoSentenciaSQL.executeUpdate(sentenciaSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		
	}

	@Override
	public void eliminar(Prenda entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "DELETE FROM prendas WHERE pre_codigo="+entidad.getCodigo();
		Statement objetoSentenciaSQL=null;
		try {
			
			objetoSentenciaSQL = conexion.createStatement();
			objetoSentenciaSQL.executeUpdate(sentenciaSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		
	}

}
