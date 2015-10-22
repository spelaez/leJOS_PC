package objetos.futbol.jugadores;

public class Arquero extends Futbolista {
	public int TiempoSinGoles;
	public byte dorsal;
	
public Arquero (String nombre, String posicion, int TiempoSinGoles,byte dorsal){
	super(nombre,posicion);
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
}
