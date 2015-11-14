package objetos.futbol.UI.menuconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import objetos.futbol.UI.Main;
/**
 * Clase que define la opci�n retroceder
 * @author Juan Pablo Betancur
 *
 */
public class Retroceder extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n retroceder
	 * @param categoria
	 */
	public Retroceder(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo sobreescrito de opcion de men�, que imprime el tipo de opci�n, y llama a un m�todo de la clase main del paquete objetos.futbol.UI para enviarla al robot
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		try{
			if(categoria == Categoria.ARQUERO && Main.connectedTo == 2){
				Main.dos.writeInt(0);
				Main.dos.close();
				Main.dis.close();
				Main.conn.close();
				Main.conn.connectTo(Main.nxt1.name, Main.nxt1.deviceAddress, NXTCommFactory.BLUETOOTH);
				Main.connectedTo = 1;
			}
			else if(categoria == Categoria.DELANTERO && Main.connectedTo == 1){
				Main.dos.writeInt(0);
				Main.dos.close();
				Main.dis.close();
				Main.conn.close();
				Main.conn.connectTo(Main.nxt2.name, Main.nxt2.deviceAddress, NXTCommFactory.BLUETOOTH);
				Main.connectedTo = 2;
			}
			Main.dis = new DataInputStream(Main.conn.getInputStream());
			Main.dos = new DataOutputStream(Main.conn.getOutputStream());
			Main.dos.writeInt(Main.retroceder.getIdJugada());
			Main.dos.flush();
			if(categoria == Categoria.ARQUERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r1);
			}
			else if(categoria == Categoria.DELANTERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(), Main.r2);
			}
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retrona el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Retroceder";
	}//Cierre del m�todo
}//Cierre de la clase
