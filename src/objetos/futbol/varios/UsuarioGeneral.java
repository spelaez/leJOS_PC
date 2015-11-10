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

public class UsuarioGeneral implements Usuario
{
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public static Integer[] permisos = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,24,25,27,28,30,31};
	
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
	/**
	 * Ejecuta el m�todo asignar men�, que muestra las opciones dependiendo del usuario
	 */
	}
	
	public Integer[] getPermisos(){
		return permisos;
	}

	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
	
	
	public void asignarMenu(){
		menu.limpiar();
		for(int i=0; i<permisos.length; i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(permisos[i]-1));
		}
	}//Cierre del m�todo
}//Cierre de la clase
