package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.robots.Robot;
import lejos.pc.comm.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * Clase para inicializar el sistema con los robots
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public class Inicializar extends OpcionDeMenu implements ActionListener{
	JFrame jugadores = new JFrame("Seleccion de jugadores");
	Container contenedor;
	JPanel p1,p2,pg;
	JButton aceptar;
	ButtonGroup bg1, bg2;
	/**
	 * Contructor de la clase que accesa al tipo de categoria que tiene la opcion inicializar
	 * @param categoria
	 */
	public Inicializar(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta la opcion de menu inicializar por medio de la implementacion de interfaz grafica
	 */
	@Override
	public void ejecutar(){
		contenedor = jugadores.getContentPane();
		pg = new JPanel();
		pg.setLayout(new GridLayout(1,2));
		contenedor.add(pg);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(10,1));
		p2 = new JPanel();
		p2.setLayout(new GridLayout(10,1));
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		pg.add(p1);
		pg.add(p2);
		jugadores.setSize(400, 400);
		jugadores.setLocationRelativeTo(null);
		JLabel ind1 = new JLabel("Escoja un Arquero");
		JLabel ind2 = new JLabel("Escoja un Delantero");
		p1.add(ind1);
		p2.add(ind2);
		bg1 = new ButtonGroup();
		bg2 = new ButtonGroup();
		generarRadioButton(Main.listaJugadores);
		p1.add(aceptar);
		jugadores.setVisible(true);
				
			Main.conn1.addLogListener(new NXTCommLogListener(){
				/**
				 * Metodo para mostrar un mensaje
				 */
				public void logEvent(String message){
					System.out.println("BTSend Log.listener: "+message);
				}

				public void logEvent(Throwable throwable){
					/**
					 * Metodo para mostrar un mensaje
					 */
					System.out.print("BTSend Log.listener - stack trace: ");
					throwable.printStackTrace();
				}
			});
			
			Main.conn2.addLogListener(new NXTCommLogListener(){
				/**
				 * Metodo para mostrar un mensaje
				 */
				public void logEvent(String message){
					System.out.println("BTSend Log.listener: "+message);
				}
				/**
				 * Metodo para mostrar un mensaje
				 */
				public void logEvent(Throwable throwable){
					System.out.print("BTSend Log.listener - stack trace: ");
					throwable.printStackTrace();
				}
			});
			

	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Inicializar sistema";
	}//Cierre del metodo
	/**
	 * Metodo para generar radiobotones
	 * @param j
	 */
	public void generarRadioButton(ArrayList<Futbolista> j){
		for(int i=0; i<j.size(); i++){
			JRadioButton z = new JRadioButton(j.get(i).getNombre());
			z.setName(i+"");
			z.addItemListener(new ItemListener() {
				/**
				 * Metodo para definir los eventos seleecionados por el usuario en la interfaz
				 */
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(z.isSelected()){
						if(Main.listaJugadores.get(Integer.parseInt(z.getName())) instanceof Arquero)
						{
							Main.r1 = new Robot(Main.listaJugadores.get(Integer.parseInt(z.getName())));
							System.out.println(Main.r1.getJugador().getNombre());
						}
						else if (Main.listaJugadores.get(Integer.parseInt(z.getName())) instanceof Delantero){
							Main.r2 = new Robot(Main.listaJugadores.get(Integer.parseInt(z.getName())));
							System.out.println(Main.r2.getJugador().getNombre());
						}
						}
					
				}//Cierre del metodo
			});
			if(j.get(i) instanceof Arquero){
				bg1.add(z);
			p1.add(z);
			}
			else if (j.get(i) instanceof Delantero){
				bg2.add(z);
				p2.add(z);
			}
		}
	}//Cierre del metodo
	/**
	 * Metodo que se ejecuta por una accion en la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		jugadores.dispose();
		JOptionPane.showMessageDialog(this.jugadores, "Conectando a los NXT...");
		conectar();
		try {
			Main.cancha.cargarImagenes();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}//Cierre del metodo
	/**
	 * Metodo para conectar el sistema con los robots
	 */
	public void conectar(){
		
		NXTInfo info[] = Main.conn1.search(null, null, NXTCommFactory.BLUETOOTH);
		
		if(info.length > 0){
		if(info[0].name.equals("NXT_3")){
			Main.nxt1=info[0];
			Main.nxt2=info[1];
		}
		else{
			Main.nxt1=info[1];
			Main.nxt2=info[0];
		}
		Main.conn1.connectTo(Main.nxt1.name, Main.nxt1.deviceAddress, NXTCommFactory.BLUETOOTH);
		Main.dis1 = new DataInputStream(Main.conn1.getInputStream());
		Main.dos1 = new DataOutputStream(Main.conn1.getOutputStream());
		
		Main.conn2.connectTo(Main.nxt2.name, Main.nxt2.deviceAddress, NXTCommFactory.BLUETOOTH);
		Main.dis2 = new DataInputStream(Main.conn1.getInputStream());
		Main.dos2 = new DataOutputStream(Main.conn1.getOutputStream());
		return;
		}
	}//Cierre del metodo
}//Cierre de la clase
