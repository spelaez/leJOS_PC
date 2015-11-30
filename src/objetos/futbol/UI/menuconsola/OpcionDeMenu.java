package objetos.futbol.UI.menuconsola;

import javax.swing.JMenuItem;

/**
 * Clase abastracta que lista las opciones de men� por categorias
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public abstract class OpcionDeMenu extends JMenuItem{
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
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}//Cierre de la clase
