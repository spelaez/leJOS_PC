package objetos.futbol.robots;

public abstract class JugadaPrimitiva {
	protected int velocidad;
	
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}
	public abstract String ordenJugada();
	public abstract int getID_JUGADA();
}
