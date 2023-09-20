package main;

import dao.DAO;
import dao.imp.PrendaDAOImp;
import model.domain.Prenda;


public class PruebaConexion {

	public static void main(String[] args) {
		
		DAO<Prenda, Integer> prendaDAO = new PrendaDAOImp();
		
		Prenda nuevaPrenda = new Prenda("Prenda06", 6000);
		
		prendaDAO.insertar(nuevaPrenda);
	}
}
