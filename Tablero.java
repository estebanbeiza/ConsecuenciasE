
package PConsecuencias;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Tablero {
	List<Carro> listaCarros;
	List<Huevo> listaHuevos;
	List<Kromis> listaKromis;
	List<Caguanos> listaCaguanos;
	List<Trupallas> listaTrupallas;
	
	String[][] tablero = new String[15][15];
	String[][] tablero2 = new String[7][5];
	int contK = 0, contC = 0, contT = 0, contA = 0, contH;
	
 	
	Tablero() {
		this.listaCarros = new ArrayList<Carro>();
		this.listaHuevos = new ArrayList<Huevo>();
		this.listaKromis = new ArrayList<Kromis>();
		this.listaCaguanos = new ArrayList<Caguanos>();
		this.listaTrupallas = new ArrayList<Trupallas>();
	}
	
	/* 
	 * Metodo validarTablero se utiliza para validar si
	 * la posicion generada aleatoriamente esta ocupada
	 * retorna false si esta desocupada
	 * retorna true si esta ocupada*/
	
	public boolean validarTablero (int fil, int col, String tipo) {
		boolean ocupada = false;
		//System.out.println("Validando posicion en Tablero");
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
	
	
	/*
	 * Metodo ingresarCarro se utiliza para ingresar
	 * un tipo de carro al Tablero, previa validacion
	 * que la posicion no este ocupada*/
	
	public void ingresarCarro(int fil, int col, String tipo) {
		
		if (tipo == "K") {
			for(int i = fil; i < fil + 3; i++) {
				tablero[i][col] = "K";
				//System.out.println(i + " " + col);
			}
			
		} else if (tipo == "C") {
			for (int j = col; j < col + 2; j++) {
				tablero[fil][j] = "C";
				//System.out.println("fila=" + fil + " col=" + j);
			}
			
		} else { //tipo == 'T'
			tablero[fil][col] = "T";
		}
		//System.out.println("Carro tipo " + tipo + " ingreso al tablero");
	}

	/*
	 * Metodo crearCarro se utiliza para generar los objetos del tipo carro
	 * y una vez hechas las validacion se ingresan a la lista general listaCarros
	 * 3 Kromis, 5 Caguanos y 10 Trupallas*/
	
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
		//	System.out.println("inicio");
			Aleatorio num = new Aleatorio(numTipo);
			fil = num.generarNumero();
			col = num.generarNumero();
			
			ocupado = validarTablero (fil,col,tipoCarro);
		//	System.out.println("Posicion ocupada: " + ocupado);
			
		//	if (ocupado == true) {
		//		System.out.println("posicion " + fil + ", " + col + " ocupada");
		//		System.out.println("intentaremos nuevamente con otra posicion");
		//	}
		}
		
	
		
		if (ocupado == false) {
		//	System.out.println("Carro tipo " + tipoCarro + " creado");
			ingresarCarro(fil, col, tipoCarro);
			
			if (tipoCarro == "K") {
				Kromis krom1 = new Kromis(6, "16-06-2016", fil, col,"2015", "Nissan");
				listaCarros.add(krom1);
				listaKromis.add(krom1);
			} else if (tipoCarro == "C" ) {
				Caguanos cagua1 = new Caguanos(4, "20-04-2020", fil, col, 3, "red");
				listaCarros.add(cagua1);
				listaCaguanos.add(cagua1);
			} else {
				Trupallas trup1 = new Trupallas(4, "11-11-2019", fil, col, 5, "Jacob");
				listaCarros.add(trup1);
				listaTrupallas.add(trup1);
			}
			
		}	
		
	} //fin crearCarro()
	
	public void mostrarListaCarros() {
		for(Carro e: listaCarros) {
			System.out.println(e);
		}
	}
	
	public void mostrarTablero () {
		System.out.println("Tablero");
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(tablero[i][j] + "|");
			}
			System.out.println("");
		}
		
		System.out.println("PUNTAJES");
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
		System.out.println("---------------------------------------------");
	}

	public void llenarTablero () {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tablero[i][j] = " ";
			}
		}
	}
	
	
	public void lanzarHuevo() {
		int fil = 0, col = 0, puntaje = 0;
		Huevo h1;
		
		Scanner read = new Scanner(System.in);
		System.out.println("Lanza un huevo a una posicion");
		
		do {
			System.out.println("Ingrese numero Fila(0-14): ");
			fil = read.nextInt();
		} while (fil < 0 || fil > 14);
		
		do {
			System.out.println("Ingrese numero Columna(0-14): ");
			col = read.nextInt();
		} while (col < 0 || col > 14);
		
		//read.close();


		//System.out.println("antes del puntaje " + h1.toString());
		//Luego del lanzamiento comprobamos si dio en el blanco
		//y ademas si destruyo el vehiculo por completo
		if (tablero[fil][col] == "K") {
			System.out.println("Lanzamiento acertado (K)");
			contA++;
			puntaje = 3 + validarVida(fil, col, "K");
			if (validarVida(fil, col, "K") > 0) {
				contK++;
				System.out.println("Kromi destruida");
			}
		} else if (tablero[fil][col] == "C") {
			System.out.println("Lanzamiento acertado (C)");
			contA++;
			puntaje = 2 + validarVida(fil, col, "C");
			if (validarVida(fil, col, "C") > 0) {
				contC++;
				System.out.println("Caguano destruida");
			}
		} else if (tablero[fil][col] == "T") {
			System.out.println("Lanzamiento acertado (T)");
			contA++;
			contT++;
			puntaje = 1; 
		} else {
			System.out.println("Lanzamiento errado");
			puntaje = 0;
		}
		contH++;
		/*
		for (Carro e: listaCarros) {
			if (e.getClass().toString() == "class PConsecuencias.Kromis") {
				System.out.println(e);
			}
		}*/
		tablero[fil][col] = "H";
		//System.out.println(puntaje);

		h1 = new Huevo(fil, col, puntaje);


		listaHuevos.add(h1);
	}
	
	public int validarVida (int fil, int col, String tipo) {
		int puntos = 0;
		if (tipo == "K") {
			//System.out.println("mato un tipo K");
			for (Kromis e: listaKromis) {
				if (e.getColumna() == col) {
					if (e.getFila() == fil) {
						if (tablero[fil+1][col] != "K" 
							&& tablero[fil+2][col] != "K") {
							puntos = 10;
							//System.out.println("Kromi Destruida 1");
						}
					} else if ((fil - e.getFila()) == 1) {
						if (tablero[fil-1][col] != "K"
							&& tablero[fil+1][col] != "K") {
							puntos = 10;
							//System.out.println("Kromi Destruida 2");
						}
						
					} else if ((fil - e.getFila()) == 2) {
						if (tablero[fil-1][col] != "K" 
							&& tablero[fil-2][col] != "K") {
							puntos = 10;
							//System.out.println("Kromi Destruida 3");
						}
					} 
				}
				//index++;
			}
			
		} else if (tipo == "C") {
			//System.out.println("mato un tipo C");
			for (Caguanos e: listaCaguanos) {
				if (e.getFila() == fil) {
					if (e.getColumna() == col) {
						if (tablero[fil][col+1] != "C") {
							puntos = 7;
							//System.out.println("Caguano Destruido 1");
						}				
					} else if ((col - e.getColumna()) == 1) {
						if (tablero[fil][col-1] != "C") {
							puntos = 7;
							//System.out.println("Caguano Destruido 2");
						}
					}
						
				}
			}
			
		} 
		return puntos;
	}
	
	public void calcularPuntaje () {
		System.out.println("Puntaje de Lanzamientos: " + puntajeLanzamiento());
	}
	
	public void mostrarListaHuevos() {
		for(Huevo e : listaHuevos) {
			System.out.println(e);
		}
	}
	
	private int puntajeLanzamiento() {
		int puntaje = 0;
		for (Huevo e: listaHuevos) {
			puntaje += e.getPuntaje();
		}
		return puntaje;
	}

}