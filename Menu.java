package PConsecuencias;
import java.util.*;

/**
 * 
 * Esta es la clase que realiza las acciones
 * se declara la instancia de la clase Tablero y se prueban sus métodos 
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 *
 */
public class Menu {

	/**
	 * Metodo main de la clase
	 */
	public static void main(String[] args) throws InterruptedException{
		int op = 0, op2 = 0;
		
		//Se instancia la clase Tablero para crear objeto tab1
		//sobre el cual se realiza el juego 
		Tablero tab1 = new Tablero();
		
		//Llena Tablero con espacios en blanco " ";
		tab1.llenarTablero();
		
		System.out.println("Bienvenido a Oscurilandia");
		
		Scanner read = new Scanner(System.in);
		do {
			System.out.println("Seleccione:");
			System.out.println("1.- Creación de tablero Manual");
			System.out.println("2.- Creación de tablero Automático");
			op2 = read.nextInt();
		} while (op2 < 1 || op2 > 2);
		
		
		if (op2 == 1) {
			//Crea Tablero de forma manual
			tab1.crearCarroManual(read);	
			
		} else {
			//Crea 3 Carros tipo Kromis y los ingresa al tablero
			for (int i = 1; i <= 3; i++)
				tab1.crearCarro("K");

			//Crea 5 Carros tipo Trupallas y los ingresa al tablero
			for (int i = 1; i <= 5; i++)
				tab1.crearCarro("C");


			//crea 10 Carros tipo Trupallas y los ingresa al tablero
			for (int i = 1; i <= 10; i++)
				tab1.crearCarro("T");
		}
		
		//Crea una pausa antes de iniciar el menu del juego
		System.out.print("\nCreando escenario del juego");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
		System.out.print("\nEscenario listo comienza el juego\n\n");


		/**
		 * Menu Principal del juego
		 */
		do {
			System.out.println("\n\nMenu del Juego");
			System.out.println("1.- Mostrar Tablero ");
			System.out.println("2.- Lanzar huevos");
			System.out.println("3.- Calcular Puntaje");
			/*
			 * Opcion 4 y 5 se agregaron con la finalidad de
			 * visualizar las listaa para comprobar que fueron creadas
			 * y ver los registros que se van agregando.
			 */
			System.out.println("4.- Mostrar Lista Carros");
			System.out.println("5.- Mostrar Lista Huevos");
			System.out.println("6.- Salir");
			op = read.nextInt();
			switch(op) {
			case 1:
				tab1.mostrarTablero();
				break;
			case 2:
				tab1.lanzarHuevo(read);
				break;
			case 3:
				tab1.calcularPuntaje();
				break;
			case 4:
				tab1.mostrarListaCarros();
				break;
			case 5:
				tab1.mostrarListaHuevos();
				break;
			case 6:
				System.out.println("\n Gracias por jugar vuelve pronto");
				break;
			default:
				break;	
			}

		} while (op != 6);

		read.close();
	
		
		
		
	}

}