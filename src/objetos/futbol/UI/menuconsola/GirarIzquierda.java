package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase que defina la opcion girar a la izquierda
 * @author Juan Pablo Betancur
 *
 */
public class GirarIzquierda extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion girar a la izquierda
	 * @param categoria
	 */
	public GirarIzquierda(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que ejecuta el menu para girar a la izquerda
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
		Main.dos.writeInt(Main.girarIzquierda.getIdJugada());
		Main.dos.flush();
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Girar a la izquierda";
	}//Cierre del m�todo
}//cierre de la clase
