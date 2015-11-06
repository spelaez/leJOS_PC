package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.robots.JugadaPrimitiva;
//clase para definir una jugada compleja defensiva, consta de un ArrayList que contiene la cantidad de jugadas primitivas que contiene una jugada compleja
public class JugadaComplejaDefensiva extends JugadaCompleja {
	private int complejidad;
	private String descripcion;
	//Definit una jugada compleja defensiva, Parametros de entrada: nombre de la jugada, fecha de creación,autor, lista de jugadas primitivas y una explicacion de la jugada compleja defensiva
	public JugadaComplejaDefensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.complejidad=super.getJugada().size();
		this.descripcion = "La jugada " + nombreJugada + " es una " + getComplejidad()+ ", fue creada por " + Autor + ", en la fecha " + fechaCreacion;
		}
	//Método para dovolver el tipo de jugada (defensiva, ofensiva o tiro libre) sobreescrita de la clase JugadaCompleja
	@Override
	public String identificarJugada() {
		return "Jugada Defensiva";
	}
	//Método propio para averiguar que dificultad tiene la jugada compleja 
	private String getComplejidad(){
		if (complejidad ==1){
		return "jugada poco defensiva, numero de jugadas " + complejidad;
		}
		else if(complejidad ==  2){
			return "jugada medianamente defensiva, numero de jugadas " + complejidad ;
		}
		else if (complejidad >= 3){
			return "jugada muy defensiva, numero de jugadas " + complejidad;
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
