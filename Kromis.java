
package PConsecuencias;

public class Kromis extends Carro {
	private String anoFabricacion;
	private String marca;
	private int vida;
	
	Kromis() {
		super();
	}
	
	Kromis (int cantidadOcupantes, String fechaIngreso, int fila, int columna, 
			String anoFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.anoFabricacion = anoFabricacion;
		this.marca = marca;
		this.vida = 3;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return super.toString() + "Kromis [anoFabricacion=" + anoFabricacion + ", marca=" + marca 
				+ /*", vida=" +*/ vida + "]";
	}
	
	
}