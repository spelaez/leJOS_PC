package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Inicializar extends OpcionDeMenu{

	public Inicializar(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar(){
		
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
		NXTInfo[] nxtinfo = Main.conn.search("NXT_3", null, NXTCommFactory.BLUETOOTH);
		System.out.print("Buscando NXT disponibles para conexion...\n");
		if(nxtinfo.length == 0){
			System.out.println("No se han encontrado NXT, asegurese de tener el bluetooth activado y visible en los NXT y en el PC\n");
		}
		else{
			System.out.println("Estos son los NXT encontrados, por favor seleccione uno para configurar el Arquero\n");
			for(int i = 0; i < nxtinfo.length; i++){
				System.out.println((i+1)+" "+nxtinfo[i].name);
			}
			System.out.print("NXT #: ");
			int option = Main.scn.nextInt();
			Main.nxt1 = nxtinfo[option-1];
			System.out.println("Seleccione de la lista de futbolistas el arquero que desea asignar al robot");
			for(int i = 0; i < Main.listaJugadores.size(); i++){
				if(Main.listaJugadores.get(i) instanceof Arquero){
					System.out.println((i+1)+" "+(Main.listaJugadores.get(i)));
				}
			}
			int jugador = Main.scn.nextInt();
			System.out.println(Main.listaJugadores.get(jugador-1));
			Main.r1 = new Robot(Main.listaJugadores.get(jugador-1));
			boolean connected = Main.conn.connectTo("NXT_3","001653128C89", NXTCommFactory.BLUETOOTH);
			if(connected)System.out.print("Conexion exitosa!");
			Main.dis = new DataInputStream(Main.conn.getInputStream());
			Main.dos = new DataOutputStream(Main.conn.getOutputStream());
		}
		/*
		nxtinfo = Main.conn.search(null, null, NXTCommFactory.BLUETOOTH);
		System.out.print("Buscando NXT disponibles para conexion...\n");
		if(nxtinfo.length == 0){
			System.out.println("No se han encontrado NXT, asegurese de tener el bluetooth activado y visible en los NXT y en el PC\n");
		}
		else{
			System.out.println("Estos son los NXT encontrados, por favor seleccione uno para configurar el Delantero");
			for(int i = 0; i < nxtinfo.length; i++){
				System.out.println((i+1)+" "+nxtinfo[i].name);
			}
			System.out.println("NXT #: ");
			int option = Main.scn.nextInt();
			System.out.println("Seleccione de la lista de futbolistas el delantero que desea asignar al robot");
			for(int i = 0; i < Main.listaJugadores.size(); i++){
				if(Main.listaJugadores.get(i) instanceof Delantero){
					System.out.println((i+1)+" "+(Main.listaJugadores.get(i)));
				}
			}
			int jugador = Main.scn.nextInt();
			Main.r2 = new Robot((Delantero)Main.listaJugadores.get(jugador-1));
			boolean connected = Main.conn.connectTo(nxtinfo[option-1], NXTCommFactory.BLUETOOTH);
			if(connected)System.out.print("Conexion exitosa!");
		}
		Main.dos = new DataOutputStream(Main.conn.getOutputStream());
		Main.dis = new DataInputStream(Main.conn.getInputStream());
		System.out.println();*/

	}
	
	@Override
	public String toString(){
		return "Inicializar sistema";
	}
	
}
