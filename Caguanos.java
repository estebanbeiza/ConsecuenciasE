
package PConsecuencias;

import java.util.Arrays;

public class Caguanos extends Carro {
	private int alcanceTiro;
	private String colorConfeti;
	private int[] vida = new int[2];
	
	Caguanos () {
		super();
	}
	
	Caguanos (int cantidadOcupantes, String fechaIngreso, int fila, int columna,
			int alcanceTiro, String colorConfeti) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.alcanceTiro = alcanceTiro;
		this.colorConfeti = colorConfeti;
		this.vida[0] = columna;
		this.vida[1] = columna + 1;
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
				+ colorConfeti + ", vida=" + Arrays.toString(vida) + "]";
	}
	
	

}