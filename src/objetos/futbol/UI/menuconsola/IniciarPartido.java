package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;

public class IniciarPartido extends OpcionDeMenu{
	
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}

	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		Main.tInicio = System.currentTimeMillis();
		Main.tUltimoGol = Main.tInicio;
		System.out.print("Partido Iniciado\n-----------------------------------------------------------");
	}
	
	@Override
	public String toString(){
		return "Iniciar Partido...";
	}
}
