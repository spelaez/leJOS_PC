package objetos.futbol.jugadores;

import objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase abstracta que define un tipo de jugada compleja, consta de un ArrayList que contiene la cantidad de jugadas primitivas que tendra la jugada compleja
 * @author santiago Pelaez
 *
 */
public abstract class JugadaCompleja {
	//Campos de la clase
	private String nombreJugada;
	private final String fechaCreacion;
	private final UsuarioAdministrador Autor; 
	private ArrayList<JugadaPrimitiva> Jugada;
	private String Explicacion;
	/**
	 * Definir una jugada compleja
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param Autor
	 * @param Jugada
	 * @param Explicacion
	 */
	public JugadaCompleja(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		this.nombreJugada=nombreJugada;
		this.fechaCreacion=fechaCreacion;
		this.Autor=Autor;
		this.Jugada=Jugada;
		this.Explicacion=Explicacion;

	}//Cierre del constructor
	/**
	 * Metodo para devolver sobreescrito del package object
	 */
	@Override
	public String toString(){
		return "Jugada "+ nombreJugada;
	}//Cierre del metodo
	/**
	 * Metodo para verificar si hay jugadas complejas iguales
	 * @param j
	 * @return Retorna verdadero si hay jugadas complejas repetidas
	 */
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
	}//Cierre del metodo
	/**
	 * Metodo abtracto que permite averiguar el tipo de jugada compleja
	 * @return Retorna el tipo de jugada
	 */
	public abstract String identificarJugada();
	/**
	 * Metodo para acceder a la lista de las jugadas
	 * @return Retorna la jugada
	 */
	public ArrayList<JugadaPrimitiva> getJugada(){
		return Jugada;
	}//Cierre del metodo
	/**
	 * Metodo para acceder a la explicacion de la jugada
	 * @return Retorna la explicacion de la jugada
	 */
	public String getExplicacion(){
		return Explicacion;
	}//Cierre del metodo
	/**
	 * Metodo para acceder al autor de una jugada compleja
	 * @return Retorna el autor
	 */
	public UsuarioAdministrador getAutor(){
		return Autor;
	}//Cierre del metodo
	/**
	 * Metodo para accerde a la fecha en la que se creo una jugada compleja
	 * @return Retorna la fecha de creacion de la jugada
	 */
	public String getfechaCreacion(){
		return fechaCreacion;
	}//Cierre del metodo
	/**
	 * Metodo que muestra el nombre de la jugada compleja
	 * @return Retorna el nombre de la jugada
	 */
	public String getNombre(){
		return nombreJugada;
	}//Cierre del metodo
}//Cierre de la clase
