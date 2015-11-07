package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;
//Clase que define un usuario general
public class UsuarioGeneral implements Usuario
{
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	//M�todo que caracteriza un usuario general
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
		agregarPermisos();
		asignarMenu();
	}
	//M�todo que permite modificar el nombre del usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	//M�todo que permite modificar la clave de usuario
	public void setClave(String clave){
		this.clave = clave;
	}
	//M�todo que permite consultar el nombre de usuario
	public String getNombre(){
		return nombre;
	}
	//M�todo que permite consultar la clave de un usuario
	public String getClave(){
		return clave;
	}
	//M�todo sobreescrito de la interfaz usuario que permite ejecutar el m�todo lanzar menu
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
	//M�todo que asigna permisos a un usuario general
	public void agregarPermisos(){
		//TODO: codigo para agregar los permisos cuando estén definidos
	}
	//Ejecuta el m�todo asignar menu, que muestra las opciones dependiendo del usuario
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
