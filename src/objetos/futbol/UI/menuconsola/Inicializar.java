package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

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
		jugadores.setSize(400, 400);
		//jugadores.setLayout(new FlowLayout(FlowLayout.LEFT));
		setLayout(new FlowLayout());
		jugadores.setLocationRelativeTo(null);
		JLabel title = new JLabel("Lista de jugadores");
		jugadores.add(title);
		generarCheckBox(Main.listaJugadores);
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
			jugadores.add(x);
		}
	}
}//Cierre de la clase
