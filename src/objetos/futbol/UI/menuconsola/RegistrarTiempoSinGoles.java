package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
/**
 * Clase que define la opnción de registrar el tiempo sin gol
 * @author Jhon Eider Murrillo
 *
 */
public class RegistrarTiempoSinGoles extends OpcionDeMenu  {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción de registrar tiempo sin goles
	 * @param categoria
	 */
	public RegistrarTiempoSinGoles(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que se ejecuta para contar cuanto tiempo lleva sin hacerle goles al arquero
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		if(Main.r1.getJugador() instanceof Arquero){
			((Arquero)(Main.r1.getJugador())).registrarTiempoGol((int)(System.currentTimeMillis()- Main.tUltimoGol)/1000);
		}
		else if(Main.r2.getJugador() instanceof Arquero){
			((Arquero)(Main.r2.getJugador())).registrarTiempoGol((int)(System.currentTimeMillis()- Main.tUltimoGol)/1000);
		}
		else{
			System.out.println("Error: No hay Arquero en el equipo");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 *Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Registrar tiempo sin goles";
	}//Cierre del método
	
}//Cierre de la clase
