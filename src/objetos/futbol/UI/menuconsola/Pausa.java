package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.GestorBDEstado;
/**
 * Clase para mostrar la cancha
 * @author Santiago Pelaez
 *
 */
public class Pausa extends OpcionDeMenu{
	/**
	 * Metodo que accede al tipo de categoria que tiene la opcion mostrar cancha
	 * @param categoria
	 */
	public Pausa(Categoria categoria){
		super(categoria);
	}//Cierre del metodo
	/**
	 * Metodo que ejecuta la opcion de menu mostrar cancha
	 */
	@Override
	public void ejecutar() {
		new GestorBDEstado().guardarEstado();
		System.out.println("dio no joda");
		Main.tPausa = (System.currentTimeMillis() - Main.tInicio);
		Main.pausa =true;
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Pausar";
	}//Cierre del metodo	
}//Cierre de la clase
