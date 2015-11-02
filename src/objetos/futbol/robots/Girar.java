package objetos.futbol.robots;

public class Girar extends JugadaPrimitiva {
	private int idJugada = 4;
	private int grados;
	public Girar(int velocidad, int grados){
		super(velocidad);
		this.grados=grados;
		setIdJugada();
	}

	public int getIdJugada(){
		return idJugada;
	}
	
	public void setIdJugada(){
		if(grados == 45){
			idJugada = 4;
		}else if (grados == -45){
			idJugada = 5;
		}
	}
	
	public int getGrados(){
		return idJugada == 4 ? 45 : -45;
	}
}
