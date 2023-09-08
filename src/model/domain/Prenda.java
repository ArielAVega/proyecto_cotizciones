package model.domain;

/**
 * Representa las prendas que se pueden cotizar
 * @author ariel
 *
 */

public class Prenda {
	/**
	 * Código de la prenda
	 */
	private int codigo;
	/**
	 * nombre de la prenda
	 */
	private String nombrePrenda;
	/**
	 * precio de lista de la prenda
	 */
	private double precioLista;
	
	/**
	 * Constructor por defecto
	 */
	public Prenda() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * @param codigo codigo de la prenda
	 * @param nombrePrenda nombre de la prenda
	 * @param precioLista precio de lista de la prenda
	 */
	public Prenda(int codigo, String nombrePrenda, double precioLista) {
		this.codigo = codigo;
		this.nombrePrenda = nombrePrenda;
		this.precioLista = precioLista;
	}
	
	@Override
	public String toString() {
		return "Prenda [codigo=" + codigo + ", nombrePrenda=" + nombrePrenda + ", precioLista=" + precioLista + "]";
	}

	/**
	 * Devuelve del código de la prenda
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Devuelve el precio de lista
	 * @return precioLista
	 */
	public double getPrecioLista() {
		return precioLista;
	}
	
	
	
}
