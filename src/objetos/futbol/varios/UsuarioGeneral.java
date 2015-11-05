package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;

public class UsuarioGeneral implements Usuario
{
	private String nombre;
	private String clave;
	public MenuDeConsola menu = new MenuDeConsola();
	public UsuarioGeneral(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setClave(String clave){
		this.clave = clave;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getClave(){
		return clave;
	}

	@Override
	public void lanzarMenu() {
		menu.lanzarMenu();
	}
}
