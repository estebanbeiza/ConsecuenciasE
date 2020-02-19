package PConsecuencias;

/**
 * 
 * Esta clase contiene los atributos y métodos pertenecientes a la clase Kromis
 * hereda la clase Carros
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 *
 */
public class Kromis extends Carro {
	//Atributos de la clase
	private String anoFabricacion;
	private String marca;
	
	/**
	 *
	 * Constructor vacio de la clase
	 */
	Kromis() {
		super();
	}
	
	
	/**
	 *
	 * Constructor de la clase para ingreso automatico
	 * @param anoFabricacion año de fabricacion del carro
	 * @param marca marca del carro
	 */
	Kromis (int cantidadOcupantes, String fechaIngreso, int fila, int columna, 
			String anoFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.anoFabricacion = anoFabricacion;
		this.marca = marca;
	}
	
	/**
	 *
	 * Constructor de la clase para ingreso manual
	 * @param anoFabricacion año de fabricacion del carro
	 * @param marca marca del carro
	 */
	Kromis (int cantidadOcupantes, String fechaIngreso, int fila, int columna) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.anoFabricacion = "2019";
		this.marca = "General Motors";
	}

	public String getAnoFabricacion() {
		return anoFabricacion;
	}

	public void setAnoFabricacion(String anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return super.toString() + "Kromis [anoFabricacion=" + anoFabricacion + ", marca=" + marca 
				+ "]";
	}
	
	
}