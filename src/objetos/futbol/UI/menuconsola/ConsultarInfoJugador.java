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
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * Clase que define la opción de consultar la información de un jugador
 * @author Santiago Pelaez
 *
 */
public class ConsultarInfoJugador extends OpcionDeMenu implements ActionListener{
	JFrame jugadores= new JFrame("Seleccion jugador");
	Container contenedor;
	JPanel p1;
	JButton aceptar;
	ButtonGroup bg1;
	String info;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion de consutar la informacion de un jugador
	 * @param categoria
	 */
	public ConsultarInfoJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito de opciones de menu que ejecuta el menu para consultar la informacion de un jugador
	 */
	@Override
	public void ejecutar(){
		contenedor = jugadores.getContentPane();
		p1 = new JPanel();
		p1.setLayout(new GridLayout(12,1));
		contenedor.add(p1);
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		JLabel ind1 = new JLabel("Escoja un jugador");
		p1.add(ind1);
		bg1 = new ButtonGroup();
		generarRadioButton(Main.listaJugadores);
		p1.add(aceptar);
		jugadores.setSize(500,500);
		jugadores.setVisible(true);
		
		
	}
		
		/*new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el numero del jugador a consultar");
		String i = "1";
		try{
			String n = Main.scn.nextLine();
			while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadores.size()){
				System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
				n = Main.scn.nextLine();
			}
			Futbolista x = Main.listaJugadores.get(Integer.valueOf(n)-1);
			if( x instanceof Delantero){
				x = (Delantero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */	
	@Override
	public String toString(){
		return "Consultar informacion de un jugador";
	}//Cierre del metodo
	
	public void actionPerformed(ActionEvent arg0) {
		jugadores.dispose();
		JOptionPane.showMessageDialog(this.jugadores, info);
	}
	public void generarRadioButton(ArrayList<Futbolista> j){
		for(int i=0; i<j.size(); i++){
			JRadioButton z = new JRadioButton(j.get(i).getNombre());
			z.setName(i+"");
			z.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(z.isSelected()){
						info = Main.listaJugadores.get(Integer.parseInt(z.getName())).toString();
					}
				}
			});
			bg1.add(z);
			p1.add(z);
		}
}}//Cierre de la clase

