package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Clase para definir la opcion correr
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public class Correr extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion correr
	 * @param categoria
	 */
	public Correr(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un metodo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa == false){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			try{
				if(categoria == Categoria.ARQUERO){
					Main.dos1.writeInt(Main.correr.getIdJugada());
					Main.dos1.flush();
					Main.dis1.readInt();
					Main.dis1.readInt();
					Main.cancha.actualizarPosicion(Main.dis1.readInt(), Main.dis1.readInt(), Main.r1);
				}
				else if(categoria == Categoria.DELANTERO){
					Main.dos2.writeInt(Main.correr.getIdJugada());
					Main.dos2.flush();
					Main.dis2.readInt();
					Main.dis2.readInt();
					Main.cancha.actualizarPosicion(Main.dis2.readInt(), Main.dis2.readInt(), Main.r2);
				}
				

			}catch(IOException e){
				System.out.println("No se pudo ejecutar la jugada");
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
		return "Correr";
	}//Cierre del metodo	
}//Cierre de la clase

