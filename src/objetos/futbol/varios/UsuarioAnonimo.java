package objetos.futbol.varios;


import java.util.InputMismatchException;

import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.MenuDeConsola;
/**
 * Clase que define un usuario anonimo
 * @author Santiago Pelaez
 *
 */
public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	/**
	 * Constructor que asigna un menu para un usuario anonimo
	 */
	public UsuarioAnonimo(){
		asignarMenu();
	}//Cierre del constructor
	/**
	 * Metodo que a�ade las opciones de menu a un usuario anonimo
	 */
	public void asignarMenu(){
		menu.limpiar();	
		menu.anadirOpcion(MenuDeConsola.opciones2.get(28));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(30));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(33));
	}//Cierre de la clase
	/**
	 * Metodo que Lanza el menu para un usuario anonimo
	 */
	public void lanzarMenu(){
		String option;
		for(int i = 0; i < menu.opciones.size(); i++){
			if(i == 0){
				System.out.println("Opciones de Sistema\n----------------------------------");
			}
			System.out.println((i+1) +" "+menu.opciones.get(i));
		}
		System.out.println("\n Por favor ingrese el numero de la opcion que desea ejecutar");
		try{
		option = Main.scn.nextLine();
		while(Integer.valueOf(option)<0 || Integer.valueOf(option)> menu.opciones.size()){
			System.out.println("Dato fuera de rango ingrece una opcion valida");
			option = Main.scn.nextLine();
		}
		menu.opciones.get(Integer.valueOf(option)-1).ejecutar();
		}
		catch(NumberFormatException e){
			System.out.println("Error: Dato incorrecto");
		}
		catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto");
		}catch(IndexOutOfBoundsException e){
			System.out.println("Error: Opcion no existente");
		}
	}//Cierre del metodo
}//Cierre de la clase

