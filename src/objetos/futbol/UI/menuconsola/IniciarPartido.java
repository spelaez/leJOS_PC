package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que defnie la opcion iniciar partido
 * @author Santiago Peláez
 *
 */
public class IniciarPartido extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion iniciar partido
	 * @param categoria
	 */
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menu para iniciar partido
	 */
	@Override
	public void ejecutar() {
		System.out.print("-----------------------------------------------------------"+this);
		Main.tInicio = System.currentTimeMillis();
		Main.tUltimoGol = Main.tInicio;
		System.out.print("Partido Iniciado\n-----------------------------------------------------------");
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Iniciar Partido...";
	}//Cierre del método
}//Cierre de la clase
