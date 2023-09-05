package main;

import java.util.List;

import model.domain.Prenda;
import model.util.GestorPrendas;

/**
 * En esta clase se inicia la ejecución de la aplicación
 * @author ariel
 *
 */
public class Principal {

	static {
		Prenda prenda01= new Prenda(111,"Prenda01", 1000);
		Prenda prenda02= new Prenda(222,"Prenda02", 2000);
		Prenda prenda03= new Prenda(333,"Prenda03", 3000);
		GestorPrendas.agregarPrenda(prenda01);
		GestorPrendas.agregarPrenda(prenda02);
		GestorPrendas.agregarPrenda(prenda03);
	}
	
	
	public static void main(String[] args) {
		//se visualizan las prendas disponibles
		GestorPrendas.visualizarPrendas();
		
		//realizar una prueba de búsqueda de prenda por código
		Prenda prendaBuscada01 = GestorPrendas.getPrenda(222);
		Prenda prendaBuscada02 = GestorPrendas.getPrenda(444);
		if(prendaBuscada01!=null) {
			System.out.println("Si existe la prenda en los registros de prendas");
		}
		if(prendaBuscada02==null) {
			System.out.println("No existe la prenda en los registros de prendas");
		}

	}

	
	
}
