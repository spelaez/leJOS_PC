package objetos.futbol.jugadores;

import java.util.ArrayList;
//Clase para definir un arquero, consta de un ArrayList que dice la cantidad de jugadas complejas que tiene el arquero
public class Arquero extends Futbolista {
	public int TiempoSinGoles;
	public byte dorsal;
	// Definir un arquero, Parametros de entrada: nombre, posicion, Tiempo sin goles, dorsal, lista de jugadas complejas
	public Arquero (String nombre, String posicion, int TiempoSinGoles,byte dorsal, ArrayList <JugadaCompleja> listaJugadas){
		super(nombre,posicion,listaJugadas);
		this.TiempoSinGoles = TiempoSinGoles;
		this.dorsal = dorsal;
	}
	//Método para devolver, sobreescrito del package object
	@Override
	public String toString(){
		return super.toString()+" con el dorsal "+ dorsal+ " Tiempo Sin Goles "+TiempoSinGoles;
	}
	//Verifica si el jugador juega con las manos, parametro de salidad: true
	public boolean jugarConLasManos(){
		return true;
	}
	//Cuenta el tiempo sin goles que lleva el arquero
	public void registrarTiempoGol(int tiempo){
		this.TiempoSinGoles = tiempo;
	}
}
