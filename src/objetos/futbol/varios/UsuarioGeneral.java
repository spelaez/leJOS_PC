package objetos.futbol.varios;

import objetos.futbol.UI.menuconsola.MenuDeConsola;

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
	}
}
