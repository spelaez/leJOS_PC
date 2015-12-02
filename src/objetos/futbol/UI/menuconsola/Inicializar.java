package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;
import javax.swing.JOptionPane;
/**
 * Clase para inicializar el sistema con los robots
 * @author Santiago P�laez
 *
 */
public class Inicializar extends OpcionDeMenu{
	/**
	 * Contructor de la clase que accesa al tipo de categoria que tiene la opcion inicializar
	 * @param categoria
	 */
	public Inicializar(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta la opcion de menu inicializar
	 */
	@Override
	public void ejecutar(){
		JOptionPane.showInputDialog(null,"Elija jugadores", "Elija", JOptionPane.PLAIN_MESSAGE, null, Main.listaJugadores.toArray(), Main.listaJugadores.toArray()[0]);
		if(Main.pausa == false){
			int option=0;
			//System.out.print("-------------------------------------------------------\n"+this);
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
			JOptionPane.showMessageDialog(null, "Buscando NXT disnponibles para conexion...");
			//System.out.print("Buscando NXT disponibles para conexion...\n");
			if(nxtinfo.length == 0){
				JOptionPane.showMessageDialog(null, "No se han encontrado NXT, asegurese de tener el bluetooth activado y visible en los NXT y en el PC", "Advertencia", JOptionPane.WARNING_MESSAGE);
				
				
			}
			else{
				if(nxtinfo[0].name.equals("NXT_3")){
				Main.nxt1 = nxtinfo[0];
				option = 0;
				}
				else{
				Main.nxt1 = nxtinfo[1];
				option = 1;
				}
				for(int i = 0; i < Main.listaJugadores.size(); i++){
					if(Main.listaJugadores.get(i) instanceof Arquero){
						System.out.println((i+1)+" "+(Main.listaJugadores.get(i)));
					}
				}
				//int jugador = Main.scn.nextInt();
				//Main.r1 = new Robot(Main.listaJugadores.get(jugador-1));

			}

			if(nxtinfo.length == 1){
				JOptionPane.showMessageDialog(null, "No se han encontrado NXT, asegurese de tener el bluetooth activado y visible en los NXT y en el PC", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			else{
				option = option == 0 ? 1 : 0;
				for(int i = 0; i < Main.listaJugadores.size(); i++){
					if(Main.listaJugadores.get(i) instanceof Delantero){
						System.out.println((i+1)+" "+(Main.listaJugadores.get(i)));
					}
				}
				//int jugador = Main.scn.nextInt();
				//Main.r2 = new Robot((Delantero)Main.listaJugadores.get(jugador-1));
				Main.nxt2 = nxtinfo[option];
			}
			Main.conn.connectTo(Main.nxt1.name, Main.nxt1.deviceAddress, NXTCommFactory.BLUETOOTH);
			Main.connectedTo = 1;
		}
		else if(Main.pausa == true){
			System.out.println("Porfavor reanude el partido dando la opcion Reanudar partido");
		}
	}//Cierre del m�todo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Inicializar sistema";
	}//Cierre del metodo
}//Cierre de la clase
