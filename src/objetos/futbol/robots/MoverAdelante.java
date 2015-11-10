package objetos.futbol.robots;
/**
 * Clase para definir la jugada mover adelante
 * @author Santiago Peláez
 *
 */
public class MoverAdelante extends JugadaPrimitiva {
	//Campos de clase
	private int idJugada;
	/**
	 * Constructor que caracteriza la jugada mover adelante
	 * @param velocidad
	 */
	public MoverAdelante(int velocidad){
		super(velocidad);
		setIdJugada();
	}//Cierre del constructor
	/**
	 * Método para consultar el tipo de jugada
	 * @return Retorna el Id de la jugada
	 */
	public int getIdJugada(){
		return idJugada;
	}//Cierre del método
	/**
	 * Método para modificar el tipo de jugada
	 */
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 1;
		}
		else{
			idJugada = 2;
		}
	}//Cierre del método

}//Cierre de la clase
