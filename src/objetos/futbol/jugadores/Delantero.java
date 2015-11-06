package objetos.futbol.jugadores;

import java.util.ArrayList;
//Clase para definir un delantero, consta de un ArraysList que muestra la cantidad de jugadas complejas que tiene el delatero
public class Delantero extends Futbolista {
	public short golesMarcados;
	public byte dorsal;
	//Definir un delantero, Parametros de entrada: nombre, posicion, goles marcados, dorsal, lista de jugadas comlejas que tiene el delantero
	public Delantero(String nombre, String posicion, short golesMarcados, byte dorsal, ArrayList <JugadaCompleja> listaJugadas ){
		super(nombre,posicion,listaJugadas);
		this.golesMarcados = golesMarcados;
		this.dorsal = dorsal;
	}
	//Método para imprimir sobreescrito del package object
	@Override
	public String toString(){
		return super.toString() + " con el dorsal " + dorsal + " ha marcado " + golesMarcados;
	}
	//Verifica si el jugador juega con las manos, parametro de salidad: false
	public boolean jugarConLasManos(){
		return false;
	}
	//Marca los goles hechos por el delantero
	public void registrarGol(){
		this.golesMarcados++;
	}
}
