package objetos.futbol.UI.menuconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.pc.comm.NXTCommFactory;
import objetos.futbol.UI.Main;
/**
 * Clase que define la opcion girar a la izquierda
 * @author Juan Pablo Betancur
 *
 */
public class GirarIzquierda extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion girar a la izquierda
	 * @param categoria
	 */
	public GirarIzquierda(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu para girar a la izquerda
	 */
	@Override
	public void ejecutar(){
		if(Main.pausa == false){
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
				Main.dos.writeInt(Main.girarIzquierda.getIdJugada());
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
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Girar a la izquierda";
	}//Cierre del metodo
}//cierre de la clase
