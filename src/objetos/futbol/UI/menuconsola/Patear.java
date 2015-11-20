package objetos.futbol.UI.menuconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import objetos.futbol.UI.Main;
/**
 * Clase para definir la opci�n patear
 * @author Juan Pablo Betancur
 *
 */
public class Patear extends OpcionDeMenu{
	/**
	 * constructor para define patear dependeiendo la categoria
	 * @param categoria
	 */
	public Patear(Categoria categoria){
		super(categoria);
	}//Cierre del cosntructor
	/**
	 * M�todo sobreescrito de opci�n de men�, que imprime el tipo de opci�n, y llama a un m�todo de la clase main del paquete objetos.futbol.UI para enviarla al robot 
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa==false){
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
				Main.dos.writeInt(Main.patear.getIdJugada());
				Main.dos.flush();

				//Hacemos caso omiso de los datos mandados por el robot ya que al chutar la posicion no se actualiza
				Main.dis.readInt();
				Main.dis.readInt();

			}
			catch(IOException e){
				System.out.print("No se pudo ejecutar la jugada");
			}
		}
		else if(Main.pausa == true){
			System.out.println("Porfavor reanude el prtido dando la opcion Reanudar partido");
		}
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Patear";
	}//Cierre del m�todo
}//Cierre de la clase
