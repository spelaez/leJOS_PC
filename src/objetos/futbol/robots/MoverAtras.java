package objetos.futbol.robots;

public class MoverAtras extends JugadaPrimitiva {
	private final int idJugada = 3;
	
	public MoverAtras(int velocidad){
		super(velocidad);
	}
	
	public int getIdJugada(){
		return idJugada;
	}
}
