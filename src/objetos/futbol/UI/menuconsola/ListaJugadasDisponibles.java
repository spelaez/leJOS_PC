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
		
		Main.v2.ta1.setText(null);
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
		Main.v2.ta1.append("Jugadas Defensivas");
		for(JugadaComplejaDefensiva x: jDefensivas){
			Main.v2.ta1.append("\n"+(Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
		}
		Main.v2.ta1.append("\n Jugadas Ofensivas");
		for(JugadaComplejaOfensiva x: jOfensivas){
			Main.v2.ta1.append("\n"+(Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
		}
		System.out.println("\nJugadas Tiro Libre");
		for(JugadaComplejaTiroLibre x: jTiroLibre){
			Main.v2.ta1.append("\n"+(Main.listaJugadasComplejas.indexOf(x)+1)+" "+x);
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
