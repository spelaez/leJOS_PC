package objetos.futbol.UI.menuconsola;

public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	
	public OpcionDeMenu(String nombre, Categoria categoria){
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getNombre(){
		return nombre;
	}
	public String getCategoria(){
		return categoria.name();
	}
	public abstract void ejecutar();
	public abstract void identificarOpcion();
}
