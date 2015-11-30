package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;
/**
 * Clase para definir un usuario administrador
 * @author Santiago Pelaez
 *
 */
public class UsuarioAdministrador implements Usuario {
	//Campos de la clase
	private String nombre, clave;
	public MenuDeConsola menu = new MenuDeConsola();
	/**
	 * constructor para caracterizar un Usuario administrador
	 * @param nombre
	 * @param clave
	 */
	//No creamos array de permisos en administrador, porque los tiene todos
	public UsuarioAdministrador(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		asignarMenu();
	//Cierre del constructor
	/**
	 * Metodo sobreescrito de la interfaz usuario que permite modificar el nombre del usuario
	 */}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;		
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de la interfaz usuario que permite modificar la clave del usuario
	 */
	@Override
	public void setClave(String clave) {
		this.clave = clave;
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de la interfaz usuario que permite consultar la clave
	 * @return Retorna el campo clave
	 */
	@Override
	public String getClave() {
		return clave;
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de la interfaz usuario que permite consultar el nombre 
	 * @return Retorna el campo nombre
	 */
	@Override
	public String getNombre() {
		return nombre;
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de la interfaz usuario que permite ejecutar el metodo lanzar menu
	 *///Cierre del metodo
	/**
	 * Ejecuta el metodo asignar menu, que muestra las opciones dependiendo del usuario
	 */
	public void asignarMenu(){
		menu.limpiar();
		for(int i = 0; i < MenuDeConsola.opciones2.size(); i++){
			menu.anadirOpcion(MenuDeConsola.opciones2.get(i));
		}
		menu.cargarItems();
	}//Cierre del metodo
	@Override
	public MenuDeConsola getMenu() {
		return this.menu;
	}
}//Cierre de la clase

