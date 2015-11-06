package objetos.futbol.jugadores;

import  objetos.futbol.robots.JugadaPrimitiva;
import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
//clase para definir una jugada compleja ofensiva, consta de un ArrayList que contiene la cantidad de jugadas primitivas que contiene una jugada compleja
public class JugadaComplejaOfensiva extends JugadaCompleja {
	private int efectividad;
	private String descripcion;
	//Definir una jugda compleja ofensiva, Parametros de entrada: nombre de la jugada, fecha de creacion, autor, lista de las jugadas primitivas que componen la jugada compleja
	public JugadaComplejaOfensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.efectividad= super.getJugada().size();
		this.descripcion= "La jugada " + nombreJugada + " es una " + getEfectividad()+  ", fue creada por " + Autor + ", en la fecha " + fechaCreacion;
	}
	//Método para dovolver el tipo de jugada (defensiva, ofensiva o tiro libre) sobreescrita de la clase JugadaCompleja
	@Override
	public String identificarJugada() {
		return "Jugada Ofensiva";
	}
	//Método propio de la jugada compleja ofensiva que muestra que tan efectiva es una jugada dependiendo de la cantidad de jugadas primitivas que contenga
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
	}
	//Método para acceder a la descripcion de la jugada
	public String getDescripcion(){
		return descripcion;
	}
}
