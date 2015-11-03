package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTCommLogListener;
import lejos.pc.comm.NXTConnector;
import java.util.Scanner;
import objetos.futbol.robots.MoverAdelante;

public class Main {	
	
	public static DataOutputStream dos;
	public static DataInputStream dis;
	public static MoverAdelante trotar = new MoverAdelante(1);
	
	
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