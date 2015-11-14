package objetos.futbol.cancha;

public class FieldLimitExceededException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -667246155539088747L;

	public FieldLimitExceededException(){
		super("Robot arquero ha sobrepasado la mitad de la cancha, por favor muevalo de nuevo a su posicion inicial");
	}
	

}
