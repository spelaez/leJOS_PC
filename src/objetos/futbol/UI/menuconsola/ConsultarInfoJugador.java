package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase que define la opción de consultar la información de un jugador
 * @author Santiago Pelaez
 *
 */
public class ConsultarInfoJugador extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion de consutar la informacion de un jugador
	 * @param categoria
	 */
	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opciones de menu que ejecuta el menu para consultar la informacion de un jugador
	 */
	@Override
	public void ejecutar(){
		new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el numero del jugador a consultar");
		String i = "1";
		try{
			String n = Main.scn.nextLine();
			while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadores.size()){
				System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
				n = Main.scn.nextLine();
			}
			Futbolista x = Main.listaJugadores.get(Integer.valueOf(n)-1);
			if( x instanceof Delantero){
				x = (Delantero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */	
	@Override
	public String toString(){
		return "Consultar informacion de un jugador";
	}//Cierre del metodo
}//Cierre de la clase

