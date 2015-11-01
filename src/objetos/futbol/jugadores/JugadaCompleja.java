package objetos.futbol.jugadores;
import objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
public abstract class JugadaCompleja {
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor; 
	private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	
	public JugadaCompleja(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		this.nombreJugada=nombreJugada;
		this.fechaCreacion=fechaCreacion;
		this.Autor=Autor;
		this.Jugada=Jugada;
		this.Explicacion=Explicacion;
		
	}
	@Override
	public String toString(){
		return "Jugada "+ nombreJugada;
	}
	
	public boolean equals(JugadaCompleja j){
		
		if (!(j.Jugada.size() == this.Jugada.size())){
			return false;
		}
		for (int i=0; i < j.Jugada.size();i++){
			if(!(this.Jugada.get(i).getIdJugada() == j.Jugada.get(i).getIdJugada())){
				return false;
			}
		
		}
		return true;
	}
	public abstract String identificarJugada();
	protected ArrayList<JugadaPrimitiva> getJugada(){
		return Jugada;
	}

}
