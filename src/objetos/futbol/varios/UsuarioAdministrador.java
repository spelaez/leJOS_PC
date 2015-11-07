package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;
//Clase para definir un usuario administrados
public class UsuarioAdministrador implements Usuario {
	
	private String nombre, clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	//Método para caracterizar un Usuario administrador
	public UsuarioAdministrador(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		asignarMenu();
	}
	//Método sobreescrito de la interfaz usuario que permite modificar el nombre del usuario
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	//Método sobreescrito de la interfaz usuario que permite modificar la clave del usuario
	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}
	//Método sobreescrito de la interfaz usuario que permite consultar la clave
	@Override
	public String getClave() {
		return clave;
	}
	//Método sobreescrito de la interfaz usuario que permite consultar el nombre 
	@Override
	public String getNombre() {
		return nombre;
	}
	//Método sobreescrito de la interfaz usuario que permite ejecutar el método lanzar menu
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();	
	}
	//Ejecuta el método asignar menu, que muestra las opciones dependiendo del usuario
	public void asignarMenu(){
		menu.limpiar();
		for(int i = 0; i < permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}
}
