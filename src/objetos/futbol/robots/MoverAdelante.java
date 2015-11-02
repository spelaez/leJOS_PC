package objetos.futbol.robots;

public class MoverAdelante extends JugadaPrimitiva {
	private int idJugada;
	
	public MoverAdelante(int velocidad){
		super(velocidad);
		setIdJugada();
	}

	public int getIdJugada(){
		return idJugada;
	}
	
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 1;
		}
		else{
			idJugada = 2;
		}
	}

}
