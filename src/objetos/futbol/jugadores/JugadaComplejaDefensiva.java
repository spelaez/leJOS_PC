package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.robots.JugadaPrimitiva;

public class JugadaComplejaDefensiva extends JugadaCompleja {
	private int complejidad;
	private int fuerza;
	
	public JugadaComplejaDefensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion,int fuerza){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.complejidad=super.getJugada().size();
		this.fuerza = fuerza;
	}
	
	
	@Override
	public String identificarJugada() {
		return "Jugada Defensiva";
	}
	
	public String getComplejidad(){
		if (complejidad ==1){
		return "jugada poco defensiva " + " numero de jugadas " + complejidad;
		}
		else if(complejidad ==  2){
			return "jugada medianamente defensiva"+" numero de jugadas " + complejidad ;
		}
		else if (complejidad >= 3){
			return "jugada muy defensiva"+ " numero de jugadas " + complejidad;
		}
		else{
			return "no existe jugada";
		}
	}
	
	public void modVel(){
		for(int i = 0 ; i<super.getJugada().size();i++){
			getJugada().get(i).cambioVelocidad(fuerza);
		}
	}
}
