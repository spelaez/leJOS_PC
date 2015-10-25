
package objetos.futbol.jugadores;
import  objetos.futbol.robots.JugadaPrimitiva;

public class JugadaComplejaOfensiva extends JugadaCompleja {

	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
	}
	@Override
	public String identificarJugada() {
		
		return "Jugada Ofensiva";
	}

}
