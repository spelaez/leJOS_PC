package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Clase que define la opcion girar a la izquierda
 * @author Juan Pablo Betancur
 *
 */
@SuppressWarnings("serial")
public class GirarIzquierda extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion girar a la izquierda
	 * @param categoria
	 */
	public GirarIzquierda(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu para girar a la izquerda
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa == false){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			try{
				if(categoria == Categoria.ARQUERO){
					Main.dos1.writeInt(Main.girarIzquierda.getIdJugada());
					Main.dos1.flush();
					Main.dis1.readInt();
					Main.dis1.readInt();
				}
				else if(categoria == Categoria.DELANTERO){
					Main.dos2.writeInt(Main.girarIzquierda.getIdJugada());
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
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Girar a la izquierda";
	}//Cierre del metodo
}//cierre de la clase
