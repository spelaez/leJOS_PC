package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase que define la opción de consultar la información de un jugador
 * @author Santiago Peláez
 *
 */
public class ConsultarInfoJugador extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción de consutar la información de un jugador
	 * @param categoria
	 */
	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método sobreescrito de opciones de menu que ejecuta el menú para consultar la infromación de un jugador
	 */
	@Override
	public void ejecutar(){
		new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el numero del jugador a consultar");
		int i = 1;
		try{
			int n = Main.scn.nextInt();
			while(n < 0 || n > Main.listaJugadores.size()){
				System.out.print("Dato fuera de rango, por favor ingrï¿½selo de nuevo");
				n = Main.scn.nextInt();
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
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */	
	@Override
	public String toString(){
		return "Consultar informacion de un jugador";
	}//Cierre del método
}//Cierre de la clase

