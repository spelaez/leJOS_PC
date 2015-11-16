package objetos.futbol.UI.menuconsola;

import java.io.File;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.GestorBDEstado;

public class FinalizarPartido extends OpcionDeMenu {

	public FinalizarPartido(Categoria categoria) {
		super(categoria);
		
	}

	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		File fichero = new File("src\\gestorBD\\Estado.xml");
		if(!fichero.exists()){
			System.out.println("Porfavor inicie un partido antes");
			return;
		}
		// GestorBDEstado().guardarEstado();
		Main.gestorEstado.leerEstado();
	}
	
	@Override
	public String toString(){
		return "Finalizar Partido";
	}

	
}
