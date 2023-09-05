package model.util;

import java.util.ArrayList;
import java.util.List;

import model.domain.Prenda;

/**
 * Simula una tabla de prendas
 * @author ariel
 *
 */
public class GestorPrendas {
	/**
	 * Simula los registros de prendas
	 */
	private static List<Prenda> prendas;
	
	static {
		prendas = new ArrayList<>();
	}
	
	/**
	 * Agrega una prenda a los registros del prendas
	 * @param prenda la prenda a agregar
	 */
	public static void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
	
	/**
	 * Busca una prenda en los registros de prendas por código
	 * @param codigoPrenda el código de la prenda a buscar
	 * @return una prenda si existos, de lo contrario null
	 */
	public static Prenda getPrenda(int codigoPrenda) {
		Prenda prenda = null;
		for(Prenda p: prendas) {
			if(p.getCodigo() == codigoPrenda) {
				prenda = p;
			}
		}
		
		return prenda;
	}
	
	public static void visualizarPrendas() {
		for(Prenda p:prendas) {
			System.out.println(p);
		}
	}
}
