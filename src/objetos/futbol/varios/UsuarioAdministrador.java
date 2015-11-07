package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;
/**
 * Clase para definir un usuario administrados
 * @author Santiago Peláez
 *
 */
public class UsuarioAdministrador implements Usuario {
	//Campos de la clase
	private String nombre, clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	/**
	 * constructor para caracterizar un Usuario administrador
	 * @param nombre
	 * @param clave
	 */
	public UsuarioAdministrador(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		asignarMenu();
	}//Cierre del constructor
	/**
	 * Método sobreescrito de la interfaz usuario que permite modificar el nombre del usuario
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}//Cierre del método
	/**
	 * Método sobreescrito de la interfaz usuario que permite modificar la clave del usuario
	 */
	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}//Cierre del método
	/**
	 * Método sobreescrito de la interfaz usuario que permite consultar la clave
	 * @return Retorna el campo clave
	 */
	@Override
	public String getClave() {
		return clave;
	}//Cierre del método
	/**
	 * Método sobreescrito de la interfaz usuario que permite consultar el nombre 
	 * @return Retorna el campo nombre
	 */
	@Override
	public String getNombre() {
		return nombre;
	}//Cierre del método
	/**
	 * Método sobreescrito de la interfaz usuario que permite ejecutar el método lanzar menu
	 */
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();	
	}//Cierre del método
	/**
	 * Ejecuta el método asignar menu, que muestra las opciones dependiendo del usuario
	 */
	public void asignarMenu(){
		menu.limpiar();
		for(int i = 0; i < permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}//Cierre del método
}//Cierre de la clase
