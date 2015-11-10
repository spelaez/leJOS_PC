package objetos.futbol.jugadores;

import java.util.ArrayList;
/**
 * Clase para definir un delantero, consta de un ArraysList que muestra la cantidad de jugadas complejas que tiene el delatero
 * @author Jonh Eider
 *
 */
public class Delantero extends Futbolista {
	//Campos de la clase
	public short golesMarcados;
	public byte dorsal;
	/**
	 * Definir un delantero
	 * @param nombre
	 * @param posicion
	 * @param golesMarcados
	 * @param dorsal
	 * @param listaJugadas
	 */
	public Delantero(String nombre, String posicion, short golesMarcados, byte dorsal, ArrayList <JugadaCompleja> listaJugadas ){
		super(nombre,posicion,listaJugadas);
		this.golesMarcados = golesMarcados;
		this.dorsal = dorsal;
	}//Cierre del constructor
	/**
	 * M�todo para devolver, sobreescrito del package object
	 */
	@Override
	public String toString(){
		return super.toString() + " con el dorsal " + dorsal + " ha marcado " + golesMarcados;
	}//Cierre del m�todo
	/**
	 * Verifica si el jugador juega con las manos, parametro de salida: false
	 * @return Retorna verdadero si el futbolista juega con las manos
	 */
	public boolean jugarConLasManos(){
		return false;
	}//Cierre del m�todo
	/**
	 * Marca los goles hechos por el delantero
	 */
	public void registrarGol(){
		this.golesMarcados++;
	}//Cierre del m�todo



	public byte getDorsal(){
		return dorsal;
	}
	public short getGolesMarcados(){
		return golesMarcados;
	}
}//Cierre de la clase

