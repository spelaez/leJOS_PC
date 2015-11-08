package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
import java.util.ArrayList;
/**
 * Clase que define un usuario general
 * @author Santiago Pel�ez
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
	 * M�todo que permite modificar el nombre del usuario
	 */
	public void setNombre(String nombre){
		this.nombre = nombre;
	}//Cierre del m�todo
	/**
	 * M�todo que permite modificar la clave de usuario
	 */
	public void setClave(String clave){
		this.clave = clave;
	}//Cierre del m�todo
	/**
	 * M�todo que permite consultar el nombre de usuario
	 * @return Retorna el campo nombre
	 */
	public String getNombre(){
		return nombre;
	}//Cierre del m�todo
	/**
	 * M�todo que permite consultar la clave de un usuario
	 * @return Retorna el campo clave
	 */
	public String getClave(){
		return clave;
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de la interfaz usuario que permite ejecutar el m�todo lanzar menu
	 */
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}//Cierre del m�todo
	/**
	 * M�todo que asigna permisos a un usuario general
	 */
	public void agregarPermisos(){
		//TODO: codigo para agregar los permisos cuando estén definidos
	}//Cierre del m�todo
	/**
	 * Ejecuta el m�todo asignar men�, que muestra las opciones dependiendo del usuario
	 */
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos.get(i)));
		}
	}//Cierre del m�todo
}//Cierre de la clase
