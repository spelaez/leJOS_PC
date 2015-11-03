package objetos.futbol.UI.menuconsola;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import objetos.futbol.UI.menuconsola.Trotar;

public class MenuDeConsola {
	public static ArrayList<OpcionDeMenu> opciones2 = new ArrayList<>();
	public ArrayList<OpcionDeMenu> opciones;
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
	
	public void eliminarOpcion(OpcionDeMenu op){
		opciones.remove(op);
	}
	
	public void limpiar(){
		opciones = new ArrayList<OpcionDeMenu>();
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

	private void cargarOpciones(){
		if(opciones2.size() == 0){
			opciones2.add(new Trotar(Categoria.ARQUERO));
			opciones2.add(new Correr(Categoria.ARQUERO));
			opciones2.add(new Chutar(Categoria.ARQUERO));
			opciones2.add(new Patear(Categoria.ARQUERO));
			opciones2.add(new GirarDerecha(Categoria.ARQUERO));
			opciones2.add(new GirarIzquierda(Categoria.ARQUERO));
			opciones2.add(new Retroceder(Categoria.ARQUERO));
			opciones2.add(new Trotar(Categoria.DELANTERO));
			opciones2.add(new Correr(Categoria.DELANTERO));
			opciones2.add(new Chutar(Categoria.DELANTERO));
			opciones2.add(new Patear(Categoria.DELANTERO));
			opciones2.add(new GirarDerecha(Categoria.DELANTERO));
			opciones2.add(new GirarIzquierda(Categoria.DELANTERO));
			opciones2.add(new Retroceder(Categoria.DELANTERO));
		}
		
	}
}
