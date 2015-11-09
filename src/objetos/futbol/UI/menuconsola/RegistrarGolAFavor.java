package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Delantero;

public class RegistrarGolAFavor extends OpcionDeMenu{

	public RegistrarGolAFavor(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		if(Main.r1.getJugador() instanceof Delantero){
			((Delantero)(Main.r1.getJugador())).registrarGol();;
		}
		else if(Main.r2.getJugador() instanceof Delantero){
			((Delantero)(Main.r2.getJugador())).registrarGol();
		}
		else System.out.print("Error: No hay delanteros en el equipo");
		}
	
	@Override
	public String toString(){
		return "Registrar gol a favor";
	}
	}

