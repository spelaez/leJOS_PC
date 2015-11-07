package objetos.futbol.robots;
//Clase que define mover atras 
public class MoverAtras extends JugadaPrimitiva {
	private final int idJugada = 3;
	//Caracteriza la jugada primitiva mover atras
	public MoverAtras(int velocidad){
		super(velocidad);
	}
	//Método para consultar el tipo de jugada
	public int getIdJugada(){
		return idJugada;
	}
}
