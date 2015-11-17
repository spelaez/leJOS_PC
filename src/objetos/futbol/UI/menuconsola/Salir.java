package objetos.futbol.UI.menuconsola;

import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.UI.Main;
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
		String option;
		System.out.println("Porfavor seleccione una opcion");
		System.out.println("1.Pausar partido \n" + "2.Salir del sistema");
		option = Main.scn.nextLine();
		while(Integer.valueOf(option)< 1 || Integer.valueOf(option)> 2){
			System.out.println("Dato fuera de rango, porfavor ingrece una opcion valida");
			option = Main.scn.nextLine();
		}
		if(Integer.valueOf(option) == 1){
			new GestorBDEstado().guardarEstado();
			return;
		}
		else if(Integer.valueOf(option)==2){
		new GestorBDUsuarios().guardarUsuarios();
		new GestorBDJugadores().guardarJugadores();
		new GestorBDJugadasComplejas().guardarJugadas();
		System.out.println("Gracias por jugar.");
		System.exit(0);
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	public String toString(){
		return "Salir";
	}//Cierre del método
}//Cierre de la clase
