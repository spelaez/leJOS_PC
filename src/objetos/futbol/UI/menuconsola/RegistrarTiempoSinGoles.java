package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;

public class RegistrarTiempoSinGoles extends OpcionDeMenu  {

	public RegistrarTiempoSinGoles(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("--------------------------------------------\n"+this);
		if(Main.r1.getJugador() instanceof Arquero){
			((Arquero)(Main.r1.getJugador())).registrarTiempoGol((int)(System.currentTimeMillis()- Main.tUltimoGol)/1000);
		}
		else if(Main.r2.getJugador() instanceof Arquero){
			((Arquero)(Main.r2.getJugador())).registrarTiempoGol((int)(System.currentTimeMillis()- Main.tUltimoGol)/1000);
		}
		else{
			System.out.println("Error: No hay Arquero en el equipo");
		}
		Main.usuarioActual.lanzarMenu();
	}
	
	@Override
	public String toString(){
		return "Registrar tiempo sin goles";
	}
	
}
