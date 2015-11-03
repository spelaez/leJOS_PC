package objetos.futbol.UI.menuconsola;

public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	
	public OpcionDeMenu(String nombre, Categoria categoria){
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	public abstract void ejecutar();
}
