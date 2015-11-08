package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase que define la opci�n de consultar explicaci�n de una jugada
 * @author Santiago Pel�ez
 *
 */
public class ConsultarExplicacionJugada extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n de consutar la explicaci�n de una jugada
	 * @param categoria
	 */
	public ConsultarExplicacionJugada(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo sobreescrito de opnci�n de men� que ejecuta el men� para consultar la explicaci�n de una jugada
	 */
	@Override
	public void ejecutar(){
		new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		System.out.println("------------------------------------------\nConsultar informacion de un jugador");
		System.out.println("Ingrese el numero del jugador a consultar");
		Scanner scn = new Scanner(System.in);
		int i = 1;
		try{
			int n = scn.nextInt();
			while(n < 0 || n > Main.listaJugadores.size()){
				System.out.print("Dato fuera de rango, por favor ingr�selo de nuevo");
				n = scn.nextInt();
			}
			Futbolista x = Main.listaJugadores.get(n-1);
			if( x instanceof Delantero){
				x = (Delantero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i++;
				}
				System.out.print(this);
				System.out.print("Ingrese el n�mero de la jugada para imprimir su explicaci�n");
				try{
				n = scn.nextInt();
				while(n < 0 || n > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingr�selo de nuevo");
					n = scn.nextInt();
				}
				System.out.print(x.getListaJugadas().get(n-1).getExplicacion());
				}
				catch(NumberFormatException e){
					System.out.println("Dato incorrecto, ingrese un entero");
				}
				catch(InputMismatchException e){
					System.out.println("Error: dato incorrecto");
				}
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i++;
				}
				System.out.print(this);
				System.out.print("Ingrese el n�mero de la jugada para imprimir su explicaci�n");
				try{
				n = scn.nextInt();
				while(n < 0 || n > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingr�selo de nuevo");
					n = scn.nextInt();
				}
				System.out.print(x.getListaJugadas().get(n-1).getExplicacion());
				}
				catch(NumberFormatException e){
					System.out.println("Dato incorrecto, ingrese un entero");
				}
				catch(InputMismatchException e){
					System.out.println("Error: dato incorrecto");
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}
	
		scn.close();
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Consultar Explicaci�n de una jugada";
	}//Cierre del m�todo
}//Cierre de la clase