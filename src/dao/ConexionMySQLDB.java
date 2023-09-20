package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.MysqlConnection;

import model.domain.Prenda;

public interface ConexionMySQLDB {

	default Connection getConexion() {
		// definimos un String que representa la ubicación del driver jdbc
		String DRIVER = "com.mysql.cj.jdbc.Driver";

		String URL = "jdbc:mysql://amazondbmysql.cuah2u66hkiz.sa-east-1.rds.amazonaws.com:3306/cotizaciones";
		// String url = "jdbc:mysql://localhost:3306";
		//Connection conexion = null;
		Connection conexion=null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, "admin", "Joaquin1302");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	

}
