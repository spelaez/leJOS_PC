package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase que define la opcion retroceder
 * @author Juan Pablo Betancur
 *
 */
public class Retroceder extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion retroceder
	 * @param categoria
	 */
	public Retroceder(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
		Main.dos.writeInt(Main.retroceder.getIdJugada());
		Main.dos.flush();
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retrona el tipo de opcon
	 */
	@Override
	public String toString(){
		return "Retroceder";
	}//Cierre del método
}//Cierre de la clase
