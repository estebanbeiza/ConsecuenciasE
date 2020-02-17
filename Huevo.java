
package PConsecuencias;

public class Huevo {
	private int fila;
	private int columna;
	private int puntaje;
	
	Huevo (int _fila, int _columna){
		this.fila = _fila;
		this.columna = _columna;
		this.puntaje = 0;
	}
	
	
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