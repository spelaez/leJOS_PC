package objetos.futbol.UI.menuconsola;
/**
 * Clase abastracta que lista las opciones de menu por categorias
 * @author Santiago Pel�ez
 *
 */
public abstract class OpcionDeMenu{
	//Campos de clase
	String nombre;
	Categoria categoria;
	/**
	 * Constructor que modifica la categoria
	 * @param categoria
	 */
	public OpcionDeMenu(Categoria categoria){
		this.categoria = categoria;
	}//Cierre del construtor
	/**
	 * M�todo que se ejecuta para imprimi un saludo
	 */
	public static void bienvenida(){
		System.out.print("\n\n\n\n\n-------------------------------------------------------\n\t\t\tBIENVENIDO");
	}//Cierre del m�todo
	/**
	 * M�todo abastracto que sera implementado en otras clases
	 */
	public abstract void ejecutar();
}//Cierre de la clase
