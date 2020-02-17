package PConsecuencias;

import java.util.Arrays;

public class Caguanos extends Carro {
	private int alcanceTiro;
	private String colorConfeti;
	
	Caguanos () {
		super();
	}
	
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
