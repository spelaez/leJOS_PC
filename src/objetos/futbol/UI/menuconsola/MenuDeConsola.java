package objetos.futbol.UI.menuconsola;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MenuDeConsola {
	private LinkedList<OpcionDeMenu> opciones;
	public static Scanner scn = new Scanner(System.in);
	Comparator<OpcionDeMenu> c = new Comparator<OpcionDeMenu>() {

		@Override
		public int compare(OpcionDeMenu o1, OpcionDeMenu o2) {
			return o1.categoria.compareTo(o2.categoria);
		}
		
	};
	
	public void anadirOpcion(OpcionDeMenu op){
		opciones.add(op);
		ordenarOpciones();
	}
	
	public void ordenarOpciones(){
		opciones.sort(c);
	}
	
	public void lanzarMenu(){
		int option;
		for(int i = 0; i < opciones.size(); i++){
			System.out.println((i+1) +" "+ opciones.get(i));
		}
		System.out.print("\n Por favor ingrese el número de la opción que desea ejecutar");
		try{
		option = scn.nextInt();
		while (option < 0 || option > opciones.size()){
			System.out.println("Dato fuera del rango, Ingrese el dato de nuevo: ");
			option = scn.nextInt();
		}
		}
		catch(NumberFormatException e){
			System.out.println("Error: Dato incorrecto");
		}
		catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto");
		}
	}
}
