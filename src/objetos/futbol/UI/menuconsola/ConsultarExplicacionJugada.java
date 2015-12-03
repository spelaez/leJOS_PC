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
public class ConsultarExplicacionJugada extends OpcionDeMenu implements ActionListener{
	JFrame jugadores = new JFrame("Seleccion de jugadores");
	Container contenedor;
	JPanel p1,p2;
	JButton aceptar;
	ButtonGroup bg1, bg2;
	String explicacion;
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
		contenedor = jugadores.getContentPane();
		p1 = new JPanel();
		p1.setLayout(new GridLayout(10,2));
		contenedor.add(p1);
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		JLabel ind1 = new JLabel("Escoja un jugador");
		p1.add(ind1);
		bg1 = new ButtonGroup();
		generarRadioButton(Main.listaJugadasComplejas);
		p1.add(aceptar);
		jugadores.setSize(400, 400);
		jugadores.setVisible(true);
		
		
	}
		/*new ImprimirJugadores(Categoria.SISTEMA).ejecutar();
		if(Main.listaJugadores.isEmpty()) return;
		System.out.println("------------------------------------------\nConsultar informacion de un jugador");
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
				System.out.print(this);
				System.out.print("Ingrese el numero de la jugada para imprimir su explicacion");
				try{
				n = Main.scn.nextLine();
				while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
					n = Main.scn.nextLine();
				}
				System.out.print(x.getListaJugadas().get(Integer.valueOf(n)-1).getExplicacion());
				}
				catch(NumberFormatException e){
					System.out.println("Dato incorrecto, ingrese un entero");
				}
				catch(InputMismatchException e){
					System.out.println("Error: dato incorrecto");
				}
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				System.out.println(x);
				for(JugadaCompleja c : x.getListaJugadas()){
					
					System.out.println(i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
				System.out.print(this);
				System.out.print("Ingrese el numero de la jugada para imprimir su explicacion");
				try{
				n = Main.scn.nextLine();
				while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > x.getListaJugadas().size()){
					System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
					n = Main.scn.nextLine();
				}
				System.out.print(x.getListaJugadas().get(Integer.valueOf(n)-1).getExplicacion());
				}
				catch(NumberFormatException e){
					System.out.println("Dato incorrecto, ingrese un entero");
				}
				catch(InputMismatchException e){
					System.out.println("Error: dato incorrecto");
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}
	}//Cierre del método
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */	
	@Override
	public String toString(){
		return "Consultar Explicacion de una jugada";
	}//Cierre del metodo
	@Override
	public void actionPerformed(ActionEvent arg0) {
		jugadores.dispose();
		JOptionPane.showMessageDialog(this.jugadores, explicacion);
	}
	public void generarRadioButton(ArrayList<JugadaCompleja> j){
		for(int i=0; i<j.size(); i++){
			JRadioButton z = new JRadioButton(j.get(i).getNombre());
			z.setName(i+"");
			z.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					if(z.isSelected()){
						explicacion = Main.listaJugadasComplejas.get(Integer.parseInt(z.getName())).getExplicacion();
					}
				}
			});
			bg1.add(z);
			p1.add(z);
		}
		
	}
}//Cierre de la clase

