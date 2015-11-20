package objetos.futbol.jugadores;

import java.util.ArrayList;

/**
 *  Clase abstracta que define un tipo de futbolista, consta de un ArrayList que guarda la cantidad de jugadas complejas que tiene el futbolista
 * @author Santiago Pelaez
 *
 */
public abstract class Futbolista {
	//Campos de la clase
	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> listaJugadas;
	
	/**
	 *  Definir un futbolista
	 * @param nombre
	 * @param posicion
	 * @param listaJugadas
	 */
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas){
		this.nombre = nombre;
		this.posicion = posicion;
		this.listaJugadas = listaJugadas;
	}//Cierre del constructor
	/**
	 * Metodo para devolver, sobreescrito del package object
	 */
	@Override
	public String toString(){
		return "El futbolista " + nombre + " juega de " + posicion;
	}//Cierre del metodo
	/**
	 * Metodo para verificar si hay futbolistas iguales
	 * @param f
	 * @return El futbolista repetido
	 */
	public boolean equals(Futbolista f){
		return this.equals(f);
	}//Cierre del metodo
	/**
	 * Devuelve los elementos de la lista JugadaCompleja, que serian la lista de jugadas de un futbolista
	 * @return La lista de jugadas
	 */
	public ArrayList<JugadaCompleja> getListaJugadas(){
		return listaJugadas;
	}//Cierre del metodo
	/**
	 * Metodo que muestra el nombre del delantero
	 * @return
	 */
	public String getNombre(){
		return nombre;
	}//Cierre del metodo
	/**
	 * Verifica si el jugador juega con las manos
	 * @return Retorna verdadero si el jugador juega con las manos
	 */
	public abstract boolean jugarConLasManos();
	
}//Cierre de la Clase
