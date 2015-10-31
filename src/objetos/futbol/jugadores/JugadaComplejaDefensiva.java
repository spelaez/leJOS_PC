package objetos.futbol.jugadores;

import java.util.ArrayList;

import objetos.futbol.robots.JugadaPrimitiva;

public class JugadaComplejaDefensiva extends JugadaCompleja {
	private int complejidad;

	
	public JugadaComplejaDefensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.complejidad=super.getJugada().size();
		
	}
	
	
	@Override
	public String identificarJugada() {
		return "Jugada Defensiva";
	}
	public int getCompljidad(){
		return complejidad;
	}
	
	


}
