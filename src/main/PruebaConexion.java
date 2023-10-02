package main;

import java.io.File;

import dao.DAO;
import dao.imp.PrendaDAOImp;
import model.domain.Prenda;


public class PruebaConexion {

	public static void main(String[] args) {
		
		DAO<Prenda, Integer> prendaDAO = new PrendaDAOImp();
		
		File archivo = new File("D:" + File.separator + "Ficheros" + File.separator+"camisa.jpg");
		
		Prenda nuevaPrenda = new Prenda("Camisa Azul", 9000,archivo);
		
		prendaDAO.insertar(nuevaPrenda);
		
		//Prenda prendaBuscada = prendaDAO.buscarPorId(9);
		
	}
}
