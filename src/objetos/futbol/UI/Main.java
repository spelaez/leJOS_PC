package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		System.out.println("Bienvenido! \n Para ingresar al sistema escoja una de las siguientes opciones: \n 1. Usuario Jugador. \n 2. Usuario Administrador.");
		int option = scn.nextInt();
		if (option == 1){
			//UsuarioGeneral.logIn(scn.next(), scn.next());
		}
		if (option == 2){
			//UsuarioAdministrador.logIn(scn.next(), scn.next());
		}
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
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		DataInputStream dis = new DataInputStream(conn.getInputStream());
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
	}
}