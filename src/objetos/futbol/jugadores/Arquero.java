package objetos.futbol.jugadores;

import java.util.ArrayList;

public class Arquero extends Futbolista {
	public int TiempoSinGoles;
	public byte dorsal;
	
	public Arquero (String nombre, String posicion, int TiempoSinGoles,byte dorsal, ArrayList <JugadaCompleja> listaJugadas){
		super(nombre,posicion,listaJugadas);
		this.TiempoSinGoles = TiempoSinGoles;
		this.dorsal = dorsal;
	}

	@Override
	public String toString(){
		return super.toString()+" con el dorsal "+ dorsal+ " Tiempo Sin Goles "+TiempoSinGoles;
	}

	public boolean jugarConLasManos(){
		return true;
	}
	
	public void registrarTiempoGol(int tiempo){
		this.TiempoSinGoles = tiempo;
	}
	public byte getDorsal(){
		return dorsal;
	}
	public int getTiempoSinGoles(){
		return TiempoSinGoles;
	}
}
