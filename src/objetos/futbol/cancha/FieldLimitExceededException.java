package objetos.futbol.cancha;
/**
 * Clase que define una excepcion para cuando el robot arquero se pase de la mitad de la cancha
 * @author Santiago Pelaez
 *
 */
public class FieldLimitExceededException extends Exception{
	//Campos de clase
	private static final long serialVersionUID = -667246155539088747L;
	/**
	 * Metodo que muestra si el robot sobrepaso los limites de la cancha
	 */
	public FieldLimitExceededException(){
		super("Robot arquero ha sobrepasado la mitad de la cancha, por favor muevalo de nuevo a su posicion inicial");
	}//Cierre del metodo
}//Cierre de la clase
