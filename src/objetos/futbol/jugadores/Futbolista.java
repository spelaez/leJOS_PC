package objetos.futbol.jugadores;

import java.util.ArrayList;

public abstract class Futbolista {
	private String nombre;
	private final String posicion;
	private ArrayList<JugadaCompleja> listaJugadas;
	
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas){
		this.nombre = nombre;
		this.posicion = posicion;
		this.listaJugadas = listaJugadas;
	}
	
	@Override
	public String toString(){
		return "El futbolista " + nombre + " juega de " + posicion;
	}
	
	public boolean equals(Futbolista f){
		return this.equals(f);
	}
	
	public ArrayList<JugadaCompleja> getListaJugadas(){
		return listaJugadas;
	}
	
	public abstract boolean jugarConLasManos();
	
}
