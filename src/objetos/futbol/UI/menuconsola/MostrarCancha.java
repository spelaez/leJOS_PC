package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase para mostrar la cancha
 * @author Santiago Pelaez
 *
 */
public class MostrarCancha extends OpcionDeMenu{
	/**
	 * Metodo que accede al tipo de categoria que tiene la opcion mostrar cancha
	 * @param categoria
	 */
	public MostrarCancha(Categoria categoria){
		super(categoria);
	}//Cierre del metodo
	/**
	 * Metodo que ejecuta la opcion de menu mostrar cancha
	 */
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		Main.cancha.mostrarCancha();
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Mostrar Cancha";
	}//Cierre del metodo	
}//Cierre de la clase
