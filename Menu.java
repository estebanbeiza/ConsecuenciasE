package PConsecuencias;
import java.util.*;
public class Menu {

	public static void main(String[] args) throws InterruptedException{
		int op = 0;
		
		//Se instancia la clase Tablero para crear objeto tab1
		//sobre el cual se realiza el juego 
		Tablero tab1 = new Tablero();
		
		System.out.println("Bienvenido a la Batalla Oscurilanda");
		
		//Llena Tablero con espacios en blanco " ";
		tab1.llenarTablero();

		//Crea 3 Carros tipo Kromis y los ingresa al tablero
		for (int i = 1; i <= 3; i++)
			tab1.crearCarro("K");


		//Crea 5 Carros tipo Trupallas y los ingresa al tablero
		for (int i = 1; i <= 5; i++)
			tab1.crearCarro("C");


		//crea 10 Carros tipo Trupallas y los ingresa al tablero
		for (int i = 1; i <= 10; i++)
			tab1.crearCarro("T");

		System.out.print("\nCreando escenario del juego");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
		System.out.print("\nEscenario listo comienza el juego\n\n");
		
		/* 
		 * Menu Principal del juego
		 */
		
		Scanner read = new Scanner(System.in);
		do {
			System.out.println("\n\nMenu del Juego");
			System.out.println("1.- Mostrar Tablero ");
			System.out.println("2.- Lanzar huevos");
			System.out.println("3.- Calcular Puntaje");
			System.out.println("4.- Salir");
			op = read.nextInt();
			switch(op) {
			case 1:
				tab1.mostrarTablero();
				break;
			case 2:
				tab1.lanzarHuevo();
				break;
			case 3:
				tab1.calcularPuntaje();
				break;
			case 4:
				System.out.println("\n Gracias por jugar vuelve pronto");
				break;
			default:
				break;	
			}
			
		} while (op != 4);
		
		read.close();
		/*
			//tab1.lanzarHuevo();

			tab1.llenarTablero(); //Llena Tablero con espacios en blanco " ";

			//test crear arreglo de objetos;
			//tab1.creaDatosKromi();

			//Crea Carros tipo Kromis
			for (int i = 1; i <= 3; i++)
				tab1.crearCarro("K");


			//Crea Carros tipo Trupallas
			for (int i = 1; i <= 5; i++)
				tab1.crearCarro("C");


			//crea Carros tipo Trupallas
			for (int i = 1; i <= 10; i++)
				tab1.crearCarro("T");

			//muestra tablero inicial
			tab1.mostrarTablero();

			//System.out.println(tab1.listaCarros.size());
			//tab1.mostrarListaCarros();

			//Comienza el lanzamiento de huevos
			tab1.lanzarHuevo();
			tab1.lanzarHuevo();
			tab1.lanzarHuevo();

			tab1.mostrarTablero();
			tab1.mostrarListaCarros();
			tab1.mostrarListaHuevos();


		}
*/
		
		
	}

}