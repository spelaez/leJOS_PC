package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
/**
 * Clase que define la opcion de consultar explicacion de una jugada
 * @author Santiago Pelaez
 *
 */
public class ConsultarExplicacionJugada extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción de consutar la explicacion de una jugada
	 * @param categoria
	 */
	public ConsultarExplicacionJugada(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opncion de menu que ejecuta el menu para consultar la explicacion de una jugada
	 */
	@Override
	public void ejecutar(){}
		/*new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.println("------------------------------------------\nConsultar informacion de un jugador");
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
				System.out.print(this);
				System.out.print("Ingrese el numero de la jugada para imprimir su explicacion");
				try{
				n = Main.scn.nextLine();
				while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
					n = Main.scn.nextLine();
				}
				System.out.print(x.getListaJugadas().get(Integer.valueOf(n)-1).getExplicacion());
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
					i=String.valueOf((Integer.valueOf(i)+1));
				}
				System.out.print(this);
				System.out.print("Ingrese el numero de la jugada para imprimir su explicacion");
				try{
				n = Main.scn.nextLine();
				while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
					n = Main.scn.nextLine();
				}
				System.out.print(x.getListaJugadas().get(Integer.valueOf(n)-1).getExplicacion());
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
	}//Cierre del método
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */	
	@Override
	public String toString(){
		return "Consultar Explicacion de una jugada";
	}//Cierre del metodo
}//Cierre de la clase

