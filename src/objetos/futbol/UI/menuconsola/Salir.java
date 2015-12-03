package objetos.futbol.UI.menuconsola;

import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadores;

import javax.swing.JOptionPane;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.GestorBDEstado;
import objetos.futbol.varios.GestorBDJugadasComplejas;
/**
 * Clase que permite salir del programa, guardando los cambios hechos por el usuario
 * @author Santiago Pelaez
 *
 */
public class Salir extends OpcionDeMenu{
	long tPausa = Main.tInicio;
	/**
	 * Construtor de la clase que determina la categoria de la opcion
	 * @param categoria
	 */
	public Salir(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta la opcion salir que guarda los cambios
	 */
	@Override
	public void ejecutar() {
		
		Object [] textOpcion = { "Si", "NO"};
		int opcion = JOptionPane.showOptionDialog(null, "�Desea salir del sistema?", "salir del sistema",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,textOpcion,null);
		if(opcion == 0){
		new GestorBDUsuarios().guardarUsuarios();
		new GestorBDJugadores().guardarJugadores();
		new GestorBDJugadasComplejas().guardarJugadas();
		System.out.println("Gracias por jugar.");
		System.exit(0);
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	public String toString(){
		return "Salir";
	}//Cierre del metodo
}//Cierre de la clase
