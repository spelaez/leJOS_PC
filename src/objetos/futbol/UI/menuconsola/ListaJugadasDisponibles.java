package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import java.util.ArrayList;

public class ListaJugadasDisponibles extends OpcionDeMenu{
	
	public ListaJugadasDisponibles(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("------------------------------------------------\n"+this);
		
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
					jTiroLibre = new ArrayList<>();
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
		Main.usuarioActual.lanzarMenu();
	}
}
