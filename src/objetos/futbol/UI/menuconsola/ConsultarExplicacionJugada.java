package objetos.futbol.UI.menuconsola;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.ImprimirJugadores;
import objetos.futbol.jugadores.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
/**
 * Clase que define la opcion de consultar explicacion de una jugada
 * @author Santiago Pelaez
 *
 */
public class ConsultarExplicacionJugada extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción de consutar la explicacion de una jugada
	 * @param categoria
	 */
	public ConsultarExplicacionJugada(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opncion de menu que ejecuta el menu para consultar la explicacion de una jugada
	 */
	@Override
	public void ejecutar(){
		
		for(int i =0;i<Main.listaJugadasComplejas.size();i++){
			if(i==0){
				Main.v2.ta1.append((i+1)+ Main.listaJugadasComplejas.get(i).getNombre());
			}
			else{
			Main.v2.ta1.append("\n"+ (i+1)+ Main.listaJugadasComplejas.get(i).getNombre());
			}
		}
		if(Main.listaJugadasComplejas.isEmpty()) return;
		Main.v2.ta1.append("\n Ingrese el numero de la jugada que desea consultar");
		Main.tipoOpcion = 2;
		
		
	}//Cierre del método
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */	
	@Override
	public String toString(){
		return "Consultar Explicacion de una jugada";
	}//Cierre del metodo
	
	
}//Cierre de la clase

