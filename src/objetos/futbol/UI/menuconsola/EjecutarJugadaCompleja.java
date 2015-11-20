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
 * Clase para ejecutar la opcion de menu
 * @author Jhon Eider Murillo, Santiago Pelaez
 *
 */
public class EjecutarJugadaCompleja extends OpcionDeMenu{
	/**
	 * Constructor de la clase que devuelve de la categoria opcion
	 * @param categoria
	 */
	public EjecutarJugadaCompleja(Categoria categoria){
		super(categoria);
	}//Cierre del contructor
	/**
	 * Metodo que ejecuta el menu para ejecurtar una jugada compleja
	 */
	public void ejecutar(){
		if(Main.pausa==false){
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
					if(Main.tInicio != 0){
						Main.gestorEstado.crearBuffer(Main.r1.getJugador(), Main.r1.getJugador().getListaJugadas().get(Integer.valueOf(ind)-1));
					}
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
					if(Main.tInicio != 0){
						Main.gestorEstado.crearBuffer(Main.r2.getJugador(), Main.r2.getJugador().getListaJugadas().get(Integer.valueOf(ind)-1));
					}
				}catch(NumberFormatException e){
					System.out.println("Porfavor ingrese una jugada de la lista");
				}catch(InputMismatchException e){
					System.out.println("Porfavor ingrese una jugada de la lista");
				}catch(IOException e){
					System.out.println("No existe jugada");
				}
			}
		}
		else if(Main.pausa == true){
			System.out.println("Porfavor reanude el prtido dando la opcion Reanudar partido");
		}
	}//Cierre del metodo
	/**
	 *  Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 *  @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Jugadas Complejas";
	}//Cierre del metodo	
}//Cierre de la clase
