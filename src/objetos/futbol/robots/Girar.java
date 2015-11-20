package objetos.futbol.robots;
/**
 * Clase que define la jugada primitiva girar
 * @author Santiago Pelaez
 *
 */
public class Girar extends JugadaPrimitiva {
	//Campos de clase
	private int idJugada = 4;
	private int grados;
	/**
	 * Constructor para caracterizar un giro
	 * @param velocidad
	 * @param grados
	 */
	public Girar(int velocidad, int grados){
		super(velocidad);
		this.grados=grados;
		setIdJugada();
	}//Cierre del constructor
	/**
	 * Metodo para consultar el tipo de jugada
	 */
	public int getIdJugada(){
		return idJugada;
	}//Ciere del metodo
	/**
	 * Metodo para modificar el tipo de jugada
	 */
	public void setIdJugada(){
		if(grados == 45){
			idJugada = 4;
		}else if (grados == -45){
			idJugada = 5;
		}
	}//Cierre del metodo
	/**
	 * Metodo para consultar los grados a los que gira el robot
	 * @return Retorna el campo grados dependiendo del Id de jugada
	 */
	public int getGrados(){
		return idJugada == 4 ? 45 : -45;
	}//Cierre del metodo
}//Ciere de la clase
