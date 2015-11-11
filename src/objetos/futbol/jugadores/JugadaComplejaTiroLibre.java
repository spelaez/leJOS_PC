package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
import objetos.futbol.robots.Chutar;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase para definir una jugada compleja de tipo tiro libre, consta de un ArrayList que contiene la cantidad de jugadas primitivas que contiene una jugada compleja
 * @author Santiagon Saldarriaga, Jhon Eider Murillo, Juan Pablo Betancur, Santiago Peláez
 *
 */
public class JugadaComplejaTiroLibre extends JugadaCompleja {
	//Campos de la clase
	private int potenciachute;
	private int efecto;
	private String descripcion;
	/**
	 * Método para definir un tiro libre
	 * @param nombreJugada
	 * @param fechaCreacion
	 * @param Autor
	 * @param jugada
	 * @param Explicacion
	 */
	public JugadaComplejaTiroLibre (String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> jugada,String Explicacion){
		super(nombreJugada,fechaCreacion,Autor,jugada,Explicacion);
		JugadaPrimitiva y = super.getJugada().get(super.getJugada().size()-1);
		if(y instanceof Chutar){
			this.potenciachute=y.getVelocidad();
			this.efecto=((Chutar) y).getGrados();
			this.descripcion = "La jugada " + nombreJugada +" es un "+ getPotenciachute() +", con un " +getEfecto()+ ", fue creada por " + Autor.getNombre() + ", en la fecha " + fechaCreacion;
		}
		else{
			throw new ClassCastException();
		}
	}//Cierre del constructor
	/**
	 * Método para dovolver el tipo de jugada (defensiva, ofensiva o tiro libre) sobreescrita de la clase JugadaCompleja
	 */
	@Override
 	public String identificarJugada() {
		return "Jugada Tiro Libre";
	}//Cierre del método
	/**
	 * Método propio de la clase que muestra que tan fuerte se patea al balón
	 * @return potencia chute
	 */
	private String getPotenciachute(){
		if(potenciachute>0 && potenciachute <50){
			return "chute suave";
		}
		else if(potenciachute>=50 && potenciachute<100){
			return "chute medio";
   
		}
		else if (potenciachute>=100){
			return "chute fuerte";
		}
		else{
			return"chute sin potencia";
		}
	}//Cierre del método
	/**
	 * Método propio de la clase que muestra el efecto que tiene la pelota al chutarse
	 * @return efecto
	 */
	private String getEfecto(){
		if(efecto>=18 && efecto<25){
			return "chute directo";
		}
		else if (efecto>=25 && efecto<35){
			return "tiro medio hacia arriba";
		}
		else if(efecto>=35){
			return "tiro vaselina";
		}
		else{
			return "tiro sin efecto";
		}
	}//Cierre del método
	/**
	 * Método para acceder a la descripción del tiro
	 * @return descripcion
	 */
	public String getDescripcion(){
		return descripcion;
	}//Cierre del método
	/**
	 * Método que permite obtener el número de la potencia del chute que tiene la jugada
	 * @return
	 */
	public int getNumPotencia(){
		return potenciachute;
	}//Cierre del método
	/**
	 * Método que permite obtener el número del efecto que tiene la jugada
	 * @return
	 */
	public int getNumEfecto(){
		return efecto;
	}//Cierre del método
}//Cierre de la clase

