package objetos.futbol.robots;
//Clase abastracta que permite caracterizar una jugada primitiva
public abstract class JugadaPrimitiva {
	protected int velocidad;
	//Método que define la velocidad de la jugada 
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}
	//Método para ver la velocidad de la jugada
	public int getVelocidad(){
		return velocidad;
	}
	//Método para identificar el tipo de jugada 
	public abstract int getIdJugada();
}
