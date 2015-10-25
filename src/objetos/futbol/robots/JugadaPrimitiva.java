package objetos.futbol.robots;

public abstract class JugadaPrimitiva {
	private int velocidad;
	
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}
	public abstract String ordenJugada();
}
