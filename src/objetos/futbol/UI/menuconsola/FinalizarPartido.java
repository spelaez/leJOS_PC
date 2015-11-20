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
		File fichero = new File("src\\gestorBD\\Buffer.txt");
		if(!fichero.exists()){
			System.out.println("Porfavor inicie un partido antes");
			return;
		}
		Main.gestorEstado.guardarEstado();
		Main.gestorEstado.leerEstado();
		Main.pausa = false;
	}
	
	@Override
	public String toString(){
		return "Finalizar Partido";
	}

	
}
