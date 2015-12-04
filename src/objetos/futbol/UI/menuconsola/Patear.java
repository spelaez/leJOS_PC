package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Clase para definir la opcion patear
 * @author Juan Pablo Betancur
 *
 */
@SuppressWarnings("serial")
public class Patear extends OpcionDeMenu{
	/**
	 * constructor para define patear dependeiendo la categoria
	 * @param categoria
	 */
	public Patear(Categoria categoria){
		super(categoria);
	}//Cierre del cosntructor
	/**
	 * Metodo sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un metodo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa==false){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			try{
				if(categoria == Categoria.ARQUERO){
					
					Main.dos1.writeInt(Main.patear.getIdJugada());
					Main.dos1.flush();
					Main.dis1.readInt();
					Main.dis1.readInt();
				}
				else if(categoria == Categoria.DELANTERO){
					Main.dos2.writeInt(Main.patear.getIdJugada());
					Main.dos2.flush();
					Main.dis2.readInt();
					Main.dis2.readInt();
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
	 * Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Patear";
	}//Cierre del metodo
}//Cierre de la clase
