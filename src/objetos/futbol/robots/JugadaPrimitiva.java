package objetos.futbol.robots;

public abstract class JugadaPrimitiva {
	protected int velocidad;
	
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}

	public int getVelocidad(){
		return velocidad;
	}
	
	public abstract int getIdJugada();
}
