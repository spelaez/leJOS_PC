package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;
/**
 * Clase que define un usuario general
 * @author Santiago Peláez
 *
 */
public class UsuarioGeneral implements Usuario{
	//Campos de clase
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public ArrayList<Integer> permisos = new ArrayList<>();
	/**
	 * Constructor que caracteriza un usuario general
	 * @param nombre
	 * @param clave
	 */
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
		agregarPermisos();
		asignarMenu();
	}//Cierre del constructor
	/**
	 * Método que permite modificar el nombre del usuario
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}//Cierre del método
	/**
	 * Método que permite modificar la clave de usuario
	 */
	public void setClave(String clave){
		this.clave = clave;
	}//Cierre del método
	/**
	 * Método que permite consultar el nombre de usuario
	 * @return Retorna el campo nombre
	 */
	public String getNombre(){
		return nombre;
	}//Cierre del método
	/**
	 * Método que permite consultar la clave de un usuario
	 * @return Retorna el campo clave
	 */
	public String getClave(){
		return clave;
	}//Cierre del método
	/**
	 * Método sobreescrito de la interfaz usuario que permite ejecutar el método lanzar menu
	 */
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}//Cierre del método
	/**
	 * Método que asigna permisos a un usuario general
	 */
	public void agregarPermisos(){
		//TODO: codigo para agregar los permisos cuando estÃ©n definidos
	}//Cierre del método
	/**
	 * Ejecuta el método asignar menú, que muestra las opciones dependiendo del usuario
	 */
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}//Cierre del método
}//Cierre de la clase
