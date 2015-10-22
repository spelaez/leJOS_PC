package objetos.futbol.jugadores;

public class Delantero extends Futbolista {
	public short golesMarcados;
	public byte dorsal;
	
	public Delantero(String nombre, String posicion, short golesMarcados, byte dorsal ){
		super(nombre,posicion);
		this.golesMarcados = golesMarcados;
		this.dorsal = dorsal;
	}
	
	@Override
	public String toString(){
		return super.toString() + " con el dorsal " + dorsal + " ha marcado " + golesMarcados;
	}
	
	public boolean jugarConLasManos(){
		return false;
	}
	
}
