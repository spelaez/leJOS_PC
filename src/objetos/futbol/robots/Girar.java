package objetos.futbol.robots;

public class Girar extends JugadaPrimitiva {
	private int idJugada = 4;
	public Girar(int velocidad, int grados){
		super(velocidad);
		if(grados == 45){
			idJugada = 4;
		}else if (grados == -45){
			idJugada = 5;
		}
		}

	public int getIdJugada(){
		return idJugada;
	}
	
	public int getGrados(){
		return idJugada == 4 ? 45 : -45;
	}
}
