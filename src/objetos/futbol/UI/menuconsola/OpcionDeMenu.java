package objetos.futbol.UI.menuconsola;

public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	
	public OpcionDeMenu(String nombre, Categoria categoria){
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public static void bienvenida(){
		System.out.print("\n\n\n\n\n-------------------------------------------------------\n\t\t\tBIENVENIDO");
	}
	
	public abstract void ejecutar();
}
