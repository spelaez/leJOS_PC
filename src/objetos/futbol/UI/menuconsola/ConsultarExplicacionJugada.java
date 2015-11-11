package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
/**
 * Clase que define la opción de consultar explicación de una jugada
 * @author Santiago Peláez
 *
 */
public class ConsultarExplicacionJugada extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción de consutar la explicación de una jugada
	 * @param categoria
	 */
	public ConsultarExplicacionJugada(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método sobreescrito de opnción de menú que ejecuta el menú para consultar la explicación de una jugada
	 */
	@Override
	public void ejecutar(){
		new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.println("------------------------------------------\nConsultar informacion de un jugador");
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
				System.out.print(this);
				System.out.print("Ingrese el nï¿½mero de la jugada para imprimir su explicaciï¿½n");
				try{
				n = Main.scn.nextInt();
				while(n < 0 || n > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingrï¿½selo de nuevo");
					n = Main.scn.nextInt();
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
				System.out.print("Ingrese el nï¿½mero de la jugada para imprimir su explicaciï¿½n");
				try{
				n = Main.scn.nextInt();
				while(n < 0 || n > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingrï¿½selo de nuevo");
					n = Main.scn.nextInt();
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
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */	
	@Override
	public String toString(){
		return "Consultar Explicacion de una jugada";
	}//Cierre del método
}//Cierre de la clase

