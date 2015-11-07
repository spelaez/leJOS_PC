package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.MenuDeConsola;
import objetos.futbol.UI.menuconsola.IniciarSesion;
/**
 * Clase que define un usuario anonimo
 * @author Santiago Pel�ez
 *
 */
public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	/**
	 * Constructor que asigna un menu para un usuario anonimo
	 */
	public UsuarioAnonimo(){
		asignarMenu();
	}//Cierre del constructor
	/**
	 * M�todo que a�ade las opciones de menu a un usuario anonimo
	 */
	public void asignarMenu(){
		menu.limpiar();
		menu.anadirOpcion(new IniciarSesion(Categoria.SISTEMA));
		//menu.anadirOpcion(new RegistrarUsuario(Categoria.SISTEMA));
		//menu.anadirOpcion(new Exit(Categoria.SISTEMA));
	}//Cierre del m�todo
}//Cierre de la clase
