package objetos.futbol.robots;

public class MoverAtras extends JugadaPrimitiva {
	private final int ID_JUGADA = 4;
	
	public MoverAtras(int velocidad){
		super(velocidad);
	}
	
	@Override
	public String ordenJugada() {
		return ID_JUGADA + "-" + velocidad;
	}

	@Override
	public int getID_JUGADA(){
		return ID_JUGADA;
	}
}
