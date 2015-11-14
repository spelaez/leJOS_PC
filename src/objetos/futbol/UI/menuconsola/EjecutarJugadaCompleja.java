package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import lejos.pc.comm.NXTCommFactory;
/**
 * Clase para ejecutar la opci�n de men�
 * @author Jhon Eider Murillo, Santiago P�laez
 *
 */
public class EjecutarJugadaCompleja extends OpcionDeMenu{
	/**
	 * Constructor de la clase que devuelve de la categoria opci�n
	 * @param categoria
	 */
	public EjecutarJugadaCompleja(Categoria categoria){
		super(categoria);
	}//Cierre del contructor
	/**
	 * M�todo que ejecuta el men� para ejecurtar una jugada compleja
	 */
	public void ejecutar(){
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
		}
		catch(IOException e){
			e.printStackTrace();
		}
		Main.dis = new DataInputStream(Main.conn.getInputStream());
		Main.dos = new DataOutputStream(Main.conn.getOutputStream());
		if(categoria == Categoria.ARQUERO){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r1.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				String ind = Main.scn.nextLine();
				while(Integer.valueOf(ind) < 1 || Integer.valueOf(ind) > 3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = Main.scn.nextLine();
				}
				Main.r1.ejecutarJugadaCompleja(Integer.valueOf(ind)-1);
				Main.gestorEstado.crearBuffer(Main.r1.getJugador(), Main.r1.getJugador().getListaJugadas().get(Integer.valueOf(ind)-1));
			}catch(NumberFormatException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(InputMismatchException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(IOException e){
				System.out.println("No existe jugada");
			}
		}
		
		else if(categoria == Categoria.DELANTERO){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			ArrayList<JugadaCompleja> list = new ArrayList<>();
			list = Main.r2.getJugador().getListaJugadas();
			for(int i = 0 ; i< list.size();i++){
				System.out.println((i+1) +" "+ list.get(i).getNombre());
			}
			System.out.println("Porfavor escoja una jugada");
			try{
				String ind = Main.scn.nextLine();
				while(Integer.valueOf(ind) < 1 || Integer.valueOf(ind) > 3){
					System.out.println("Porfavor ingrese una jugada de la lista");
					ind = Main.scn.nextLine();
				}
				Main.r2.ejecutarJugadaCompleja(Integer.valueOf(ind)-1);
			}catch(NumberFormatException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(InputMismatchException e){
				System.out.println("Porfavor ingrese una jugada de la lista");
			}catch(IOException e){
				System.out.println("No existe jugada");
			}
		}
	}//Cierre del m�todo
	/**
	 *  M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 *  @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Jugadas Complejas";
	}//Cierre del m�todo	
}//Cierre de la clase
