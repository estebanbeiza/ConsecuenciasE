package PConsecuencias;
/**
 * 
 * Esta clase contiene los atributos y métodos pertenecientes a la clase Caguanos
 * hereda la clase Carros
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 *
 */

public class Caguanos extends Carro {
	//Atributos de la clase
	private int alcanceTiro;
	private String colorConfeti;
	
	
	/**
	 *
	 * Constructor vacio de la clase
	 */
	Caguanos () {
		super();
	}
	
	
	/**
	 *
	 * Constructor de la clase
	 * @param alcanceTiro alcance de tiro del carro
	 * @param colorConfeti color del confeti del carro
	 */
	Caguanos (int cantidadOcupantes, String fechaIngreso, int fila, int columna,
			int alcanceTiro, String colorConfeti) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.alcanceTiro = alcanceTiro;
		this.colorConfeti = colorConfeti;
	}

	public int getAlcanceTiro() {
		return alcanceTiro;
	}

	public void setAlcanceTiro(int alcanceTiro) {
		this.alcanceTiro = alcanceTiro;
	}

	public String getColorConfeti() {
		return colorConfeti;
	}

	public void setColorConfeti(String colorConfeti) {
		this.colorConfeti = colorConfeti;
	}

	@Override
	public String toString() {
		return super.toString() + " Caguanos [alcanceTiro=" + alcanceTiro + ", colorConfeti=" 
				+ colorConfeti + "]";
	}
	
	

}