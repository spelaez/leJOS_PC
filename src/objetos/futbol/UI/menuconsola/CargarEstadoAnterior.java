package objetos.futbol.UI.menuconsola;

import java.io.File;

import objetos.futbol.UI.Main;

public  class CargarEstadoAnterior extends OpcionDeMenu {

	public CargarEstadoAnterior(Categoria categoria) {
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
		System.out.println("Partido reanudado");
		Main.pausa = false;
		Main.tInicio = System.currentTimeMillis();
	}
	
	@Override
	public String toString(){
		return "Reanudar partido";
	}

	

}
