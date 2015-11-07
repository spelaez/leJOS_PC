package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
//Clase que define la opcion imprimir jugadores
public class ImprimirJugadores extends OpcionDeMenu {
	//Método que accesa al tipo de categoria que tiene la opcion imprimir jugadores
	public ImprimirJugadores(Categoria categoria){
		super(categoria);
	}
	//Método que ejecuta el menu para imprimir los jugadores
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		
		for(int i=0; i<Main.listaJugadores.size(); i++){
			System.out.println("\t\t"+Main.listaJugadores.get(i));
		}
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Lista de jugadores";
	}
}
