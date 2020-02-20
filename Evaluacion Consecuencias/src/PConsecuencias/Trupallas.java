package PConsecuencias;

/**
 * 
 * Esta clase contiene los atributos y metodos pertenecientes a la clase Trupallas
 * hereda la clase Carros
 * @author: Esteban Beiza / Nadia Rojas / Pamela Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/estebanbeiza/ConsecuenciasE.git">Version en Github</a>
 *
 */
public class Trupallas extends Carro {
	//Atributos de la clase
	private int nivelArmadura;
	private String nombre;
	
	/**
	 *
	 * Constructor vacio de la clase
	 */
	Trupallas(){
		super();	
	}
	
	/**
	 *
	 * Constructor de la clase
	 * @param nivelArmadura (valores entre 1 y 5)
	 * @param nombre nombre de la persona que maneja
	 */
	Trupallas(int cantidadOcupantes, String fechaIngreso, int fila, int columna, int nivelarmadura, String nombre){
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.nivelArmadura = nivelarmadura;
		this.nombre = nombre;
	}

	public int getNivelArmadura() {
		return nivelArmadura;
	}

	public void setNivelArmadura(int nivelArmadura) {
		this.nivelArmadura = nivelArmadura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return super.toString() + "Trupallas [nivelArmadura=" + nivelArmadura + ", nombre=" + nombre + "]";
	}
	

}