package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
//Clase que defina la opcion girar a la izquierda
public class GirarIzquierda extends OpcionDeMenu {
	//Método que accesa al tipo de categoria que tiene la opcion girar a la izquierda
	public GirarIzquierda(Categoria categoria){
		super(categoria);
	}
	//Método que ejecuta el menu para girar a la izquerda
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
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Girar a la izquierda";
	}
}
