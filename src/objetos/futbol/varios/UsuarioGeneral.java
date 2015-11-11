package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
/**
 * Clase que define un usuario general
 * @author Santiago Peláez
 *
 */
	/**
	 * Constructor que caracteriza un usuario general
	 * @param nombre
	 * @param clave
	 */
public class UsuarioGeneral implements Usuario{
	//Campos de la clase
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public static Integer[] permisos = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,24,25,27,28,30,31};
	/**
	 * Constructor que asigna un menú, un nombre y una contraseña a un usuario general
	 * @param nombre
	 * @param clave
	 */
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
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
	 * Método que accede a los permisos que tiene un usuario general
	 * @return
	 */
	public Integer[] getPermisos(){
		return permisos;
	}//Cierre del método
	/**
	 * Método que ejecutar la opcion lanzar menú del usuario general
	 */
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}//Cierre del método
	/**
	 * Ejecuta el método asignar menú, que muestra las opciones dependiendo del usuario
	 */	
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.length; i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos[i]-1));
		}
	}//Cierre del método
}//Cierre de la clase
