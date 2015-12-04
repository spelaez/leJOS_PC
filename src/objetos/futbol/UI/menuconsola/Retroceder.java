package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Clase que define la opcion retroceder
 * @author Juan Pablo Betancur
 *
 */
@SuppressWarnings("serial")
public class Retroceder extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion retroceder
	 * @param categoria
	 */
	public Retroceder(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un metodo de la clase main del paquete objetos.futbol.UI para enviarla al robot
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa==false){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			try{
				if(categoria == Categoria.ARQUERO){
					Main.dos1.writeInt(Main.retroceder.getIdJugada());
					Main.dos1.flush();
					Main.dis1.readInt();
					Main.dis1.readInt();
					Main.cancha.actualizarPosicion(Main.dis1.readInt(), Main.dis1.readInt(), Main.r1);
				}
				else if(categoria == Categoria.DELANTERO){
					Main.dos2.writeInt(Main.retroceder.getIdJugada());
					Main.dos2.flush();
					Main.dis2.readInt();
					Main.dis2.readInt();
					Main.cancha.actualizarPosicion(Main.dis2.readInt(), Main.dis2.readInt(), Main.r2);
				}
				
			}
			catch(IOException e){
				System.out.print("No se pudo ejecutar la jugada");
			}
		}
		else if(Main.pausa == true){
			System.out.println("Porfavor reanude el prtido dando la opcion Reanudar partido");
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retrona el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Retroceder";
	}//Cierre del metodo
}//Cierre de la clase
