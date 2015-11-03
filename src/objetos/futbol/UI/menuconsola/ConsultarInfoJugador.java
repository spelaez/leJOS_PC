package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultarInfoJugador extends OpcionDeMenu{

	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}
	
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
	
	@Override
	public String toString(){
		return "Consultar información de un jugador";
	}
}
