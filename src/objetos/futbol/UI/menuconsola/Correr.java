package objetos.futbol.UI.menuconsola;

import java.io.IOException;
import objetos.futbol.UI.Main;
public class Correr extends OpcionDeMenu {
	public Correr(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
			Main.dos.writeInt(Main.correr.getIdJugada());
			Main.dos.flush();
			
		}catch(IOException e){
			System.out.println("No se pudo ejecutar la jugada");
		}
		Main.usuarioActual.lanzarMenu();
	}
	@Override
	public String toString(){
		return "Correr";
	}
	
}

