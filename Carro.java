package PConsecuencias;

/**
 * 
 * Esta clase contiene los atributos y métodos pertenecientes a la clase Carro
 * Y será usada como Clase Padre
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 *
 */

public class Carro {
	//Atributos de la clase
	private int cantidadOcupantes;
	private String fechaIngreso;
	private int fila;
	private int columna;
	
	
	/**
	 *
	 * Constructor vacio de la clase asigna valores por defecto a los atributos
	 * @param cantidadOcupantes Cantidad de ocupantes del carro
	 * @param fechaIngreso Fecha de ingreso del carro
	 * @param fila Coordenada de fila en tablero
	 * @param columna Coordenada de columna en tablero
	 */
	Carro () {
		this.cantidadOcupantes = 0;
		this.fechaIngreso = "";
		this.fila = 0;
		this.columna = 0;
	}
	
	
	/**
	 *
	 * Constructor de la clase
	 * @param cantidadOcupantes Cantidad de ocupantes del carro
	 * @param fechaIngreso Fecha de ingreso del carro
	 * @param fila Coordenada de fila en tablero
	 * @param columna Coordenada de columna en tablero
	 */
	Carro(int cantidadOcupantes, String fechaIngreso, int fila, int columna) {
		this.cantidadOcupantes = cantidadOcupantes;
		this.fechaIngreso = fechaIngreso;
		this.fila = fila;
		this.columna = columna;
	}

	public int getCantidadOcupantes() {
		return cantidadOcupantes;
	}

	public void setCantidadOcupantes(int cantidadOcupantes) {
		this.cantidadOcupantes = cantidadOcupantes;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	

	@Override
	public String toString() {
		return "Carro [cantidadOcupantes=" + cantidadOcupantes + ", fechaIngreso=" + fechaIngreso + ", fila=" + fila
				+ ", columna=" + columna + "] ";
	}
	
	
	
}