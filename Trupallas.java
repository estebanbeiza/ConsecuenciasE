package PConsecuencias;

public class Trupallas extends Carro {
	private int nivelArmadura;
	private String nombre;
	
	Trupallas(){
		super();	
	}
	
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