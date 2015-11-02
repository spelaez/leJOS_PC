package objetos.futbol.UI.menuconsola;

public abstract class OpcionDeMenu {
	String nombre;
	String categoria; //Opcion de Arquero ,de Delantero o de Sistema
	
	public String getNombre(){
		return nombre;
	}
	public String getCategoria(){
		return categoria;
	}
	
	public abstract void ejecutar();
	public abstract void identificarOpcion();
}
