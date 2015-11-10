package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;

public class UsuarioAdministrador implements Usuario {

	private String nombre, clave;
	public MenuDeConsola menu = new MenuDeConsola();
	//No creamos array de permisos en administrador, porque los tiene todos
	
	public UsuarioAdministrador(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		asignarMenu();
	}


	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String getClave() {
		return clave;
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();	
	}
	
	public void asignarMenu(){
		menu.limpiar();
		for(int i = 0; i < MenuDeConsola.opciones2.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(i));
		}
	}
}

