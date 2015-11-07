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
		Main.dos.flush();
		if(categoria == Categoria.ARQUERO){
			  Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r1);
			}
			else if(categoria == Categoria.DELANTERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r2);
			}
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
