package objetos.futbol.varios;


import java.util.InputMismatchException;

import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.MenuDeConsola;

public class UsuarioAnonimo {
	public MenuDeConsola menu = new MenuDeConsola();
	
	public UsuarioAnonimo(){
		asignarMenu();
	}
	
	public void asignarMenu(){
		menu.limpiar();
		menu.anadirOpcion(MenuDeConsola.opciones2.get(27));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(29));
		menu.anadirOpcion(MenuDeConsola.opciones2.get(30));
	}
	
	public void lanzarMenu(){
		int option;
		for(int i = 0; i < menu.opciones.size(); i++){
			if(i == 0){
				System.out.println("Opciones de Sistema\n----------------------------------");
			}
			System.out.println((i+1) +" "+menu.opciones.get(i));
		}
		System.out.println("\n Por favor ingrese el numero de la opcion que desea ejecutar");
		try{
		option = Main.scn.nextInt();
		while (option < 0 || option > menu.opciones.size()){
			System.out.println("Dato fuera del rango, Ingrese el dato de nuevo: ");
			option = Main.scn.nextInt();
		}
		menu.opciones.get(option-1).ejecutar();
		}
		catch(NumberFormatException e){
			System.out.println("Error: Dato incorrecto");
		}
		catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto");
		}
	}
}
