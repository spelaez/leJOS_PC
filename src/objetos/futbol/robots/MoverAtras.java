package objetos.futbol.robots;
/**
 * Clase que define mover atras 
 * @author Santiago Pel�ez
 *
 */
public class MoverAtras extends JugadaPrimitiva {
	//campos de clase
	private final int idJugada = 3;
	/**
	 * Constructor que caracteriza la jugada primitiva mover atras
	 * @param velocidad
	 */
	public MoverAtras(int velocidad){
		super(velocidad);
	}//Cierre del constructor
	/**
	 * M�todo para consultar el tipo de jugada
	 * @return Retorna el ID de la jugada
	 */
	public int getIdJugada(){
		return idJugada;
	}//Cierre del m�todo
}//Cierre de la clase
