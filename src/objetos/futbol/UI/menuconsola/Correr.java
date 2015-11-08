package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Clase para definir la opci�n correr
 * @author Santiago Pel�ez
 *
 */
public class Correr extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n correr
	 * @param categoria
	 */
	public Correr(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo sobreescrito de opci�n de men�, que imprime el tipo de opci�n, y llama a un m�todo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
			Main.dos.writeInt(Main.correr.getIdJugada());
			Main.dos.flush();
			
		}catch(IOException e){
			System.out.println("No se pudo ejecutar la jugada");
		}
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Correr";
	}//Cierre del m�todo
	
}//Cierre de la clase

