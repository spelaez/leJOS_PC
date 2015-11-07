package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;

public class UsuarioGeneral implements Usuario
{
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
		agregarPermisos();
		//asignarMenu();
	}
	
	public UsuarioGeneral(String nombre, String clave, ArrayList<Integer> p) {
		this.nombre = nombre;
		this.clave = clave;
		this.permisos = p;
		//asignarMenu();
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setClave(String clave){
		this.clave = clave;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getClave(){
		return clave;
	}
	
	public ArrayList<Integer> getPermisos(){
		return permisos;
	}

	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
	
	public void agregarPermisos(){
		permisos.add(1);
	}
	
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
