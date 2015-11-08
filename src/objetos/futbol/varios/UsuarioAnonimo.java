package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.MenuDeConsola;
import objetos.futbol.UI.menuconsola.IniciarSesion;
/**
 * Clase que define un usuario anónimo
 * @author Santiago Peláez
 *
 */
public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	/**
	 * Constructor que asigna un menú para un usuario anónimo
	 */
	public UsuarioAnonimo(){
		asignarMenu();
	}//Cierre del constructor
	/**
	 * Método que añade las opciones de menú a un usuario anónimo
	 */
	public void asignarMenu(){
		menu.limpiar();
		menu.anadirOpcion(new IniciarSesion(Categoria.SISTEMA));
		//menu.anadirOpcion(new RegistrarUsuario(Categoria.SISTEMA));
		//menu.anadirOpcion(new Exit(Categoria.SISTEMA));
	}//Cierre del método
}//Cierre de la clase
