package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
//Clase que define la opcion  que registra el tiempo del ultimo gol
public class RegistrarTiempoUltimoGol extends OpcionDeMenu {
	//Método que accesa al tipo de categoria que tiene la opcion registrar tiempo del ultimo gol
	public RegistrarTiempoUltimoGol(Categoria categoria){
		super(categoria);
	}
	//Método que se ejecuta para mostrar el tiempo del ultimo gol
	@Override
	public void ejecutar(){
		System.out.print("--------------------------------------------\n"+this);
		Main.tUltimoGol = System.currentTimeMillis();
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Registrar el tiempo del ultimo gol";
	}
}
