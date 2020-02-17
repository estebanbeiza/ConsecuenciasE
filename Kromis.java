package PConsecuencias;

public class Kromis extends Carro {
	private String anoFabricacion;
	private String marca;
	
	
	Kromis() {
		super();
	}
	
	Kromis (int cantidadOcupantes, String fechaIngreso, int fila, int columna, 
			String anoFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, fila, columna);
		this.anoFabricacion = anoFabricacion;
		this.marca = marca;
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
		return super.toString() + "Kromis [anoFabricacion=" + anoFabricacion + ", marca=" + marca  + "]";
	}
	
	
}