package PConsecuencias;

public class DatosCarros {
	private Kromis[] kromi;
	private Caguanos[] caguano; 
	private Trupallas[] trupalla;
	
	DatosCarros () {
		this.kromi = new Kromis[3];
		this.caguano = new Caguanos[5];
		this.trupalla = new Trupallas[10];
		
	}
	
	public void creaDatosKromi (int fil, int col) {
		kromi[0] = new Kromis(6, "16-06-2016", fil, col,"2015", "Nissan");
		kromi[1] = new Kromis(7, "17-07-2017", fil, col,"2015", "Nissan");
		kromi[1] = new Kromis(8, "18-08-2018", fil, col,"2015", "Nissan");
	}
	

	
}
