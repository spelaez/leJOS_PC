package objetos.futbol.varios;


import objetos.futbol.UI.menuconsola.MenuDeConsola;

public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	
	public UsuarioAnonimo(){
		asignarMenu();
	}
	
	public void asignarMenu(){
		menu.limpiar();
		menu.anadirOpcion(MenuDeConsola.opciones2.get(28));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(30));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(31));
		menu.lanzarMenu();
	}
}
