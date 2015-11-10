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
	public Arquero (String nombre, String posicion, int TiempoSinGoles,byte dorsal, ArrayList <JugadaCompleja> listaJugadas){
		super(nombre,posicion,listaJugadas);
		this.TiempoSinGoles = TiempoSinGoles;
		this.dorsal = dorsal;
	}//Cierre del constructor
	/**
	 * Método para devolver, sobreescrito del package object
	 */
	@Override
	public String toString(){
		return super.toString()+" con el dorsal "+ dorsal+ " Tiempo Sin Goles "+TiempoSinGoles;
	}//Cierre del método
	/**
	 * Verifica si el jugador juega con las manos, parametro de salida: true
	 * @return Retorna verdadero si el futbolista juega con las manos  
	 */
	public boolean jugarConLasManos(){
		return true;
	}//Cierre del método
	/**
	 * Cuenta el tiempo sin goles que lleva el arquero
	 * @param tiempo
	 */
	public void registrarTiempoGol(int tiempo){
		this.TiempoSinGoles = tiempo;
	}//Cierre del método
	public byte getDorsal(){
		return dorsal;
	}
	public int getTiempoSinGoles(){
		return TiempoSinGoles;
	}
}//Cierre de la clase

