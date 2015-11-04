package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;

public class IniciarPartido extends OpcionDeMenu{
	
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}

	@Override
	public void ejecutar() {
		System.out.print("-----------------------------------------------------------"+this);
		Main.tInicio = System.currentTimeMillis();
		System.out.print("Partido Iniciado\n-----------------------------------------------------------");
	}
	
	@Override
	public String toString(){
		return "Iniciar Partido...";
	}
}
