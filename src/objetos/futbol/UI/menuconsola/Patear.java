package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase para definir la opción patear
 * @author Juan Pablo Betancur
 *
 */
public class Patear extends OpcionDeMenu{
	/**
	 * constructor para define patear dependeiendo la categoria
	 * @param categoria
	 */
	public Patear(Categoria categoria){
		super(categoria);
	}//Cierre del cosntructor
	/**
	 * Método sobreescrito de opción de menú, que imprime el tipo de opción, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		try{
		Main.dos.writeInt(Main.patear.getIdJugada());
		Main.dos.flush();
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Patear";
	}//Cierre del método
}//Cierre de la clase
