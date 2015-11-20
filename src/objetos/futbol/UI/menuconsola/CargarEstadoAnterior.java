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
	 * Constructor que accesa al tipo de categoria que tiene la opci�n
	 * @param categoria
	 */
	public CargarEstadoAnterior(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que ejecuta el la opci�n de men� cargar estado
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
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Reanudar partido";
	}//Cierre del m�todo
}//Cierre de la clase
