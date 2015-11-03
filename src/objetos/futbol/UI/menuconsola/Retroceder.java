package objetos.futbol.UI.menuconsola;

import java.io.IOException;

import objetos.futbol.UI.Main;

public class Retroceder extends OpcionDeMenu{

	public Retroceder(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		try{
		Main.dos.writeInt(Main.retroceder.getIdJugada());
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}
	
	@Override
	public String toString(){
		return "Retroceder";
	}
}
