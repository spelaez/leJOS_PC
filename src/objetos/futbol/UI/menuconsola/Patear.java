package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase para definir la opci�n patear
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
	 * M�todo sobreescrito de opci�n de men�, que imprime el tipo de opci�n, y llama a un m�todo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
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
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Patear";
	}//Cierre del m�todo
}//Cierre de la clase
