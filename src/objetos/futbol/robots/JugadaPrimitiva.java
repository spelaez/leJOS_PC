package objetos.futbol.robots;

public abstract class JugadaPrimitiva {
	protected int velocidad;
	
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}
	public abstract String ordenJugada();
	public abstract int getID_JUGADA();
	public int getVelocidad(){
		return velocidad;
	}
	public void cambioVelocidad(int factor){
		velocidad = velocidad+factor;
	}
	
	public void cambioVelocidadA(int factor){
		velocidad = velocidad*factor;
	}
	
}
