package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase qeu define la opcion trotar
 * @author Santiago Peláez
 *
 */
public class Trotar extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion trotar
	 * @param categoria
	 */
	public Trotar(Categoria categoria){
		super(categoria);
	}//Cierre del contructor
	/*
	 * Método sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot(non-Javadoc)
	 * @see objetos.futbol.UI.menuconsola.OpcionDeMenu#ejecutar()
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
		Main.dos.writeInt(Main.trotar.getIdJugada());
		Main.dos.flush();
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Trotar";
	}//Cierre del método
}//Cierre de la clase
