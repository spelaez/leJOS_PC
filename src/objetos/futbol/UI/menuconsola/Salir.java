package objetos.futbol.UI.menuconsola;

import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.varios.GestorBDEstado;
import objetos.futbol.varios.GestorBDJugadasComplejas;
/**
 * Clase que permite salir del programa, guardando los cambios hechos por el usuario
 * @author Santiago P�laez
 *
 */
public class Salir extends OpcionDeMenu{
	/**
	 * Construtor de la clase que determina la categoria de la opci�n
	 * @param categoria
	 */
	public Salir(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que ejecuta la opci�n salir que guarda los cambios
	 */
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		new GestorBDUsuarios().guardarUsuarios();
		new GestorBDJugadores().guardarJugadores();
		new GestorBDJugadasComplejas().guardarJugadas();
		new GestorBDEstado().guardarEstado();
		System.exit(0);
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	public String toString(){
		return "Salir";
	}//Cierre del m�todo
}//Cierre de la clase
