package objetos.futbol.jugadores;

import objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
//Clase abstracta que define un tipo de jugada compleja, consta de un ArrayList que contiene la cantidad de jugadas primitivas que tendrá la jugada compleja
public abstract class JugadaCompleja {
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor; 
	private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	//Definir una jugada compleja, Parametros de entrada: nombre de la jugada, fecha de creacion, un autor de la jugada, una lista de jugadas primitivas y una explicacion de la jugada
	public JugadaCompleja(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		this.nombreJugada=nombreJugada;
		this.fechaCreacion=fechaCreacion;
		this.Autor=Autor;
		this.Jugada=Jugada;
		this.Explicacion=Explicacion;
		
	}
	//Método para devolver sobreescrito del package object
	@Override
	public String toString(){
		return "Jugada "+ nombreJugada;
	}
	//Método para verificar si hay jugadas complejas iguales
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
	//Método abtracto que permite averiguar el tipo de jugada compleja
	public abstract String identificarJugada();
	//Método para acceder a la lista de las jugadas
	public ArrayList<JugadaPrimitiva> getJugada(){
		return Jugada;
	}
	//Método para acceder a la explciaicon de la jugada
	public String getExplicacion(){
		return Explicacion;
	}
	//Método para acceder al autor de una jugada compleja
	public UsuarioAdministrador getAutor(){
		return Autor;
	}
	//Método para accerde a la fecha en la que se creo una jugada compleja
	public String getfechaCreacion(){
		return fechaCreacion;
	}
}
