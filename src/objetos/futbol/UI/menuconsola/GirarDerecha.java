package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;
//Clase para definir la opcion girar a la derecha
public class GirarDerecha extends OpcionDeMenu{
	//M�todo que accesa al tipo de categoria que tiene la opcion girar a la derecha
	public GirarDerecha(Categoria categoria){
		super(categoria);
	}
	//M�todo que ejecuta el menu para girar a la derecha
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
		Main.dos.writeInt(Main.girarDerecha.getIdJugada());
		Main.dos.flush();
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}
	//M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Girar a la derecha";
	}
}
