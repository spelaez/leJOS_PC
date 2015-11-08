package objetos.futbol.robots;

public class Chutar extends JugadaPrimitiva {
	private int idJugada;
	private int grados;
	
	public Chutar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
		setIdJugada();
	}
	
	public int getIdJugada(){
		return idJugada;
	}
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 6;
		}
		else{
			idJugada = 7;
		}
	}
	
	public int getGrados(){
		return grados;
	}
}
