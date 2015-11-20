package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import java.util.ArrayList;
/**
 * Clase que define la opcion de lista de jugadas disponibles
 * @author Santiago Pelaez
 *
 */
public class ListaJugadasDisponibles extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion lista de jugadas disponibles
	 * @param categoria
	 */
	public ListaJugadasDisponibles(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta la opcion de menu para mostrar las jugadas disponibles
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		
		ArrayList<JugadaComplejaDefensiva> jDefensivas = new ArrayList<>();
		ArrayList<JugadaComplejaOfensiva> jOfensivas = new ArrayList<>();
		ArrayList<JugadaComplejaTiroLibre> jTiroLibre = new ArrayList<>();
		
		for(JugadaCompleja x: Main.listaJugadasComplejas){
				if(x instanceof JugadaComplejaDefensiva){
					jDefensivas.add((JugadaComplejaDefensiva) x);
				}
				else if(x instanceof JugadaComplejaOfensiva){
					jOfensivas.add((JugadaComplejaOfensiva) x);
				}
				else if(x instanceof JugadaComplejaTiroLibre){
					jTiroLibre.add((JugadaComplejaTiroLibre)x);
				}
		}
		System.out.println("\t\t\tJugadas Defensivas");
		for(JugadaComplejaDefensiva x: jDefensivas){
			System.out.println((Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
		}
		System.out.println("\n\t\t\tJugadas Ofensivas");
		for(JugadaComplejaOfensiva x: jOfensivas){
			System.out.println((Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
		}
		System.out.println("\n\t\tJugadas Tiro Libre");
		for(JugadaComplejaTiroLibre x: jTiroLibre){
			System.out.println((Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Jugadas disponibles";
	}//Cierre del metodo
}//Cierre de la clase
