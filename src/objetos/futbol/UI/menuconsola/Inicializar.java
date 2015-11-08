package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;
import java.util.Scanner;
/**
 * Clase que define la opción incicializar
 * @author Santiago Peláez
 *
 */
public class Inicializar extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción inicializar
	 * @param categoria
	 */
	public Inicializar(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú para inicializar
	 */
	@Override
	public void ejecutar(){
		Scanner scn = new Scanner(System.in);
		System.out.print("-------------------------------------------------------\n"+this);
		Main.conn.addLogListener(new NXTCommLogListener(){
			public void logEvent(String message){
				System.out.println("BTSend Log.listener: "+message);
			}
			
			public void logEvent(Throwable throwable){
				System.out.print("BTSend Log.listener - stack trace: ");
				throwable.printStackTrace();
			}
		});
		NXTInfo[] nxtinfo = Main.conn.search(null, null, NXTCommFactory.BLUETOOTH);
		System.out.print("Buscando NXT disponibles para conexiÃ³n...");
		if(nxtinfo.length == 0){
			System.out.println("No se han encontrado NXT, asegÃºrese de tener el bluetooth activado y visible en los NXT y en el PC");
		}
		else{
			System.out.println("Estos son los NXT encontrados, por favor seleccione uno para configurar el Arquero");
			for(int i = 0; i < nxtinfo.length; i++){
				System.out.print((i+1)+" "+nxtinfo[i].name);
			}
			System.out.print("NXT #: ");
			int option = scn.nextInt();
			System.out.print("Seleccione de la lista de futbolistas el arquero que desea asignar al robot");
			for(int i = 0; i < Main.listaJugadores.size(); i++){
				if(Main.listaJugadores.get(i) instanceof Arquero){
					System.out.print((i+1)+" "+(Main.listaJugadores.get(i)));
				}
			}
			int jugador = scn.nextInt();
			Main.r1 = new Robot((Arquero)Main.listaJugadores.get(jugador-1));
			Main.conn.connectTo(nxtinfo[option-1], NXTCommFactory.BLUETOOTH);
			System.out.print("ConexiÃ³n exitosa!");
		}
		
		nxtinfo = Main.conn.search(null, null, NXTCommFactory.BLUETOOTH);
		System.out.print("Buscando NXT disponibles para conexiÃ³n...");
		if(nxtinfo.length == 0){
			System.out.println("No se han encontrado NXT, asegÃºrese de tener el bluetooth activado y visible en los NXT y en el PC");
		}
		else{
			System.out.println("Estos son los NXT encontrados, por favor seleccione uno para configurar el Delantero");
			for(int i = 0; i < nxtinfo.length; i++){
				System.out.print((i+1)+" "+nxtinfo[i].name);
			}
			System.out.print("NXT #: ");
			int option = scn.nextInt();
			System.out.print("Seleccione de la lista de futbolistas el delantero que desea asignar al robot");
			for(int i = 0; i < Main.listaJugadores.size(); i++){
				if(Main.listaJugadores.get(i) instanceof Delantero){
					System.out.print((i+1)+" "+(Main.listaJugadores.get(i)));
				}
			}
			int jugador = scn.nextInt();
			Main.r2 = new Robot((Delantero)Main.listaJugadores.get(jugador-1));
			Main.conn.connectTo(nxtinfo[option-1], NXTCommFactory.BLUETOOTH);
			System.out.print("ConexiÃ³n exitosa!");
		}
		
		
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción 
	 */
	@Override
	public String toString(){
		return "Inicializando sistema...";
	}//Cierre del método
	
}//Cierre de la clase
