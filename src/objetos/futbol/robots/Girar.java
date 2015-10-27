package objetos.futbol.robots;

public class Girar extends JugadaPrimitiva {
	private final int ID_JUGADA = 2;
	private int grados;
	public Girar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
	}
	@Override
	public String ordenJugada() {
		return ID_JUGADA + "-" + velocidad + "-" + grados;
	}

	@Override
	public int getID_JUGADA(){
		return ID_JUGADA;
	}
}
