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
	//Método que caracteriza un usuario general
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
		agregarPermisos();
		asignarMenu();
	}
	//Método que permite modificar el nombre del usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	//Método que permite modificar la clave de usuario
	public void setClave(String clave){
		this.clave = clave;
	}
	//Método que permite consultar el nombre de usuario
	public String getNombre(){
		return nombre;
	}
	//Método que permite consultar la clave de un usuario
	public String getClave(){
		return clave;
	}
	//Método sobreescrito de la interfaz usuario que permite ejecutar el método lanzar menu
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
	//Método que asigna permisos a un usuario general
	public void agregarPermisos(){
		//TODO: codigo para agregar los permisos cuando estÃ©n definidos
	}
	//Ejecuta el método asignar menu, que muestra las opciones dependiendo del usuario
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
