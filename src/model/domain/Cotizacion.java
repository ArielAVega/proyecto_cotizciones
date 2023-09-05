package model.domain;

/**
 * Representa una cotización realizada por un vendedor
 * @author ariel
 *
 */
public class Cotizacion {
	/**
	 * nro univoco de cotizacion
	 */
	private int nroIdentificacion;
	/**
	 * fecha en la que se realiza la cotización
	 */
	private String fecha;
	/**
	 * prenda cotizada
	 */
	private Prenda prenda;
	/**
	 * cantidad de prendas cotizadas
	 */
	private int cantidadPrendas;
	/**
	 * guarda el cálculo del total de cotización
	 */
	private double totalCotizacion;
	/**
	 * vendedor que realizó la cotización
	 */
	private Vendedor vendedor;
	
	/**
	 * Constructor por defecto
	 */
	public Cotizacion() {
		// TODO Auto-generated constructor stub
	}

	public Cotizacion(int nroIdentificacion, String fecha, Prenda prenda, int cantidadPrendas, Vendedor vendedor) {
		this.nroIdentificacion = nroIdentificacion;
		this.fecha = fecha;
		this.prenda = prenda;
		this.cantidadPrendas = cantidadPrendas;
		this.vendedor = vendedor;
		this.totalCotizacion = this.cantidadPrendas * prenda.getPrecioLista();
	}

	@Override
	public String toString() {
		return "Cotizacion [nroIdentificacion=" + nroIdentificacion + ", fecha=" + fecha + ", prenda=" + prenda
				+ ", cantidadPrendas=" + cantidadPrendas + ", totalCotizacion=" + totalCotizacion + ", vendedor="
				+ vendedor + "]";
	}
	
	
	
}
