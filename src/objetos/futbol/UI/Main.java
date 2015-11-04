package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;

import java.util.ArrayList;
import java.util.Scanner;
import objetos.futbol.robots.MoverAdelante;
import objetos.futbol.robots.MoverAtras;
import objetos.futbol.robots.Chutar;
import objetos.futbol.robots.Girar;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.Usuario;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.robots.Robot;

public class Main {	
	
	//Atributos para manejar el tiempo
	public static long tInicio;
	public static long tPausa;
	public static long tFinal;
	public static long tSinGoles;
	
	//Objetos de lectura y escritura hacia los robots
	public static DataOutputStream dos;
	public static DataInputStream dis;
	
	//Jugadas primitivas definidas para todos
	public static MoverAdelante trotar = new MoverAdelante(1);
	public static MoverAdelante correr = new MoverAdelante(2);
	public static MoverAtras retroceder = new MoverAtras(1);
	public static Girar girarDerecha = new Girar(1, 45);
	public static Girar girarIzquierda = new Girar(1,-45);
	public static Chutar chutar = new Chutar(1, -10);
	public static Chutar patear = new Chutar(2, -10);
	
	//Lista de JugadasComplejas
	public static ArrayList<JugadaCompleja> listaJugadasComplejas = new ArrayList<>();
	
	//Lista de Usuarios
	public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	public static Usuario usuarioActual; //Usuario logueado
	
	//Lista de Jugadores
	public static ArrayList<Futbolista> listaJugadores = new ArrayList<>();
	
	//Robots
	public static Robot r1, r2;
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		NXTConnector conn = new NXTConnector();
		conn.addLogListener(new NXTCommLogListener(){

			public void logEvent(String message) {
				System.out.println("BTSend Log.listener: "+message);
				
			}

			public void logEvent(Throwable throwable) {
				System.out.println("BTSend Log.listener - stack trace: ");
				 throwable.printStackTrace();
				
			}
			
		} 
		);
		// Connect to any NXT over Bluetooth
		boolean connected = conn.connectTo("btspp://");
	
		
		if (!connected) {
			System.err.println("Failed to connect to any NXT");
			System.exit(1);
		}
		
		dos = new DataOutputStream(conn.getOutputStream());
		dis = new DataInputStream(conn.getInputStream());
		dos.writeInt(scn.nextInt());
		dos.flush();
		dos.writeInt(scn.nextInt());
		dos.flush();
		
		try {
			dis.close();
			dos.close();
			conn.close();
		} catch (IOException ioe) {
			System.out.println("IOException closing connection:");
			System.out.println(ioe.getMessage());
		}
		scn.close();
	}
}