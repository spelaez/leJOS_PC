package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Delantero;
//Clase que define la opcion registrar gol a favor
public class RegistrarGolAFavor extends OpcionDeMenu{
	//Método que accesa al tipo de categoria que tiene la opcion registrar gol a favor
	public RegistrarGolAFavor(Categoria categoria){
		super(categoria);
	}
	//Método que se ejecutar para registrar goles marcados por un delantero
	@Override
	public void ejecutar(){
		System.out.print("--------------------------------------------\n"+this);
		if(Main.r1.getJugador() instanceof Delantero){
			((Delantero)(Main.r1.getJugador())).registrarGol();;
		}
		else if(Main.r2.getJugador() instanceof Delantero){
			((Delantero)(Main.r2.getJugador())).registrarGol();
		}
		else System.out.print("Error: No hay delanteros en el equipo");
		}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Registrar gol a favor";
	}
	}

