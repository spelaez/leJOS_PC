package objetos.futbol.jugadores;

import java.util.ArrayList;
/**
 * Clase para definir un arquero, consta de un ArrayList que dice la cantidad de jugadas complejas que tiene el arquero
 * @author Santiago Saldarraiga
 *
 */
public class Arquero extends Futbolista {
	//Campos de la clase
	public int TiempoSinGoles;
	public byte dorsal;
	/**
	 *  Definir un arquero
	 * @param nombre
	 * @param posicion
	 * @param TiempoSinGoles
	 * @param dorsal
	 * @param listaJugadas
	 */
	public Arquero (String nombre, String posicion, int TiempoSinGoles,byte dorsal, ArrayList <JugadaCompleja> listaJugadas,String imagen){
		super(nombre,posicion,listaJugadas,imagen);
		this.TiempoSinGoles = TiempoSinGoles;
		this.dorsal = dorsal;
	}//Cierre del constructor
	/**
	 * Metodo para devolver, sobreescrito del package object
	 */
	@Override
	public String toString(){
		return super.toString()+" con el dorsal "+ dorsal+ " Tiempo Sin Goles "+TiempoSinGoles;
	}//Cierre del metodo
	/**
	 * Verifica si el jugador juega con las manos
	 * @return Retorna verdadero si el futbolista juega con las manos  
	 */
	public boolean jugarConLasManos(){
		return true;
	}//Cierre del metodo
	/**
	 * Metodo que permite modificar el tiempo sin goles que lleva el arquero
	 * @param tiempo
	 */
	public void registrarTiempoGol(int tiempo){
		this.TiempoSinGoles = tiempo;
	}//Cierre del metodo
	/**
	 * Muestra la dorsal que lleva el jugador
	 * @return Retorna el numero de la dorsal
	 */
	public byte getDorsal(){
		return dorsal;
	}//Cierre del metodo
	/**
	 * Muestra el tiempo sin goles que lleva el arquero
	 * @return Retorna el tiempo
	 */
	public int getTiempoSinGoles(){
		return TiempoSinGoles;
	}//Cierre del metodo
}//Cierre de la clase

