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
	public String getComplejidad(){
		if (complejidad ==1){
		return "jugada poco defensiva" ;
		}
		else if(complejidad ==  2){
			return "jugada medianamente defensiva";
		}
		else if (complejidad >= 3){
			return "jugada muy defensiva";
		}
		else{
			return "no existe jugada";
		}
	}
	public void modVel(JugadaComplejaDefensiva X){
		
		for(int i = 0 ; i<super.getJugada().size();i++){
			getJugada().get(i).setVelocidad(2);
			
		}
	}
	


}
