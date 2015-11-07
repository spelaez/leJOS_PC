package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;
//Clase que define la opcion de consultar la informacion de un jugador
public class ConsultarInfoJugador extends OpcionDeMenu{
	//Método que accesa al tipo de categoria que tiene la opcion de consutar la informacion de un jugador
	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}
	//Método sobreescrito de opciones de menu que ejecuta el menu para consultar la infromacion de un jugador
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
				System.out.print("Dato fuera de rango, por favor ingréselo de nuevo");
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
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	@Override
	public String toString(){
		return "Consultar información de un jugador";
	}
}
