package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.robots.JugadaPrimitiva;
/**
 * clase para definir una jugada compleja defensiva, consta de un ArrayList que contiene la cantidad de jugadas primitivas que contiene una jugada compleja
 * @author Santiago Saldarriaga, Juan Pablo Betancur, Jhon Eider Murillo, Santiago Pel�ez
 *
 */
public class JugadaComplejaDefensiva extends JugadaCompleja {
	//Campos de la clase
	private int complejidad;
	private String descripcion;
	/**
	 * Definit una jugada compleja defensiva
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param Autor
	 * @param Jugada
	 * @param Explicacion
	 */
	public JugadaComplejaDefensiva(String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> Jugada,String Explicacion){
		super(nombreJugada, fechaCreacion, Autor, Jugada, Explicacion);
		this.complejidad=super.getJugada().size();
		this.descripcion = "La jugada " + nombreJugada + " es una " + getComplejidad()+ ", fue creada por " + Autor + ", en la fecha " + fechaCreacion;
		}//Cierre del constructor
	/**
	 * M�todo para dovolver el tipo de jugada (defensiva, ofensiva o tiro libre) sobreescrita de la clase JugadaCompleja
	 */
	@Override
	public String identificarJugada() {
		return "Jugada Defensiva";
	}//Cierre del m�todo
	/**
	 * M�todo propio para averiguar que dificultad tiene la jugada compleja 
	 * @return complejidad
	 */
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
	}//Cierre del m�todo
	/**
	 * M�todo para acceder a la descripcion de la jugada
	 * @return La descripcion de la jugada
	 */
	public String getDescripcion(){
		return descripcion;
	}//Cierre del metodo
}//Cierre de la clase
