package objetos.futbol.robots;
/**
 * Clase para definir la jugada primitiva chutar 
 * @author Santiago Peláez
 *
 */
public class Chutar extends JugadaPrimitiva {
	//Campos de clase
	private int idJugada;
	private int grados;
	/**
	 * Constructor para asígnar la velocidad y los grados con los que chuta 
	 * @param velocidad
	 * @param grados
	 */
	public Chutar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
		setIdJugada();
	}//Cierre del cosntructor
	/**
	 * Método para consultar el tipo de jugada
	 */
	public int getIdJugada(){
		return idJugada;
	}//Cierre del método
	/**
	 * Método para modificar el tipo de jugada primitiva
	 */
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 6;
		}
		else{
			idJugada = 7;
		}
	}//Cierre del método
	/**
	 * Metodo para cosultar los grados 
	 * @return Retorna el campo grados
	 */
	public int getGrados(){
		return grados;
	}//Cierre del método
}//Cierre de la clase
