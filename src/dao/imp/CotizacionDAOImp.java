package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import dao.ConexionMySQLDB;
import dao.DAO;
import model.domain.Cotizacion;
import model.domain.Prenda;
import model.domain.Vendedor;

public class CotizacionDAOImp implements ConexionMySQLDB, DAO<Cotizacion, Integer>{

	@Override
	public Cotizacion buscarPorId(Integer key) {
		Cotizacion cotizcionBuscada =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM cotizaciones  WHERE cot_nro_id = ?";
		try {
			PreparedStatement objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setInt(1, key);
			ResultSet resultado = objetoSentenciaSQL.executeQuery();
			while(resultado.next()) {
				int nroIdentificacion = resultado.getInt("cot_nro_id");
				Date fecha = resultado.getDate("cot_FECHA");
				int codigoPrenda = resultado.getInt("cot_prenda");
				int cantPrendas = resultado.getInt("cot_cant_prendas");
				//double totalCotizacion = resultado.getDouble("cot_total");
				int idVendedor = resultado.getInt("cot_vendedor");
				Prenda prenda = new PrendaDAOImp().buscarPorId(codigoPrenda);
				Vendedor vendedor = new VendedorDAOImp().buscarPorId(idVendedor);
				cotizcionBuscada = new Cotizacion(nroIdentificacion, fecha, prenda, cantPrendas, vendedor);
			}
			objetoSentenciaSQL.close();
			conexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cotizcionBuscada;
	}

	@Override
	public List<Cotizacion> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(Cotizacion entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void actualizar(Cotizacion entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cotizacion entidad) {
		// TODO Auto-generated method stub
		
	}

	

}
