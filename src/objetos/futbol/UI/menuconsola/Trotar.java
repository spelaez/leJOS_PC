package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
//Clase qeu define la opcion trotar
public class Trotar extends OpcionDeMenu{
	//Método que accesa al tipo de categoria que tiene la opcion trotar
	public Trotar(Categoria categoria){
		super(categoria);
	}
	//Método sobreescrito de opcion de menu, que imprime el tipo de opcion, y llama a un método de la clase main del paquete objetos.futbol.UI para enviarla al robot
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
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Trotar";
	}
}
