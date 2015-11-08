package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase que define la opci�n retroceder
 * @author Juan Pablo Betancur
 *
 */
public class Retroceder extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n retroceder
	 * @param categoria
	 */
	public Retroceder(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo sobreescrito de opcion de men�, que imprime el tipo de opci�n, y llama a un m�todo de la clase main del paquete objetos.futbol.UI para enviarla al robot
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
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retrona el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Retroceder";
	}//Cierre del m�todo
}//Cierre de la clase
