package objetos.futbol.UI.menuconsola;

public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	
	public OpcionDeMenu(Categoria categoria){
		this.categoria = categoria;
	}
	public abstract void ejecutar();
}
