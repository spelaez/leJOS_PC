package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
public class JugadaComplejaTiroLibre extends JugadaCompleja {

	public JugadaComplejaTiroLibre(String nombreJugada,String fechaCreacion,UsuarioAdminitrador Autor,ArrayList<JugadaPrimitiva> jugada,String Explicacion){
		super(nombreJugada,fechaCreacion,Autor,jugada,Explicacion);
	}
	
	@Override
	public String identificarJugada() {
		return "Jugada Tiro Libre";
	}

}
