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

	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
	
	public void agregarPermisos(){
		//TODO: codigo para agregar los permisos cuando estén definidos
	}
	
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
