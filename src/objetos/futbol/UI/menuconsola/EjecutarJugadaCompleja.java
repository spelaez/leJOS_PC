package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EjecutarJugadaCompleja extends OpcionDeMenu{

	public EjecutarJugadaCompleja(Categoria categoria){
		super(categoria);
	}
	
	public void ejecutar(){
		Scanner scn = new Scanner(System.in);
		if(categoria == Categoria.ARQUERO){
			System.out.println("------------------------------------------\n"+this);
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r1.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				int ind = scn.nextInt();
				while(ind != 1|| ind!=2||ind!=3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = scn.nextInt();
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
			System.out.println("------------------------------------------\n"+this);
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r2.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				int ind = scn.nextInt();
				while(ind != 1|| ind!=2||ind!=3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = scn.nextInt();
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
		scn.close();
		Main.usuarioActual.lanzarMenu();
	}
	
	@Override
	public String toString(){
		return "Jugadas Disponibles";
	}
	
}
