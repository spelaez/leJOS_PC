package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.UI.menuconsola.ListaJugadasDisponibles;
import objetos.futbol.jugadores.JugadaCompleja;

import java.util.InputMismatchException;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Clase que define la opción crear jugador, consiste de un ArrayList para guardar las jugadas complejas del jugador nuevo
 * @author Jhon Eider Murrilo
 *
 */
public class CrearJugador extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción crear jugador
	 * @param categoria
	 */
	public CrearJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú de crear jugador
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese tipo jugador");
		System.out.println("1 para delantero \n2 para arquero ");
		try{
			int tipo = Main.scn.nextInt();
			while(tipo < 1 || tipo > 2){
				System.out.print("Dato fuera de rango, por favor ingrï¿½selo de nuevo");
				tipo = Main.scn.nextInt();
			}
			ArrayList<JugadaCompleja> lista = new ArrayList<>(); 
			System.out.println("Ingrese Nombre");
			String nom = Main.scn.next();
			System.out.println("Ingrese Dorsal");
			byte dor = Main.scn.nextByte();
			if(Main.listaJugadasComplejas.size() > 0 ){
				int n;
				while(lista.size()<3){
					new ListaJugadasDisponibles(Categoria.SISTEMA).ejecutar();
					System.out.println("0. Salir");
					try{
						n = Main.scn.nextInt();
						while(n < 0 || n > Main.listaJugadasComplejas.size()){
							System.out.println("Dato fuera de rango, porfavor ingrese un entero");
							n = Main.scn.nextInt();
						}
						n -= 1;
						if(n == -1){
							break;
						}
						else{
							lista.add(Main.listaJugadasComplejas.get(n));	
						}
					}catch(InputMismatchException e){
						System.out.println("Error: Dato incorrecto, ingrese un entero");
					}catch(NumberFormatException e){
						System.out.println("Dato incorrecto, ingrese un entero");
					}catch(IndexOutOfBoundsException e){
						System.out.println("holi");
					}

				}
			}
			else{
				System.out.println("No hay jugadas disponibles, porfavor cree una jugada primero");
				return;
			}
			if(tipo == 1){
				Main.listaJugadores.add(new Delantero(nom,"delantero",(short)0,dor,lista));
			}
			else if( tipo == 2){
				Main.listaJugadores.add(new Arquero(nom,"arquero",0,dor,lista));
			}
		}catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto, ingrese un entero");
		}catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	}

	@Override
	public String toString(){
		return "Crear nuevo Jugador";
	}//Cierre del método
}//Cierre de la clase
