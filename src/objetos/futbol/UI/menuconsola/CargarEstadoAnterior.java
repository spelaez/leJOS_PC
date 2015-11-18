package objetos.futbol.UI.menuconsola;

import java.io.File;

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
	}
	
	@Override
	public String toString(){
		return "Cargar partido";
	}

	

}
