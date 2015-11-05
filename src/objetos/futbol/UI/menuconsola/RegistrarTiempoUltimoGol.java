package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;

public class RegistrarTiempoUltimoGol extends OpcionDeMenu {

	public RegistrarTiempoUltimoGol(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		System.out.print("--------------------------------------------\n"+this);
		Main.tUltimoGol = System.currentTimeMillis();
	}
	
	@Override
	public String toString(){
		return "Registrar el tiempo del ultimo gol";
	}
}
