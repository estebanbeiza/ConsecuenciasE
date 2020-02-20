package PConsecuencias;

/**
 * 
 * Esta clase contiene los atributos y métodos pertenecientes a la clase Huevo
 * se usara para registrar los lanzamientos con su posicion y puntaje respectivo
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/estebanbeiza/ConsecuenciasE.git">Versión en Github</a>
 *
 */

public class Huevo {
	//Atributos de la clase
	private int fila;
	private int columna;
	private int puntaje;
	
	/**
	 *
	 * Constructor de la clase
	 * @param fila posicion de fila en tablero
	 * @param columna posicion de columna en tablero
	 * @param puntaje puntaje obtenido de la coordenada fila columna
	 */
	Huevo (int _fila, int _columna, int _puntaje){
		this.fila = _fila;
		this.columna = _columna;
		this.puntaje = _puntaje;
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	
	@Override
	public String toString() {
		return "Huevo [fila=" + fila + ", columna=" + columna + ", puntaje=" + puntaje + "]";
	}
	

	
}