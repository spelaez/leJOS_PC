package objetos.futbol.UI.menuconsola;
//Clase abastracta que lista las opciones de menu por categorias
public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	//M�todo que modifica la categoria
	public OpcionDeMenu(Categoria categoria){
		this.categoria = categoria;
	}
	//M�todo que se ejecuta para imprimi un saludo
	public static void bienvenida(){
		System.out.print("\n\n\n\n\n-------------------------------------------------------\n\t\t\tBIENVENIDO");
	}
	//M�todo abastracto que sera implementado en otras clases
	public abstract void ejecutar();
}
