package PConsecuencias;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * Esta es la clase que se utiliza para crear el tablero del juego
 * En ella se declaran las instancias de las clases y se prueban sus métodos 
 * @author: Esteban Beiza / Nadia Rojas / Pamerla Bustos.
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 *
 */

public class Tablero {
	//Atributos de la clase
	private List<Carro> listaCarros;
	private List<Huevo> listaHuevos;
	private String[][] tablero;
	private int contK;
	private int contC;
	private int contT;
	private int contA; 
	private int contH;
	
	/**
	 *
	 * Constructor de la clase inicializa los atributos de la clase Tablero
	 * @param listaCarros ArrayList para los registros de los carros
	 * @param ListaHuevos ArrayList para los registros de los lanzamientos
	 * @param contA contador de Lanzamientos Acertados
	 * @param contK contador de Kromi acertada
	 * @param contC contador de Caguano acertado
	 * @param contT contador de Trupalla acertada
	 * @param contH contador de Lanzamiento realizado
	 */	
	Tablero() {
		this.listaCarros = new ArrayList<Carro>();
		this.listaHuevos = new ArrayList<Huevo>();
		this.tablero = new String[15][15];
		this.contK = 0;
		this.contC = 0;
		this.contT = 0;
		this.contA = 0;
		this.contH = 0;
	}
	
	
	/**
	 * Metodo llena el tablero con espacios en blanco
	 */
	public void llenarTablero () {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tablero[i][j] = " ";
			}
		}
	}
	
	
	/**
	 * Metodo crearCarroManual genera una posicion ingresada manualmente
	 * para cada tipo de carro, valida que la posicion
	 * generada no este ocupada en el tablero, sino esta ocupada
	 * ingresa el carro al tablero.  Y agrega el tipo de carro a
	 * la listaCarros
	 * */
	public void crearCarroManual (Scanner leer) {
		int contaK=0;
		int contaC=0;
		int contaT=0;
		int contaG=0;
		boolean seguir=false;
		do {
			System.out.println("ingrese cantidad de ocupantes");
			int cantocupantes = leer.nextInt();
			System.out.println("ingrese año de ingreso");
			String anoingreso = leer.next();
			System.out.println("Ingrese tipo de carro (kromi | caguano | trupalla");
			String tipocarro=leer.next();
			System.out.println("ingrese fila(0-14)");
			int fila=leer.nextInt();
			System.out.println("ingrese columna (0-14)");
			int columna=leer.nextInt();
			if(contaK<3 || contaC<5 || contaT<10) {
				switch (tipocarro) {
				case "kromi":
					//System.out.println("ingrese a crear kromi");
					if (contaK<3) {
						seguir= validarTablero (fila,columna,tipocarro);
						System.out.println("seguir " + seguir);
						if (seguir==false) {
							Kromis kromi1=new Kromis(cantocupantes, anoingreso, fila, columna);
							listaCarros.add(kromi1);
							for (int i=0; i<3; i++) {
								tablero[fila+i][columna]="K";
								System.out.println(kromi1.toString());
							} 
							contaK++;
							contaG++;
						} else {
							System.out.println("\n\nPosicion ocupada, intenta nuevamente\n\n");
						}
					}
					else
						System.out.println("no tienes mas Kromis");
					break;
				case "caguano":
					if(contaC<5) {
						seguir= validarTablero (fila,columna,tipocarro);
						if (seguir==false) {
							System.out.println("ingrese alcance de tiro");
							int alcance= leer.nextInt();
							System.out.println("ingrese color confeti");
							String color=leer.next();
							Caguanos caguano1=new Caguanos(cantocupantes, anoingreso, fila, columna, alcance, color );
							listaCarros.add(caguano1);
							for (int i=0; i<2; i++) {
								tablero[fila][columna+i]="C";
							}
							contaC++;
							contaG++;
						} else {
							System.out.println("\n\nPosicion ocupada, intenta nuevamente\n\n");
						}
					}
					else
						System.out.println("no tienes mas Caguanos");
					break;
				case "trupalla":
					if (contaT<=10) {
						seguir= validarTablero (fila,columna,tipocarro);
						if (seguir==false) {
							System.out.println("ingrese nivel de armadura(1-5)");
							int nivelarmadura= leer.nextInt();
							System.out.println("ingrese nombre");
							String nombre=leer.next();
							Trupallas trupalla1=new Trupallas(cantocupantes, anoingreso, fila, columna, nivelarmadura, nombre);
							listaCarros.add(trupalla1);
							tablero[fila][columna]="T";
							contaT++;
							contaG++;
						} else {
							System.out.println("\n\nPosicion ocupada, intenta nuevamente\n\n");
						}
					}
					else
						System.out.println("no tienes mas trupallas");
					break;
				}
			}
			System.out.println("contaK=" + contaK + ", contaC=" + contaC + ", contaT="+contaT 
					+ ", contaG=" + contaG);
			mostrarTableroManual();
		}while (contaG<18);
	}
	
	/**
	 * Metodo crearCarro genera una posicion de forma aleatoria
	 * dependendiento del tipo de carro, valida que la posicion
	 * generada no este ocupada en el tablero, sino esta ocupada
	 * ingresa el carro al tablero.  Y agrega el tipo de carro a
	 * la listaCarros
	 * */
	public void crearCarro (String tipoCarro) {
		int fil = 0, col = 0, numTipo = 0;
		boolean ocupado = true;
		
		if (tipoCarro == "K")
			numTipo = 13;
		else if (tipoCarro == "C")
			numTipo = 14;
		else 
			numTipo = 15;
			
		while (ocupado) {
			Aleatorio num = new Aleatorio(numTipo);
			fil = num.generarNumero();
			col = num.generarNumero();			
			ocupado = validarTablero (fil,col,tipoCarro);
		}
		
		if (ocupado == false) {
			//Ingresa carro al tablero en posicion aleatoria);
			ingresarCarro(fil, col, tipoCarro);
			
			//Ingresa registro de carros a listaCarro
			if (tipoCarro == "K") {
				Kromis krom1 = new Kromis(6, "16-06-2016", fil, col,"2015", "Nissan");
				listaCarros.add(krom1);
			} else if (tipoCarro == "C" ) {
				Caguanos cagua1 = new Caguanos(4, "20-04-2020", fil, col, 3, "red");
				listaCarros.add(cagua1);
			} else {
				Trupallas trup1 = new Trupallas(4, "11-11-2019", fil, col, 5, "Jacob");
				listaCarros.add(trup1);
			}
			
		}	
		
	} //fin crearCarro()
	
	
	/** 
	 * Metodo validarTablero se utiliza para validar si
	 * la posicion generada aleatoriamente esta ocupada
	 * retorna false si esta desocupada
	 * retorna true si esta ocupada
	 * */
	public boolean validarTablero (int fil, int col, String tipo) {
		boolean ocupada = false;
		//Validando posicion en Tablero
		if (tipo == "K") {
			for (int i = fil; i < fil+3; i++) {
				if (tablero[i][col] == "K" || tablero[i][col] == "T" 
					|| tablero[i][col] == "C") {
					ocupada = true;
				}
					
			}
		} else if (tipo == "C") {
			for (int j = col; j < col+2; j++) {
				if (tablero[fil][j] == "K" || tablero[fil][j] == "T" 
					|| tablero[fil][j] == "C") {
					ocupada = true;
				}
					
			}
		} else { //tipo == 'T'
				if (tablero[fil][col] == "K" || tablero[fil][col] == "T" 
					|| tablero[fil][col] == "C") {
					ocupada = true;
				}
		}
		return ocupada;
	}
	
	
	/**
	 * Metodo ingresarCarro se utiliza para ingresar
	 * un tipo de carro al Tablero
	 * */
	public void ingresarCarro(int fil, int col, String tipo) {
		
		if (tipo == "K") {
			for(int i = fil; i < fil + 3; i++) {
				tablero[i][col] = "K";
			}
			
		} else if (tipo == "C") {
			for (int j = col; j < col + 2; j++) {
				tablero[fil][j] = "C";
			}
			
		} else { //tipo == 'T'
			tablero[fil][col] = "T";
		}
	}

	/**
	 * Este metodo muestra el Tablero en la creacion manual
	 */
	public void mostrarTableroManual () {
		System.out.println("\nTablero Oscurilandia");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(tablero[i][j] + "|");
			}
			System.out.println("");
		}
	}
	

	/**
	 * Este metodo muestra el Tablero General con los 
	 * lanzamientos y puntajes respectivos
	 */
	public void mostrarTablero () {
		System.out.println("\nTablero Oscurilandia");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(tablero[i][j] + "|");
			}
			System.out.println("");
		}
		
		System.out.println("Estadisticas");
		System.out.println("Kromis destruidas    : " + contK);
		System.out.println("Caguanos destruidos  : " + contC);
		System.out.println("Trupallas destruidas : " + contT);
		System.out.println("Total aciertos       : " + contA);
		System.out.println("Total puntaje        : " + puntajeLanzamiento());
		System.out.println("Total Huevos lanzados: " + contH);
		System.out.println("---------------------------------------------");
		System.out.println("             Detalle de puntos:");
		System.out.println("Puntos x Aciertos (K=3   |  C=2   |   T=1)");
		System.out.println("Puntos x Carros   (Kromis=10 | Caguanos=7)");
		System.out.println("---------------------------------------------\n");
	}

	
	/**
	 * Este metodo se utiliza para lanzar un huevo
	 * a una posicion ingresada por el jugador y luego
	 * registrar el lanzamiento
	 */
	public void lanzarHuevo(Scanner read) {
		int fil = 0, col = 0;
		
		//Scanner read = new Scanner(System.in);
		System.out.println("\nLanza un huevo a una posicion\n");
		
		do {
			System.out.println("Ingrese numero Fila(0-14): ");
			fil = read.nextInt();
		} while (fil < 0 || fil > 14);
		
		do {
			System.out.println("Ingrese numero Columna(0-14): ");
			col = read.nextInt();
		} while (col < 0 || col > 14);
		
		//read.close();

		agregarRegistroHuevo(validarLanzamiento(fil, col));
	}
	
	
	/**
	 * Este metodo valida el lanzamiento, asigna el puntaje, incrementa los contadores
	 * y retorna una instancia de Huevo con los valores de posicion y puntaje obtenido
	 */
	public Huevo validarLanzamiento (int fil, int col) {
		Huevo h1;
		int puntaje = 0;
		
		if (tablero[fil][col] == "K") {
			System.out.println("\nLanzamiento acertado (K)\n");
			contA++;
			puntaje = 3 + validarVidaCarro(fil, col, "K");
			if (validarVidaCarro(fil, col, "K") > 0) {
				contK++;
				System.out.println("\nKromi destruida\n");
			}
		} else if (tablero[fil][col] == "C") {
			System.out.println("\nLanzamiento acertado (C)\n");
			contA++;
			puntaje = 2 + validarVidaCarro(fil, col, "C");
			if (validarVidaCarro(fil, col, "C") > 0) {
				contC++;
				System.out.println("\nCaguano destruido\n");
			}
		} else if (tablero[fil][col] == "T") {
			System.out.println("\nLanzamiento acertado (T)\n");
			contA++;
			contT++;
			puntaje = 1; 
		} else {
			System.out.println("\nLanzamiento errado\n");
			puntaje = 0;
		}
		contH++;
		
		//asignamos H al lanzamiento
		tablero[fil][col] = "H"; 

		h1 = new Huevo(fil, col, puntaje);
		
		return h1;
	}
	
	/**
	 * Metodo recibe un objeto del tipo Huevo 
	 * y la ingresa al Array ListaHuevos
	 */
	public void agregarRegistroHuevo(Huevo egg) {
		listaHuevos.add(egg);
	}
	
	/**
	 * Metodo valida si un Carro del Tablero fue destruido
	 * si es así retorna el puntaje respectivo
	 */
	public int validarVidaCarro (int fil, int col, String tipo) {
		int puntos = 0;
		for (Carro e: listaCarros) {
			if (tipo == "K") {
				if (e.getClass().toString().contentEquals("class PConsecuencias.Kromis")) {
					if (e.getColumna() == col) {
						if (e.getFila() == fil) {
							if (tablero[fil+1][col] != "K" 
									&& tablero[fil+2][col] != "K") {
								puntos = 10;
								//Kromi Destruida 1
							}
						} else if ((fil - e.getFila()) == 1) {
							if (tablero[fil-1][col] != "K"
									&& tablero[fil+1][col] != "K") {
								puntos = 10;
								//Kromi Destruida
							}

						} else if ((fil - e.getFila()) == 2) {
							if (tablero[fil-1][col] != "K" 
									&& tablero[fil-2][col] != "K") {
								puntos = 10;
								//Kromi Destruida
							}
						} 
					}
				} 
			} else if (tipo =="C") {
				if (e.getClass().toString().contentEquals("class PConsecuencias.Caguanos")) {
					if (e.getFila() == fil) {
						if (e.getColumna() == col) {
							if (tablero[fil][col+1] != "C") {
								puntos = 7;
								//Caguano Destruido
							}				
						} else if ((col - e.getColumna()) == 1) {
							if (tablero[fil][col-1] != "C") {
								puntos = 7;
								//Caguano Destruido
							}
						}

					}
				}
				
			} //fin si tipo == "C" o "K"


		} //fin for

		return puntos;
	}
	
	/**
	 * Metodo muestra la suma de todos los lanzamientos
	 * registrados en la listaHuevos
	 */
	public void calcularPuntaje () {
		System.out.println("Puntaje de Lanzamientos: " + puntajeLanzamiento());
	}
	
	/**
	 * Metodo retorna la suma de los puntajes de la listaHuevos
	 */
	private int puntajeLanzamiento() {
		int puntaje = 0;
		for (Huevo e: listaHuevos) {
			puntaje += e.getPuntaje();
		}
		return puntaje;
	}
	
	/**
	 * Metodo muestra la Lista huevos
	 */
	public void mostrarListaHuevos() {
		for(Huevo e : listaHuevos) {
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo muestra la lista de carros
	 */
	public void mostrarListaCarros() {
		for(Carro e: listaCarros) {
			System.out.println(e);
		}
	}
	
	

}