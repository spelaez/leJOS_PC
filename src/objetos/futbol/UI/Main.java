package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
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
	public static long tUltimoGol;
	
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
	public static Hashtable<String, Usuario> listaUsuarios = new Hashtable<>();
	public static Usuario usuarioActual; //Usuario logueado
	
	//Lista de Jugadores
	public static ArrayList<Futbolista> listaJugadores = new ArrayList<>();
	
	//Robots
	public static Robot r1, r2;
	
	//Variables de conexion a los robots
	public static NXTConnector conn = new NXTConnector();
	public static boolean connected;
	public static NXTInfo nxt1, nxt2;
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
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
		NXTInfo[] info = conn.search(null, null, NXTCommFactory.BLUETOOTH);
		boolean connected = conn.connectTo("NXT_4", "00165313189D", NXTCommFactory.BLUETOOTH);
	
		
		if (!connected) {
			System.err.println("Failed to connect to any NXT");
			System.exit(1);
		}
		
		dos = new DataOutputStream(conn.getOutputStream());
		dis = new DataInputStream(conn.getInputStream());
		while(connected){
			dos.writeInt(scn.nextInt());
			dos.flush();
			System.out.print(dis.readInt()+" ");
			System.out.println(dis.readInt());
		}
		
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