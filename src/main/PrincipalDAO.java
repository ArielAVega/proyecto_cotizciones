package main;

import java.util.Scanner;

import dao.DAO;
import dao.imp.PrendaDAOImp;
import model.domain.Prenda;

public class PrincipalDAO {

	public static void main(String[] args) {
		int opcion=0;
		while(opcion!=2) {
			opcion = getOpcion();
			procesarOpcion(opcion);
		}
		
	}
	
	public static int getOpcion() {
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("1-Administrar Prendas");
			System.out.println("2-Salir");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		return opcion;
	}

	public static void procesarOpcion(int opcion) {
		switch(opcion) {
			case 1:{
				visualizarMenuPrendas();
				break;
			}
			case 2:{
				System.out.println("Gracias por usar la aplicación.");
				break;
			}
		}
	}
	
	public static void visualizarMenuPrendas() {
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("1-Registrar Nueva Prenda");
			System.out.println("2-Salir");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		switch(opcion) {
			case 1:{
				//------Solicitud de nombre de prenda
				String nombrePrenda;
				Prenda prenda = null;
				boolean esNombrePrendaValido;
				do{
					System.out.print("Ingresar el nombre de la prenda: ");
					nombrePrenda = scanner.next();
					if(nombrePrenda==null || nombrePrenda.isEmpty()==true) {
						esNombrePrendaValido=false;
						System.err.println("Debe ingresar un nombre de prenda");
					}else {
						esNombrePrendaValido=true;
					}
				}while(esNombrePrendaValido!=true);
				
				//-----Solicitud de precio de prenda
				boolean esPrecioValido;
				double precioLista=0;
				do {		
					try {
						System.out.println("Ingresar precio de lista de la prenda: ");
						precioLista = Double.parseDouble(scanner.next());
						if(precioLista<=0) {
							esPrecioValido=false;
							System.err.println("Debe ingresar un precio de lista válido");
						}else {
							esPrecioValido=true;
						}
					} catch (NumberFormatException e) {
						System.err.println("El precio de lista de la prenda es un valor numérico positivo mayor a cero: ");
						esPrecioValido=false;
					}		
				}while(esPrecioValido!=true);
				
				//--------creación de la Prenda 
				prenda = new Prenda(nombrePrenda, precioLista);
				//--- Se crea la prenda en la base de datos
				DAO<Prenda, Integer> prendaDAO = new PrendaDAOImp();
				prendaDAO.insertar(prenda);
				System.out.println("Prenda registrada en la base de datos");
				System.out.println("Presione una tecla para continuar");
				String tecla = scanner.next();
				break;
			}
		}
	}
	
	
	
}
