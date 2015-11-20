package objetos.futbol.UI.menuconsola;

import java.io.File;

import objetos.futbol.UI.Main;
/**
 * Clase para cargar el estado de un partido, si este fue pausado previamente
 * @author Jhon Eider Murillo Usuga
 *
 */
public  class CargarEstadoAnterior extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion
	 * @param categoria
	 */
	public CargarEstadoAnterior(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el la opcion de menú cargar estado
	 */
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		File fichero = new File("src\\gestorBD\\Estado.xml");
		if(!fichero.exists()){
			System.out.println("Porfavor inicie un partido antes");
			return;
			
		}
		System.out.println("Partido reanudado");
		Main.pausa = false;
		Main.tInicio = System.currentTimeMillis();
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Reanudar partido";
	}//Cierre del metodo
}//Cierre de la clase
