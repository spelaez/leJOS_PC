package objetos.futbol.robots;

public class Chutar extends JugadaPrimitiva {
	private int idJugada;
	private int grados;
	
	public Chutar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 5;
		}
		else{
			idJugada = 6;
		}
		
	}
	public int getIdJugada(){
		return idJugada;
	}
	public int getGrados(){
		return grados;
	}
}
