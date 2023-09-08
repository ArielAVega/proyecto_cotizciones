package main;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.domain.Cotizacion;
import model.domain.Prenda;
import model.domain.Vendedor;
import model.util.ConversorFechas;
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
		Date fecha;
		boolean isValidDate;
		do {
			System.out.println("Ingresar la fecha de cotización: ");
			String fechaString = scanner.next();
			fecha = ConversorFechas.stringToDate(fechaString);
			if(fecha == null) {
				isValidDate=false;
				System.err.println("Debe ingresar una fecha válida");
			}else {
				isValidDate=true;
			}
		}while(isValidDate!=true);
		
		int codigoPrenda;
		Prenda prenda = null;
		boolean isValidClothCode;
		do{
			try {
				System.out.print("Ingresar el codigo de la prenda a cotizar: ");
				codigoPrenda = Integer.parseInt(scanner.next());
				prenda = GestorPrendas.getPrenda(codigoPrenda);
				if(prenda==null) {
					isValidClothCode=false;
					System.err.println("No existe una prenda con ese código, ingree otro");
				}else {
					isValidClothCode=true;
				}
			} catch (NumberFormatException e) {
				System.err.println("El códgo de prenda es un valor numérico: ");
				isValidClothCode=false;
			}
		}while(isValidClothCode!=true);
		
		
		boolean isValidClothCount;
		int cantidadPrendas=0;
		do {		
			try {
				System.out.println("Ingresar cantidad de prendas a cotizar: ");
				cantidadPrendas = Integer.parseInt(scanner.next());
				if(cantidadPrendas<=0) {
					isValidClothCount=false;
					System.err.println("Debe ingresar una cantidad de prendas válida");
				}else {
					isValidClothCount=true;
				}
			} catch (NumberFormatException e) {
				System.err.println("La cantidad de prendas es un valor numérico positivo mayor a cero: ");
				isValidClothCount=false;
			}		
		}while(isValidClothCount!=true);
		
		Cotizacion cotizacion = new Cotizacion(vendedor.getNextNroCotizacion(), fecha, prenda, cantidadPrendas, vendedor);
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
