package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
/**
 * Clase que define la opción trotar
 * @author Santiago Peláez
 *
 */
public class Trotar extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción trotar
	 * @param categoria
	 */
	public Trotar(Categoria categoria){
		super(categoria);
	}//Cierre del contructor
	/*
	 * Método sobreescrito de opción de menú, que imprime el tipo de opción, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot
	 * @see objetos.futbol.UI.menuconsola.OpcionDeMenu#ejecutar()
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		try{
		Main.dos.writeInt(Main.trotar.getIdJugada());
		Main.dos.flush();
		if(categoria == Categoria.ARQUERO){
			  Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r1);
			}
			else if(categoria == Categoria.DELANTERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r2);
			}
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Trotar";
	}//Cierre del método
}//Cierre de la clase
