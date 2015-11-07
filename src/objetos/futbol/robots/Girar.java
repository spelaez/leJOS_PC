package objetos.futbol.robots;
//Clase que define la jugada primitiva girar
public class Girar extends JugadaPrimitiva {
	private int idJugada = 4;
	private int grados;
	//Método para caracterizar un giro
	public Girar(int velocidad, int grados){
		super(velocidad);
		this.grados=grados;
		setIdJugada();
	}
	//Método para consultar el tipo de jugada
	public int getIdJugada(){
		return idJugada;
	}
	//Método para modificar el tipo de jugada
	public void setIdJugada(){
		if(grados == 45){
			idJugada = 4;
		}else if (grados == -45){
			idJugada = 5;
		}
	}
	//Método para consultar los grados a los que gira el robot
	public int getGrados(){
		return idJugada == 4 ? 45 : -45;
	}
}
