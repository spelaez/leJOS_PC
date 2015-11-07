package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.MenuDeConsola;
import objetos.futbol.UI.menuconsola.IniciarSesion;
//Clase que define un usuario anonimo
public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	//Método que asigna un menu para un usuario anonimo
	public UsuarioAnonimo(){
		asignarMenu();
	}
	//Método que añade las opciones de menu a un usuario anonimo
	public void asignarMenu(){
		menu.limpiar();
		menu.anadirOpcion(new IniciarSesion(Categoria.SISTEMA));
		//menu.anadirOpcion(new RegistrarUsuario(Categoria.SISTEMA));
		//menu.anadirOpcion(new Exit(Categoria.SISTEMA));
	}
}
