package objetos.futbol.robots;
/**
 * Clase abstracta que permite caracterizar una jugada primitiva
 * @author Santiago Pelaez
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
	 * Metodo para ver la velocidad de la jugada
	 * @return Retorna el campo velocidad
	 */
	public int getVelocidad(){
		return velocidad;
	}//Cierre del metodo
	/**
	 * Metodo para identificar el tipo de jugada 	 
	 */
	public abstract int getIdJugada();
}//Cierre de la clase
