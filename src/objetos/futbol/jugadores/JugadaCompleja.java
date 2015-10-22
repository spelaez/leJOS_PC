package objetos.futbol.jugadores;

public abstract class JugadaCompleja {
	private String nombreJugada;
	private final String fechaCreacion;
	// private final UsuarioAdministrador Autor; 
	//private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	
	public JugadaCompleja(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		this.nombreJugada=nombreJugada;
		this.fechaCreacion=fechaCreacion;
		this.Autor=Autor;
		this.Jugada=Jugada;
		this.Explicacion=Explicacion;
		
	}

}
