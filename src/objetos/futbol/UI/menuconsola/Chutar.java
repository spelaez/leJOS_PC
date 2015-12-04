package objetos.futbol.UI.menuconsola;
import java.io.IOException;
import objetos.futbol.UI.Main;

/**
 * Metodo que define la opcion chutar 
 * @author Juan Pablo Betancur
 *
 */
@SuppressWarnings("serial")
public class Chutar extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion chutar
	 * @param categoria
	 */
	public Chutar(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un metodo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa == false){
			try{
				if(categoria == Categoria.ARQUERO){
					
					Main.dos1.writeInt(Main.chutar.getIdJugada());
					Main.dos1.flush();
					Main.dis1.readInt();
					Main.dis1.readInt();
				}
				else if(categoria == Categoria.DELANTERO){
					Main.dos2.writeInt(Main.chutar.getIdJugada());
					Main.dos2.flush();
					Main.dis2.readInt();
					Main.dis2.readInt();
				}

				//Hacemos caso omiso de los datos mandados por el robot ya que al chutar la posicion no se actualiza

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
	 * @return Retorna el tipo opcion
	 */
	@Override
	public String toString(){
		return "Chutar";
	}//Cierre del metodo
}//Cierre de la clase
