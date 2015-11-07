package objetos.futbol.robots;
//Clase para definir la jugada mover adelante
public class MoverAdelante extends JugadaPrimitiva {
	private int idJugada;
	//Método que caracteriza la jugada mover adelante
	public MoverAdelante(int velocidad){
		super(velocidad);
		setIdJugada();
	}
	//Método para consultar el tipo de jugada
	public int getIdJugada(){
		return idJugada;
	}
	//Método para modificar el tipo de jugada
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 1;
		}
		else{
			idJugada = 2;
		}
	}

}
