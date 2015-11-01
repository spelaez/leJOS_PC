package objetos.futbol.robots;

public class Girar extends JugadaPrimitiva {
	private final int idJugada = 4;
	private int grados;
	public Girar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
	}

	public int getIdJugada(){
		return idJugada;
	}
	
	public int getGrados(){
		return grados;
	}
}
