package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 * Clase para ejecutar la opción de menú
 * @author Jhon Eider Murillo, Santiago Pélaez
 *
 */
public class EjecutarJugadaCompleja extends OpcionDeMenu{
	/**
	 * Constructor de la clase que devuelve de la categoria opción
	 * @param categoria
	 */
	public EjecutarJugadaCompleja(Categoria categoria){
		super(categoria);
	}//Cierre del contructor
	/**
	 * Método que ejecuta el menú para ejecurtar una jugada compleja
	 */
	public void ejecutar(){
		if(categoria == Categoria.ARQUERO){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r1.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				int ind = Main.scn.nextInt();
				while(ind < 1 || ind > 3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = Main.scn.nextInt();
				}
				Main.r1.ejecutarJugadaCompleja(ind-1);
			}catch(NumberFormatException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(InputMismatchException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(IOException e){
				System.out.println("No existe jugada");
			}
		}
		
		else if(categoria == Categoria.DELANTERO){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r2.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				int ind = Main.scn.nextInt();
				while(ind < 1 || ind > 3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = Main.scn.nextInt();
				}
				Main.r1.ejecutarJugadaCompleja(ind-1);
			}catch(NumberFormatException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(InputMismatchException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(IOException e){
				System.out.println("No existe jugada");
			}
		}
	}//Cierre del método
	/**
	 *  Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 *  @return Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Jugadas Complejas";
	}//Cierre del método	
}//Cierre de la clase
