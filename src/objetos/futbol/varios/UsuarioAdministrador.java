package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;

public class UsuarioAdministrador implements Usuario {

	private String nombre, clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	
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
		for(int i = 0; i < permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
