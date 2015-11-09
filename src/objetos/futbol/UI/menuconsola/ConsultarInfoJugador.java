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
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el numero del jugador a consultar");
		int i = 1;
		try{
			int n = Main.scn.nextInt();
			while(n < 0 || n > Main.listaJugadores.size()){
				System.out.print("Dato fuera de rango, por favor ingr�selo de nuevo");
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
	
		Main.usuarioActual.lanzarMenu();
	}
	
	@Override
	public String toString(){
		return "Consultar informaci�n de un jugador";
	}
}
