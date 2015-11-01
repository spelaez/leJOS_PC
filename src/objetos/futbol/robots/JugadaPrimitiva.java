package objetos.futbol.robots;

public abstract class JugadaPrimitiva {
	protected int velocidad;
	
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}

	public int getVelocidad(){
		return velocidad;
	}
	public void cambioVelocidad(int factor){
		velocidad = velocidad+factor;
	}
	
	public void cambioVelocidadA(int factor){
		velocidad = velocidad*factor;
	}
	public abstract int getIdJugada();
}
