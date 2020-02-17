package PConsecuencias;

public class Aleatorio {

	private int numero;
	
	Aleatorio (int numero) {
		this.numero = numero;
	}
	
	public int generarNumero () {
		return ((int) (Math.random()*numero));
	}
}
