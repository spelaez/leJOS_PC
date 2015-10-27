package objetos.futbol.robots;

public class MoverAdelante extends JugadaPrimitiva {
	private final int ID_JUGADA = 1;
	
	public MoverAdelante(int velocidad){
		super(velocidad);
	}
	
	@Override
	public String ordenJugada() {
		return ID_JUGADA +"-"+ velocidad;
	}
	
	@Override
	public int getID_JUGADA(){
		return ID_JUGADA;
	}

}
