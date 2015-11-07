package objetos.futbol.robots;
/**
 * Clase abastracta que permite caracterizar una jugada primitiva
 * @author Santiago Peláez
 *
 */
public abstract class JugadaPrimitiva {
	//Campos de clase
	protected int velocidad;
	/**
	 * Constructor que define la velocidad de la jugada 
	 * @param velocidad
	 */
	public JugadaPrimitiva(int velocidad){
		this.velocidad = velocidad;
	}//Cierre del constructor
	/**
	 * Método para ver la velocidad de la jugada
	 * @return Retorna el campo velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}//Cierre del método
	/**
	 * Método para identificar el tipo de jugada 	 
	 */
	public abstract int getIdJugada();
}//Cierre de la clase
