package objetos.futbol.UI.menuconsola;

import java.io.File;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.GestorBDEstado;
/**
 * Clase para finalizar un partido
 * @author Jhon Eider Murillo Usuga
 *
 */
public class FinalizarPartido extends OpcionDeMenu {
	/**
	 * Constructor de la clase para acceder al tipo de categoria que tiene la clase
	 * @param categoria
	 */
	public FinalizarPartido(Categoria categoria) {
		super(categoria);		
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta la opcion de menu finalizar partido
	 */
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		File fichero = new File("src\\gestorBD\\Buffer.txt");
		if(!fichero.exists()){
			System.out.println("Porfavor inicie un partido antes");
			return;
		}
		Main.gestorEstado.guardarEstado();
		Main.gestorEstado.leerEstado();
		Main.pausa = false;
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Finalizar Partido";
	}//Cierre del metodo	
}//Cierre de la clase
