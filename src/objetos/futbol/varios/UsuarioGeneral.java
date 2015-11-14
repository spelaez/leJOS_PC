package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
/**
 * Clase que define un usuario general
 * @author Santiago Pel�ez
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
	public static Integer[] permisos = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,22,23,25,26,28,29,31,32};
	/**
	 * Constructor que asigna un men�, un nombre y una contrase�a a un usuario general
	 * @param nombre
	 * @param clave
	 */
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
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
	 * M�todo que accede a los permisos que tiene un usuario general
	 * @return
	 */
	public Integer[] getPermisos(){
		return permisos;
	}//Cierre del m�todo
	/**
	 * M�todo que ejecutar la opcion lanzar men� del usuario general
	 */
	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}//Cierre del m�todo
	/**
	 * Ejecuta el m�todo asignar men�, que muestra las opciones dependiendo del usuario
	 */	
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.length; i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos[i]-1));
		}
	}//Cierre del m�todo
}//Cierre de la clase
