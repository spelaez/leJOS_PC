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
	 * Metodo que ejecuta la opción de menu para imprimir los jugadores
	 */
	@Override
	public void ejecutar(){
		if(Main.listaJugadasComplejas.size()==0){
			System.out.println("No hay jugadores disponibles");
			return;
		}
		System.out.print("---------------------------------------------------\n"+this+"\n");
		
		for(int i=0; i<Main.listaJugadores.size(); i++){
			System.out.println("\t\t"+Main.listaJugadores.get(i));
		}
	}//Cierre del metodo
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Lista de jugadores";
	}//Cierre del metodo
}//Cierre de la clase
