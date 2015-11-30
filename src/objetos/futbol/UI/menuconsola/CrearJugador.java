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
 * @author Jhon Eider Murilo
 *
 */
public class CrearJugador extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion crear jugador
	 * @param categoria
	 */
	public CrearJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu de crear jugador
	 */
	@Override
	public void ejecutar(){}
		/*System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese tipo jugador");
		System.out.println("1 Delantero \n2 Arquero ");
		try{
			String tipo = Main.scn.nextLine();
			while(Integer.valueOf(tipo) < 1 || Integer.valueOf(tipo) > 2){
				System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
				tipo = Main.scn.nextLine();
			}
			ArrayList<JugadaCompleja> lista = new ArrayList<>(); 
			System.out.println("Ingrese Nombre");
			String nom = Main.scn.nextLine();
			System.out.println("Ingrese Dorsal");
			String dor = Main.scn.nextLine();
			if(Main.listaJugadasComplejas.size() > 0 ){
				String n;
				while(lista.size()<3){
					new ListaJugadasDisponibles(Categoria.SISTEMA).ejecutar();
					System.out.println("0. Salir");
					try{
						n = Main.scn.nextLine();
						while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadasComplejas.size()){
							System.out.println("Dato fuera de rango, porfavor ingrese un entero");
							n = Main.scn.nextLine();
						}
						n =String.valueOf((Integer.valueOf(n)- 1));
						if(Integer.valueOf(n) == -1){
							break;
						}
						else{
							lista.add(Main.listaJugadasComplejas.get(Integer.valueOf(n)));	
						}
					}catch(InputMismatchException e){
						System.out.println("Error: Dato incorrecto, ingrese un entero");
					}catch(NumberFormatException e){
						System.out.println("Dato incorrecto, ingrese un entero");
					}catch(IndexOutOfBoundsException e){
						System.out.println("Dato fuera de rango");
					}
				}
			}
			else{
				System.out.println("No hay jugadas disponibles, porfavor cree una jugada primero");
				return;
			}
			if(Integer.valueOf(tipo) == 1){
				Main.listaJugadores.add(new Delantero(nom,"delantero",(short)0,Byte.valueOf(dor),lista));
			}
			else if( Integer.valueOf(tipo) == 2){
				Main.listaJugadores.add(new Arquero(nom,"arquero",0,Byte.valueOf(dor),lista));
			}
		}catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto, ingrese un entero");
		}catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}

	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Crear nuevo Jugador";
	}//Cierre del metodo
}//Cierre de la clase
