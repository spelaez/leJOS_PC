package objetos.futbol.varios;


import java.util.InputMismatchException;

import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.MenuDeConsola;
/**
 * Clase que define un usuario an�nimo
 * @author Santiago Pel�ez
 *
 */
public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	/**
	 * Constructor que asigna un men� para un usuario an�nimo
	 */
	public UsuarioAnonimo(){
		asignarMenu();
	}//Cierre del constructor
	/**
	 * M�todo que a�ade las opciones de men� a un usuario an�nimo
	 */
	public void asignarMenu(){
		menu.limpiar();	
		menu.anadirOpcion(MenuDeConsola.opciones2.get(28));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(30));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(31));
	}//Cierre de la clase
	/**
	 * M�todo que Lanza el men� para un usuario an�nimo
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
	}//Cierre del m�todo
}//Cierre de la clase

