package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaCompleja;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	 * Metodo que ejecuta el menu para ejecurtar una jugada compleja a traves de una interfaz
	 */
	JFrame jugadas = new JFrame("Seleccion jugada a ejecutar");
	Container contenedor;
	JPanel p1,p2,pg;
	JButton aceptar;
	ButtonGroup bg1, bg2;
	public void ejecutar(){
		Main.tipoOpcion =3;
		Main.v2.ta1.setText(null);
		if(Main.pausa==false){
			if(categoria == Categoria.ARQUERO){
				Main.aux =1;
				System.out.print("---------------------------------------------------\n"+this+"\n");
				ArrayList<JugadaCompleja> list = new ArrayList<>();
				list = Main.r1.getJugador().getListaJugadas();
				
				for(int i = 0 ; i< list.size();i++){
					Main.v2.ta1.append("\n"+(i+1) +" "+ list.get(i).getNombre());
				}
				Main.v2.ta1.append("\n Porfavor escoja una jugada");
				
			}

			else if(categoria == Categoria.DELANTERO){
				Main.aux =2;
				ArrayList<JugadaCompleja> list = new ArrayList<>();
				list = Main.r2.getJugador().getListaJugadas();
				for(int i = 0 ; i< list.size();i++){
					Main.v2.ta1.append("\n"+(i+1) +" "+ list.get(i).getNombre());
				}
				Main.v2.ta1.append("\n Porfavor escoja una jugada");
				
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
