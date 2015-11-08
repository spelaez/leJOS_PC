package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que define la opcion imprimir jugadores
 * @author Juan Pablo Betancur
 *
 */
public class ImprimirJugadores extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción imprimir jugadores
	 * @param categoria
	 */
	public ImprimirJugadores(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú para imprimir los jugadores
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		
		for(int i=0; i<Main.listaJugadores.size(); i++){
			System.out.println("\t\t"+Main.listaJugadores.get(i));
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Lista de jugadores";
	}//Cierre del método
}//Cierre de la clase
