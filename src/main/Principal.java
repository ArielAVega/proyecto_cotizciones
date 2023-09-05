package main;

import java.util.Scanner;

import model.domain.Cotizacion;
import model.domain.Prenda;
import model.domain.Vendedor;
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
		
		// aqui empieza la prueba de las fucnionalidades pedidas
		Vendedor vendedor = new Vendedor(111, "Ariel", "Vega");
		vendedor.registrarCotizacion(crearCotizacion(vendedor));
		vendedor.registrarCotizacion(crearCotizacion(vendedor));
		vendedor.mostrarHistorial();
		
	}
	
	/** 
	 * Permite crear una cotización solicitada por consola
	 * @param vendedor el vendedor que realiza la cotización
	 * @return la cotización realizada por el vendedor
	 */
	public static Cotizacion crearCotizacion(Vendedor vendedor) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresar nro de Cotización: ");
		int nroIdentificacion = scanner.nextInt();
		System.out.println("Ingresar la fecha de cotización: ");
		String fecha = scanner.next();
		System.out.println("Ingresar el codigo de la prenda a cotizar: ");
		int codigoPrenda = scanner.nextInt(); //en esta versión se asume que se ingresa un código existente
		Prenda prenda = GestorPrendas.getPrenda(codigoPrenda);
		System.out.println("Ingresar cantidad de prendas a cotizar: ");
		int cantidadPrendas = scanner.nextInt();
		Cotizacion cotizacion = new Cotizacion(nroIdentificacion, fecha, prenda, cantidadPrendas, vendedor);
		//scanner.close();
		return cotizacion;
		
	}
	
	/**
	 * Permite mostrara as cotizaciones de un vendedor
	 * @param vendedor el vendedor del que se mostrará sus cotizaciones
	 */
	public static void mostrarCotizaciones(Vendedor vendedor) {
		vendedor.mostrarHistorial();
	}

	
	
}
