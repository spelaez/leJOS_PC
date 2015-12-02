package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * Clase para inicializar el sistema con los robots
 * @author Santiago P�laez
 *
 */
@SuppressWarnings("serial")
public class Inicializar extends OpcionDeMenu{
	JFrame jugadores = new JFrame("Seleccion de jugadores");
	Container contenedor;
	JPanel p1,p2;
	JButton aceptar;
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
		contenedor = this.getRootPane();
		jugadores.setLayout(new GridLayout(1,2));
		p1 = new JPanel();
		p1.setLayout(new GridLayout(10,1));
		p2 = new JPanel();
		p2.setLayout(new GridLayout(10,1));
		aceptar = new JButton("Aceptar");
		jugadores.add(p1);
		jugadores.add(p2);
		jugadores.setSize(400, 400);
		//jugadores.setLayout(new FlowLayout(FlowLayout.LEFT));
		//jugadores.setLayout(new GridLayout(10,1));
		jugadores.setLocationRelativeTo(null);
		JLabel ind1 = new JLabel("Escoja un Arquero");
		JLabel ind2 = new JLabel("Escoja un Delantero");
		p1.add(ind1);
		p2.add(ind2);
		generarCheckBox(Main.listaJugadores);
		p1.add(aceptar);
		jugadores.setVisible(true);
				
			Main.conn.addLogListener(new NXTCommLogListener(){
				public void logEvent(String message){
					System.out.println("BTSend Log.listener: "+message);
				}

				public void logEvent(Throwable throwable){
					System.out.print("BTSend Log.listener - stack trace: ");
					throwable.printStackTrace();
				}
			});
			
	}//Cierre del m�todo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Inicializar sistema";
	}//Cierre del metodo

	public void generarCheckBox(ArrayList<Futbolista> j){
		for(int i=0; i<j.size(); i++){
			JCheckBox x = new JCheckBox(j.get(i).getNombre());
			if(j.get(i) instanceof Arquero){
			p1.add(x);
			}
			else if (j.get(i) instanceof Delantero){
				p2.add(x);
			}
		}
	}
}//Cierre de la clase
