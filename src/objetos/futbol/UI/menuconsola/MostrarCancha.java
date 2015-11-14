package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;

public class MostrarCancha extends OpcionDeMenu{

	public MostrarCancha(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		Main.cancha.mostrarCancha();
	}
	
	@Override
	public String toString(){
		return "Mostrar Cancha";
	}
	
}
