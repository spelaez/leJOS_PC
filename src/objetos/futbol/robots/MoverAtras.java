package objetos.futbol.robots;

public class MoverAtras extends JugadaPrimitiva {
	private final int ID_Jugada = 0;
	
	public MoverAtras(int velocidad){
		super(velocidad);
	}
	
	@Override
	public String ordenJugada() {
		return ID_Jugada + "-" + "velocidad";
	}

}
