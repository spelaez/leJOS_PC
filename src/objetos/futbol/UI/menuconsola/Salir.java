package objetos.futbol.UI.menuconsola;

import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.varios.GestorBDEstado;
import objetos.futbol.varios.GestorBDJugadasComplejas;
/**
 * Clase que permite salir del programa, guardando los cambios hechos por el usuario
 * @author Santiago Pélaez
 *
 */
public class Salir extends OpcionDeMenu{
	/**
	 * Construtor de la clase que determina la categoria de la opción
	 * @param categoria
	 */
	public Salir(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta la opción salir que guarda los cambios
	 */
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		new GestorBDUsuarios().guardarUsuarios();
		new GestorBDJugadores().guardarJugadores();
		new GestorBDJugadasComplejas().guardarJugadas();
		new GestorBDEstado().guardarEstado();
		System.exit(0);
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	public String toString(){
		return "Salir";
	}//Cierre del método
}//Cierre de la clase
