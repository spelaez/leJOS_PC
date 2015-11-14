package objetos.futbol.UI.menuconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import objetos.futbol.UI.Main;
/**
 * Clase para definir la opci�n girar a la derecha
 * @author Juan Pablo Betancur
 *
 */
public class GirarDerecha extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion girar a la derecha
	 * @param categoria
	 */
	public GirarDerecha(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que ejecuta el men� para girar a la derecha
	 */
	@Override
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		try{
			if(categoria == Categoria.ARQUERO && Main.connectedTo == 2){
				Main.conn.close();
				Main.conn.connectTo(Main.nxt1.name, Main.nxt1.deviceAddress, NXTCommFactory.BLUETOOTH);
				Main.connectedTo = 1;
			}
			else if(categoria == Categoria.DELANTERO && Main.connectedTo == 1){
				Main.conn.close();
				Main.conn.connectTo(Main.nxt2.name, Main.nxt2.deviceAddress, NXTCommFactory.BLUETOOTH);
				Main.connectedTo = 2;
			}
			Main.dis = new DataInputStream(Main.conn.getInputStream());
			Main.dos = new DataOutputStream(Main.conn.getOutputStream());
			Main.dos.writeInt(Main.girarDerecha.getIdJugada());
			Main.dos.flush();
			if( categoria == Categoria.ARQUERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(),Main.r1);
			}
			else if(categoria== Categoria.DELANTERO){
				Main.cancha.actualizarPosicion(Main.dis.readInt(), Main.dis.readInt(),Main.r2);
			}
		}
		catch(IOException e){
			System.out.print("No se pudo ejecutar la jugada");
		}
	}//Cierre del m�todo 
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Girar a la derecha";
	}//Cierre del m�todo
}//Cierre dela clase
