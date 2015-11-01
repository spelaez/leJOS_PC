package objetos.futbol.jugadores;
import  objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
public class JugadaComplejaOfensiva extends JugadaCompleja {
	private int efectividad;
	private int pique;
	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.efectividad= super.getJugada().size();
	}
	@Override
	public String identificarJugada() {
		
		return "Jugada Ofensiva";
	}
	public String getEfectividad(){
		if (efectividad ==1){
		return "jugada poco efectiva " + " numero de jugadas " + efectividad;
		}
		else if(efectividad==  2){
			return "jugada medianamente efectiva"+" numero de jugadas " + efectividad ;
		}
		else if (efectividad >= 3){
			return "jugada efectiva"+ " numero de jugadas " + efectividad;
		}
		else{
			return "no existe jugada";
		}
	}
	public void modVelAtaque(){
		
		for(int i = 0 ; i<super.getJugada().size();i++){
			getJugada().get(i).cambioVelocidadA(pique);
			
		}

	}
}
