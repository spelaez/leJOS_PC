package objetos.futbol.jugadores;

import  objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * clase para definir una jugada compleja ofensiva, consta de un ArrayList que contiene la cantidad de jugadas primitivas que contiene una jugada compleja
 * @author Santiago Saladarriaga, Jhon Eider Murillo, Juan Pablo Betancur, Santiago Pelaez
 *
 */
public class JugadaComplejaOfensiva extends JugadaCompleja {
	//Campos de la clase
	private int efectividad;
	private String descripcion;
	/**
	 * Definir una jugada compleja ofensiva
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param Autor
	 * @param Jugada
	 * @param Explicacion
	 */
	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.efectividad= super.getJugada().size();
		this.descripcion= "La jugada " + nombreJugada + " es una " + getEfectividad()+  ", fue creada por " + Autor + ", en la fecha " + fechaCreacion;
	}//Cierre del constructor
	/**
	 * Método para dovolver el tipo de jugada (defensiva, ofensiva o tiro libre) sobreescrita de la clase JugadaCompleja
	 */
	@Override
	public String identificarJugada() {
		return "Jugada Ofensiva";
	}//Cierre del método
	/**
	 * Método propio de la jugada compleja ofensiva que muestra que tan efectiva es una jugada dependiendo de la cantidad de jugadas primitivas que contenga
	 * @return Efectividad
	 */
	private String getEfectividad(){
		if (efectividad ==1){
		return "jugada poco efectiva, numero de jugadas " + efectividad;
		}
		else if(efectividad==  2){
			return "jugada medianamente efectiva, numero de jugadas " + efectividad ;
		}
		else if (efectividad >= 3){
			return "jugada efectiva, numero de jugadas " + efectividad;
		}
		else{
			return "no existe jugada";
		}
	}//Cierre del método
	/**
	 * Método para acceder a la descripcion de la jugada
	 * @return descripcion
	 */
	public String getDescripcion(){
		return descripcion;
	}//Cierre del método
}//cierre de la clase
