package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Delantero;
/**
 * Clase que define la opcion registrar gol a favor
 * @author Santiago Pelaez
 *
 */
public class RegistrarGolAFavor extends OpcionDeMenu{
	//Constructor que accesa al tipo de categoria que tiene la opcion registrar gol a favor
	public RegistrarGolAFavor(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que se ejecuta para registrar goles marcados por un delantero
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		if(Main.r1.getJugador() instanceof Delantero){
			((Delantero)(Main.r1.getJugador())).registrarGol();;
		}
		else if(Main.r2.getJugador() instanceof Delantero){
			((Delantero)(Main.r2.getJugador())).registrarGol();
		}
		else System.out.print("Error: No hay delanteros en el equipo");
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Registrar gol a favor";
	}//Cierre del metodo
}//Cierre de la clase

