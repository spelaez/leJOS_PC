package objetos.futbol.jugadores;

import java.util.ArrayList;

// Clase abstracta que define un tipo de futbolista, consta de un ArrayList que guarda la cantidad de jugadas complejas que tiene el futbolista
public abstract class Futbolista {
	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> listaJugadas;
	
	// Definir un futbolista, Parametros de entrada: nombre, posicion, Tiempo sin goles, lista de jugadas complejas
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas){
		this.nombre = nombre;
		this.posicion = posicion;
		this.listaJugadas = listaJugadas;
	}
	//Método para imprimir sobreescrito del package object
	@Override
	public String toString(){
		return "El futbolista " + nombre + " juega de " + posicion;
	}
	//Método para verificar si hay futbolistas iguales
	public boolean equals(Futbolista f){
		return this.equals(f);
	}
	//Devuelve los elementos de la lista JugadaCompleja que serian la lista de jugadas de un futbolista
	public ArrayList<JugadaCompleja> getListaJugadas(){
		return listaJugadas;
	}
	//Verifica si el jugador juega con las manos
	public abstract boolean jugarConLasManos();
	
}
