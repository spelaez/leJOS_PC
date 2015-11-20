package objetos.futbol.UI.menuconsola;
/**
 * Clase abastracta que lista las opciones de men� por categorias
 * @author Santiago Pelaez
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
		this.categoria = categoria;//Cierre del m�todo
	/**
	 * Metodo abastracto que sera implementado en otras clases
	 */
	}
	public abstract void ejecutar();
}//Cierre de la clase
