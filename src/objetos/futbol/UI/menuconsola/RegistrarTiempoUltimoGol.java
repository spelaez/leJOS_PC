package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que define la opci�n  que registra el tiempo del ultimo gol
 * @author Jhon Eider Murrillo
 *
 */
public class RegistrarTiempoUltimoGol extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n registrar tiempo del ultimo gol
	 * @param categoria
	 */
	public RegistrarTiempoUltimoGol(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que se ejecuta para mostrar el tiempo del ultimo gol
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		Main.tUltimoGol = System.currentTimeMillis()-Main.tInicio;
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Registrar el tiempo del ultimo gol";
	}//Cierre del m�todo
}//Cierre de la clase
