package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;

public class ImprimirJugadores extends OpcionDeMenu {

	public ImprimirJugadores(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		
		for(int i=0; i<Main.listaJugadores.size(); i++){
			System.out.println("\t\t"+Main.listaJugadores.get(i));
		}
		Main.usuarioActual.lanzarMenu();
	}
	
	@Override
	public String toString(){
		return "Lista de jugadores";
	}
}
