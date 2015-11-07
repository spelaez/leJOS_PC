package objetos.futbol.UI.menuconsola;
//Clase abastracta que lista las opciones de menu por categorias
public abstract class OpcionDeMenu{
	String nombre;
	Categoria categoria;
	//Método que modifica la categoria
	public OpcionDeMenu(Categoria categoria){
		this.categoria = categoria;
	}
	//Método que se ejecuta para imprimi un saludo
	public static void bienvenida(){
		System.out.print("\n\n\n\n\n-------------------------------------------------------\n\t\t\tBIENVENIDO");
	}
	//Método abastracto que sera implementado en otras clases
	public abstract void ejecutar();
}
