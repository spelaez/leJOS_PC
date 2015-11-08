package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase que define la opci�n de consultar la informaci�n de un jugador
 * @author Santiago Pel�ez
 *
 */
public class ConsultarInfoJugador extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n de consutar la informaci�n de un jugador
	 * @param categoria
	 */
	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo sobreescrito de opciones de menu que ejecuta el men� para consultar la infromaci�n de un jugador
	 */
	@Override
	public void ejecutar(){
		new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		System.out.println("------------------------------------------\n"+this);
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
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i++;
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
		return "Consultar informaci�n de un jugador";
	}//Cierre del m�todo
}//Cierre de la clase
