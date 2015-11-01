package objetos.futbol.jugadores;
import  objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
public class JugadaComplejaOfensiva extends JugadaCompleja {
	
	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
	}
	@Override
	public String identificarJugada() {
		
		return "Jugada Ofensiva";
	}

}
