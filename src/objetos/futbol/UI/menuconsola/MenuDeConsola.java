package objetos.futbol.UI.menuconsola;

import java.util.LinkedList;
import java.util.Scanner;

public class MenuDeConsola {
	private LinkedList<OpcionDeMenu> opciones;
	public static Scanner scn = new Scanner(System.in);
	
	public void anadirOpcion(OpcionDeMenu op){
		opciones.add(op);
		ordenarOpciones();
	}
	
	public void ordenarOpciones(){
		opciones.sort(Clasificable.c);
	}
	
	public void lanzarMenu(){
		int option;
		System.out.println("MENU");
		for(int i = 0; i < opciones.size(); i++){
			System.out.println((i+1) +" "+ opciones.get(i).getNombre());
		}
		System.out.print("0 Salir \n Por favor ingrese el número de la opción que desea ejecutar");
		option = scn.nextInt();
		if (option > 0){
			opciones.get(option-1).ejecutar();
			lanzarMenu();
		}
		else if (option == 0) System.exit(0);  //falta implementar el metodo para guardar el estado del sistema y salir
	}
}
