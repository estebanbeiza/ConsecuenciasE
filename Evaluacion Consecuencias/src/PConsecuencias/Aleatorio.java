package PConsecuencias;

/**
 * 
 * Clase Aleatorio genera un numero aleatorio desde 0 hasta el rango que se le indique
 * @author: Esteban Beiza / Nadia Rojas / Pamela Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/estebanbeiza/ConsecuenciasE.git">Version en Github</a>
 *
 */
public class Aleatorio {
	//atributo de la clase
	private int numero;
	
	/**
	 *
	 * Constructor de la clase asigna un entero al atributo
	 * @param numero numero entero que se recibe como parametro
	 */
	Aleatorio (int numero) {
		this.numero = numero;
	}
	
	/**
	 * Método genera un numero aletoreo entre 0 y el valor de numero
	 */
	public int generarNumero () {
		return ((int) (Math.random()*numero));
	}
}
