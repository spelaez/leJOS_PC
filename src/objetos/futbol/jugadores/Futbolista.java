package objetos.futbol.jugadores;

import java.util.ArrayList;

public abstract class Futbolista {
	private String nombre;
	private final String posicion;
	private ArrayList listaJugadas;
	
	public Futbolista(String nombre, String posicion){
		this.nombre = nombre;
		this.posicion = posicion;
	}
	
	@Override
	public String toString(){
		return "El futbolista " + nombre + " juega de " + posicion;
	}
	
	public boolean equals(Futbolista f){
		return this.equals(f);
	}
	
	public abstract boolean jugarConLasManos();
	
}
