package objetos.futbol.UI.menuconsola;
import java.io.IOException;
import objetos.futbol.UI.Main;
/**
 * Método que define la opcion chutar 
 * @author Juan Pablo Betancur
 *
 */
public class Chutar extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion chutar
	 * @param categoria
	 */
	public Chutar(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
			Main.dos.writeInt(Main.chutar.getIdJugada());
			Main.dos.flush();
		}catch(IOException e){
			System.out.println("No se pudo ejecutar la jugada");
		}
		
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo opcion
	 */
	@Override
	public String toString(){
		return "Chutar";
	}//Cierre del método

}//Cierre de la clase
